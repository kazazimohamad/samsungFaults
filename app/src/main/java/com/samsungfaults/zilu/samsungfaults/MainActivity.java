package com.samsungfaults.zilu.samsungfaults;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.List;

import saman.zamani.persiandate.PersianDate;
import saman.zamani.persiandate.PersianDateFormat;
import com.ajts.androidmads.library.SQLiteToExcel;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, AddReportDialog.Adding {

    private TextView persianDate;
    private RecyclerView rvReport;
    private File dbFile;
    private DatabaseHelper databaseHelper;
    private SQLiteToExcel sqliteToExcel;
    private FileUtils fileUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        persianDate = (TextView) findViewById(R.id.persianDate);
        PersianDate pdate = new PersianDate();
        PersianDateFormat pdformater1 = new PersianDateFormat("Y/m/d");

        persianDate.setText(persianDate.getText() + pdformater1.format(pdate));

        rvReport = (RecyclerView) findViewById(R.id.rvReport);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvReport.setLayoutManager(layoutManager);
        rvReport.setHasFixedSize(true);

        FloatingActionButton fabAdd = (FloatingActionButton) findViewById(R.id.fabAdd);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AddReportDialog(MainActivity.this, MainActivity.this).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        getReport();

    }

    private void getReport() {
        PersianDate date = new PersianDate();
        String strDate = date.getShYear() + "/" + date.getShMonth() + "/" + date.getShDay();
        List<ReportModel> reports = new DatabaseHelper(this).getAllReport(strDate);
        ReportAdapter adapter = new ReportAdapter(this, reports);
        rvReport.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        } else if (id == R.id.nav_groups) {
            Intent inent = new Intent(this, GroupsActivity.class);
            startActivity(inent);
        } else if (id == R.id.nav_models) {
            Intent inent = new Intent(this, ProductActivity.class);
            startActivity(inent);
        } else if (id == R.id.nav_station) {
            Intent inent = new Intent(this, StationActivity.class);
            startActivity(inent);
        } else if (id == R.id.nav_stationFaults) {
            Intent inent = new Intent(this, StationFaultsActivity.class);
            startActivity(inent);
        } else if (id == R.id.nav_exportExcel) {
            exportToExcel();
        } else if (id == R.id.nav_exportDb) {
            exportDB();
        } else if (id == R.id.nav_importDb) {
            importDatabase();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void finishAdding() {
        getReport();
    }

    //exporting database
    public void exportDB() {
        // TODO Auto-generated method stub

        try {
            File sd = Environment.getExternalStorageDirectory();
            File data = Environment.getDataDirectory();

            if (sd.canWrite()) {
                String  currentDBPath= "//data//" + "com.samsungfaults.zilu.samsungfaults"
                        + "//databases//" + "SamsungFaults.db";
                String directory_path = Environment.getExternalStorageDirectory().getPath() + "/Techwin_SAMSUNG/";
                File file = new File(directory_path);
                if (!file.exists()) {
                    file.mkdirs();
                }

                String backupDBPath  =  "/Techwin_SAMSUNG/SamsungFaults.db";
                File currentDB = new File(data, currentDBPath);
                File backupDB = new File(sd, backupDBPath);

                FileChannel src = new FileInputStream(currentDB).getChannel();
                FileChannel dst = new FileOutputStream(backupDB).getChannel();
                dst.transferFrom(src, 0, src.size());
                src.close();
                dst.close();
                Toast.makeText(getBaseContext(), "دیتابیس با موفقیت استخراج شد",
                        Toast.LENGTH_LONG).show();

            }
        } catch (Exception e) {

            Toast.makeText(getBaseContext(), e.toString(), Toast.LENGTH_LONG)
                    .show();

        }
    }

    public void importDatabase() {
        String DB_FILEPATH = "/data/data/com.samsungfaults.zilu.samsungfaults/databases/SamsungFaults.db";
        String directory_path = Environment.getExternalStorageDirectory().getPath() + "/Techwin_SAMSUNG/";
        File file = new File(directory_path);
        if (!file.exists()) {
            file.mkdirs();
            return;
        }

        // Close the SQLiteOpenHelper so it will commit the created empty
        // database to internal storage.
        // databaseHelper.close();
        File newDb = new File(directory_path + "SamsungFaults.db");
        File oldDb = new File(DB_FILEPATH);
        if (newDb.exists()) {
            try {
                fileUtils.copyFile(new FileInputStream(newDb), new FileOutputStream(oldDb));
                Toast.makeText(getBaseContext(), "دیتابیس با موفقیت وارد شد",
                        Toast.LENGTH_LONG).show();
            } catch (IOException e) {
                Toast.makeText(getBaseContext(), "خطا در ورود دیتابیس",
                        Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }
            // Access the copied database so SQLiteHelper will cache it and mark
            // it as created.
            // databaseHelper.getWritableDatabase().close();
            return ;
        }
        return ;
    }

    public void  exportToExcel() {
        String directory_path = Environment.getExternalStorageDirectory().getPath() + "/Techwin_SAMSUNG/";
        File file = new File(directory_path);
        if (!file.exists()) {
            file.mkdirs();
        }

        PersianDate pdate = new PersianDate();
        PersianDateFormat pdformater = new PersianDateFormat("Y-m-d");
        // pdformater.format(pdate);
        String fileName = "faults_" + pdformater.format(pdate) + ".xls";

        sqliteToExcel = new SQLiteToExcel(this, "SamsungFaults.db", directory_path);
        sqliteToExcel.exportSingleTable("excelFaults", fileName, new SQLiteToExcel.ExportListener() {
            @Override
            public void onStart() {

            }
            @Override
            public void onCompleted(String filePath) {

            }
            @Override
            public void onError(Exception e) {

            }
        });
        Toast.makeText(getBaseContext(), "استخراج انجام شد",
                Toast.LENGTH_LONG).show();
    }
}
