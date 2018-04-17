package com.samsungfaults.zilu.samsungfaults;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import java.util.List;

/**
 * Created by haniyehkhaksar on 1/19/18.
 */

public class AddReportDialog extends Dialog implements View.OnClickListener {

    private Context context;
    private AddReportDialog.Adding listener;
    private Spinner spModel, spStation, spError;

    public AddReportDialog(@NonNull Context context, AddReportDialog.Adding listener) {
        super(context);
        this.context = context;
        this.listener = listener;
    }

    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.dialog_add_report);
        setTitle("Add Fault");
        getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        spModel = (Spinner) findViewById(R.id.spModel);
        spStation = (Spinner) findViewById(R.id.spStation);
        spError = (Spinner) findViewById(R.id.spError);

        List<ProductModel> models = new DatabaseHelper(context).getAllModel();
        ModelSpinnerAdapter modelAdapter = new ModelSpinnerAdapter(getContext(), models);
        spModel.setAdapter(modelAdapter);


        List<StationModel> stationModels = new DatabaseHelper(context).getAllStation();
        StationSpinerAdapter stationAdapter = new StationSpinerAdapter(context, stationModels);
        spStation.setAdapter(stationAdapter);
        spStation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long id) {
                StationModel stationModel = (StationModel) spStation.getSelectedItem();
                List<StationFaultModel> faultModels = new DatabaseHelper(context).getAllStationFaultsByStationId(stationModel.getId());
                StationFaultSpinnerAdapter faultAdapter = new StationFaultSpinnerAdapter(context, faultModels);
                spError.setAdapter(faultAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAdd:
                new DatabaseHelper(getContext()).insertReport(
                        ((ProductModel)spModel.getSelectedItem()).getProductName(),
                        ((StationModel)spStation.getSelectedItem()).getFaName(),
                        ((StationFaultModel)spError.getSelectedItem()).getStaFaultName(), 1);
                listener.finishAdding();
                dismiss();
                break;
        }
    }

    public interface Adding {
        void finishAdding();
    }
}