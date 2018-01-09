package com.samsungfaults.zilu.samsungfaults;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class FaultActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etData;
    private Spinner spData;
    private Button btnDo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fault);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        etData = (EditText) findViewById(R.id.etData);
        spData= (Spinner) findViewById(R.id.spData);

        List<groupsModel> groups = new DatabaseHelper(this).getAllGroups();
        // Creating adapter for spinner
        ArrayAdapter<groupsModel> dataAdapter = new ArrayAdapter<groupsModel>(this,
                android.R.layout.simple_spinner_item, groups);

        // Drop down layout style - list view with radio button
        dataAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spData.setAdapter(dataAdapter);
        spData.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        btnDo = (Button) findViewById(R.id.btnDo);
        btnDo.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

    }
}
