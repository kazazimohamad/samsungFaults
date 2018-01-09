package com.samsungfaults.zilu.samsungfaults;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class ProductActivity extends AppCompatActivity
        implements View.OnClickListener{

    private RecyclerView recyclerView;
    private DatabaseHelper databaseHelper;
    private EditText etSample;
    private ProductAdaptor productAdaptor;
    private List<ProductModel> productsModels;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.productsRecyclerView);
        databaseHelper = new DatabaseHelper(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);


        productsModels = databaseHelper.getAllModel();
//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);
        productAdaptor = new ProductAdaptor(this, productsModels);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(productAdaptor);
        etSample = (EditText) findViewById(R.id.etSample);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab:
                if (etSample.getText().toString().trim().length() > 0) {
                    Toast.makeText(ProductActivity.this, "Inserted!", Toast.LENGTH_SHORT).show();

                    ProductModel products = new ProductModel(etSample.getText().toString());
                    databaseHelper.createModel(products);
                    productsModels.add(products);

                    productAdaptor.notifyData(productsModels);
                }
                break;
        }
    }
}
