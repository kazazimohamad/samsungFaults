package com.samsungfaults.zilu.samsungfaults;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class StationActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private DatabaseHelper databaseHelper;
    private StationListAdapter stationListAdaptor;
    private List<StationModel> stationsModels;

    private EditText etCode;
    private EditText etFaName;
    private EditText etEnName;
    private EditText etDetails;
    private Spinner spData;
    private Button btnDo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_station);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.stationsRecyclerView);
        databaseHelper = new DatabaseHelper(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        stationsModels = databaseHelper.getAllStation();
        stationListAdaptor = new StationListAdapter(this, stationsModels);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(stationListAdaptor);

        etCode = (EditText) findViewById(R.id.etCode);
        etFaName = (EditText) findViewById(R.id.etFaName);
        etEnName = (EditText) findViewById(R.id.etEnName);
        etDetails = (EditText) findViewById(R.id.etDetails);
        spData = (Spinner) findViewById(R.id.spData);

        ArrayList<groupsModel> groups = new DatabaseHelper(this).getAllGroups();
        // Creating adapter for spinner
        StationAdapter dataAdapter = new StationAdapter(this, groups);

        // attaching data adapter to spinner
        spData.setAdapter(dataAdapter);
        btnDo = (Button) findViewById(R.id.btnDo);
        btnDo.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnDo:
            StationModel stationModel = new StationModel();
            stationModel.setId(etCode.getText().toString());
            stationModel.setGroupId(spData.getSelectedItemId());
            stationModel.setFaName(etFaName.getText().toString());
            stationModel.setEnName(etEnName.getText().toString());
            stationModel.setDetails(etDetails.getText().toString());
            new DatabaseHelper(this).createStation(stationModel);

            stationsModels.add(stationModel);
            stationListAdaptor.notifyDataSetChanged();
            break;
        }
    }
}
