package com.samsungfaults.zilu.samsungfaults;

import android.app.ActionBar;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 1/3/2018.
 */

public class AddFaultDialog extends Dialog implements View.OnClickListener {

    private  Context context;
    private  Adding listener;
    private Spinner spGroup;
    private Spinner spGroupStation;

    public AddFaultDialog(@NonNull Context context, Adding listener) {
        super(context);
        this.context = context;
        this.listener=listener;
    }

    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.dialog_add_fault);
        setTitle("Add Fault");
        getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        spGroupStation = (Spinner) findViewById(R.id.spGroupStation);
        spGroup = (Spinner) findViewById(R.id.spGroup);
        ArrayList<groupsModel> groups = new DatabaseHelper(context).getAllGroups();
        // Creating adapter for spinner
        StationAdapter dataAdapter = new StationAdapter(context, groups);

        // attaching data adapter to spinner
        spGroup.setAdapter(dataAdapter);


        spGroup.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                List<StationModel> stationModels = new DatabaseHelper(context).getAllStationByGroup(id);
                StationFaultGroupAdapter dataAdapter = new StationFaultGroupAdapter(context, stationModels);

                // attaching data adapter to spinner
                spGroupStation.setAdapter(dataAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAdd:
                Toast.makeText(context, "Hiiiiii", Toast.LENGTH_LONG).show();
                break;
        }
    }

    @Override
    public void dismiss() {
        super.dismiss();
        listener.finishAdding();
    }

    public interface Adding{
        void finishAdding();
    }
}
