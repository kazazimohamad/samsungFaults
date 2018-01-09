package com.samsungfaults.zilu.samsungfaults;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class StationFaultsActivity extends AppCompatActivity implements View.OnClickListener  {

    private RecyclerView recyclerView;
    private DatabaseHelper databaseHelper;
    private StationSpinerAdapter stationSpinerAdapter;
    private StationFaultsListAdapter stationFaultsListAdapter;
    private List<StationFaultModel> stationFaultModel;

//    private Spinner spGroup;
//    private Spinner spGroupStation;
    private Spinner spStations;
    private EditText etStationFaultCode;
    private EditText etStationFaultFaName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_station_faults);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.stationsFaultRecyclerView);
        databaseHelper = new DatabaseHelper(this);
        spStations = (Spinner) findViewById(R.id.spStationFault);
        etStationFaultCode = (EditText) findViewById(R.id.etStationFaultCode);
        etStationFaultFaName = (EditText) findViewById(R.id.etStationFaultFaName);

        stationFaultModel = databaseHelper.getAllStationFaults();
        stationFaultsListAdapter = new StationFaultsListAdapter(this, stationFaultModel);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(stationFaultsListAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StationFaultModel stationFaultModel = new StationFaultModel();
                stationFaultModel.setStaFaultCode(etStationFaultCode.getText().toString());
                stationFaultModel.setStaFaultName(etStationFaultFaName.getText().toString());
                stationFaultModel.setStaFaultStationId(((StationModel)spStations.getSelectedItem()).getId());

                databaseHelper.createStationFault(stationFaultModel);

                Snackbar.make(view, "مورد جدید اضافه شد", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        List<StationModel> groups = new DatabaseHelper(this).getAllStation();
        // Creating adapter for spinner
        StationSpinerAdapter dataAdapter = new StationSpinerAdapter(this, (ArrayList<StationModel>) groups);

        // attaching data adapter to spinner
        spStations.setAdapter(dataAdapter);



//        spGroupStation = (Spinner) findViewById(R.id.spGroupStation);
//        spGroup = (Spinner) findViewById(R.id.spGroup);
//        ArrayList<groupsModel> groups = new DatabaseHelper(this).getAllGroups();
//        // Creating adapter for spinner
//        StationAdapter dataAdapter = new StationAdapter(this, groups);
//
//        // attaching data adapter to spinner
//        spGroup.setAdapter(dataAdapter);
//
//        spGroup.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                List<StationModel> stationModels = new DatabaseHelper(StationFaultsActivity.this).getAllStationByGroup(id);
//                StationFaultGroupAdapter dataAdapter = new StationFaultGroupAdapter(StationFaultsActivity.this, stationModels);
//
//                // attaching data adapter to spinner
//                spGroupStation.setAdapter(dataAdapter);
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });

    }

    @Override
    public void onClick(View v) {

    }
}
