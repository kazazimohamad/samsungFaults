package com.samsungfaults.zilu.samsungfaults;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mohamad on 12/15/2017.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    String[] GROUPS = {"ID", "NAME"};
    // Database Information
    static final String DB_NAME = "SamsungFaults.db";

    // database version
    static final int DB_VERSION = 1;

    // Logcat tag
    private static final String LOG = "DatabaseHelper";


    public DatabaseHelper(Context context) {

        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String groupsTableSQL = "CREATE TABLE IF NOT EXISTS `group` (" +
                "`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "`grp_name` TEXT NOT NULL " +
                ");";// +
//                "INSERT INTO `group` (grp_name) VALUES (1, 'واحد تولید');" ;// +
//                "INSERT INTO `group` (grp_name) VALUES ('واحد برنامه ربزی و لوجستیک');" +
//                "INSERT INTO `group` (grp_name) VALUES ('واحد خدمات فنی');" +
//                "INSERT INTO `group` (grp_name) VALUES ('واحد قالب');" +
//                "INSERT INTO `group` (grp_name) VALUES ('واحد مهندسی');" +
//                "INSERT INTO `group` (grp_name) VALUES ('واحد کنترل کیفیت');" +
//                "INSERT INTO `group` (grp_name) VALUES ('واحد تامین');" +
//                "INSERT INTO `group` (grp_name) VALUES ('تکوین الکترونیک');";

        String modelsTableSQL = "CREATE TABLE `model` (" +
                "`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "`mdl_name` TEXT NOT NULL" +
                ");"; // +
//                "INSERT INTO `model` (mdl_name) VALUES ('FSR-14');" +
//                "INSERT INTO `model` (mdl_name) VALUES ('FSR-12');" +
//                "INSERT INTO `model` (mdl_name) VALUES ('RL730EW5');" +
//                "INSERT INTO `model` (mdl_name) VALUES ('FSR-12W');" +
//                "INSERT INTO `model` (mdl_name) VALUES ('RL750SP6R');" +
//                "INSERT INTO `model` (mdl_name) VALUES ('RL72-W');" +
//                "INSERT INTO `model` (mdl_name) VALUES ('RT57-W');" +
//                "INSERT INTO `model` (mdl_name) VALUES ('HM34-W');" +
//                "INSERT INTO `model` (mdl_name) VALUES ('RL43-W');" +
//                "INSERT INTO `model` (mdl_name) VALUES ('RL750EW6');" +
//                "INSERT INTO `model` (mdl_name) VALUES ('RL730SP5');" +
//                "INSERT INTO `model` (mdl_name) VALUES ('POLARIS-SL');" +
//                "INSERT INTO `model` (mdl_name) VALUES ('RR20WESW/C');" +
//                "INSERT INTO `model` (mdl_name) VALUES ('ROSSO 2-ALF');" +
//                "INSERT INTO `model` (mdl_name) VALUES ('ROSSO 2-W');" +
//                "INSERT INTO `model` (mdl_name) VALUES ('RL72-SP5');" +
//                "INSERT INTO `model` (mdl_name) VALUES ('FSR-14W');" +
//                "INSERT INTO `model` (mdl_name) VALUES ('POLARIS-W');" +
//                "INSERT INTO `model` (mdl_name) VALUES ('RT870-EW');" +
//                "INSERT INTO `model` (mdl_name) VALUES ('RT850-EW');" +
//                "INSERT INTO `model` (mdl_name) VALUES ('RZ20AEEPN/C');" +
//                "INSERT INTO `model` (mdl_name) VALUES ('RZ20AEESW/C');" +
//                "INSERT INTO `model` (mdl_name) VALUES ('RH9000');" +
//                "INSERT INTO `model` (mdl_name) VALUES ('RT7000');" +
//                "INSERT INTO `model` (mdl_name) VALUES ('RR20WEPN/C');" +
//                "INSERT INTO `model` (mdl_name) VALUES ('RT870-PN');" +
//                "INSERT INTO `model` (mdl_name) VALUES ('SBS');" +
//                "INSERT INTO `model` (mdl_name) VALUES ('RT850-PN');";

        String stationTableSQL = "CREATE TABLE IF NOT EXISTS `stations` (" +
                "`sta_code`TEXT NOT NULL," +
                "`sta_en_name`TEXT NOT NULL," +
                "`sta_fa_name`TEXT," +
                "`sta_grp`INTEGER NOT NULL," +
                "`sta_detail`TEXT," +
                "PRIMARY KEY(`sta_code`)" +
                ");";
//                "INSERT INTO `stations` (sta_code,sta_en_name,sta_fa_name,sta_grp,sta_detail) VALUES ('SE','Sheet Extruder','شیت اکسترودر',1,'');" +
//                "INSERT INTO `stations` (sta_code,sta_en_name,sta_fa_name,sta_grp,sta_detail) VALUES ('PB','Pipe Bending','پایپ بندینگ',1,'');" +
//                "INSERT INTO `stations` (sta_code,sta_en_name,sta_fa_name,sta_grp,sta_detail) VALUES ('GA','Gasket','گسکت',1,'');" +
//                "INSERT INTO `stations` (sta_code,sta_en_name,sta_fa_name,sta_grp,sta_detail) VALUES ('PR','Press','پرس',1,'');" +
//                "INSERT INTO `stations` (sta_code,sta_en_name,sta_fa_name,sta_grp,sta_detail) VALUES ('PT','Panel Thermoforming','ترموفرمینگ پنل',1,'');" +
//                "INSERT INTO `stations` (sta_code,sta_en_name,sta_fa_name,sta_grp,sta_detail) VALUES ('LT','Liner Thermoforming','ترموفرمینگ لاینر',1,'');" +
//                "INSERT INTO `stations` (sta_code,sta_en_name,sta_fa_name,sta_grp,sta_detail) VALUES ('DA','Door Assembly','اسمبلی در',1,'');" +
//                "INSERT INTO `stations` (sta_code,sta_en_name,sta_fa_name,sta_grp,sta_detail) VALUES ('DF','Door Foaming','فوم در',1,'');" +
//                "INSERT INTO `stations` (sta_code,sta_en_name,sta_fa_name,sta_grp,sta_detail) VALUES ('LA','Liner Assembly','اسمبلی لاینر',1,'');" +
//                "INSERT INTO `stations` (sta_code,sta_en_name,sta_fa_name,sta_grp,sta_detail) VALUES ('CA','Cabinet Assembly','اسمبلی کابین',1,'');" +
//                "INSERT INTO `stations` (sta_code,sta_en_name,sta_fa_name,sta_grp,sta_detail) VALUES ('RF','Roll Forming','رول فرمینگ',1,'');" +
//                "INSERT INTO `stations` (sta_code,sta_en_name,sta_fa_name,sta_grp,sta_detail) VALUES ('CF','Cabinet Foaming','فوم کابین',1,'');" +
//                "INSERT INTO `stations` (sta_code,sta_en_name,sta_fa_name,sta_grp,sta_detail) VALUES ('CB','C-Line Brazing','جوشکاری ونصب برد',1,'');" +
//                "INSERT INTO `stations` (sta_code,sta_en_name,sta_fa_name,sta_grp,sta_detail) VALUES ('CS','C-Line Shelf & Guard & Door install','نصب شلف و گارد و در',1,'');" +
//                "INSERT INTO `stations` (sta_code,sta_en_name,sta_fa_name,sta_grp,sta_detail) VALUES ('CT','C-Line Test','تست',1,'');" +
//                "INSERT INTO `stations` (sta_code,sta_en_name,sta_fa_name,sta_grp,sta_detail) VALUES ('CP','C-Line Packing & Repair','بسته بندی و تعمیرات',1,'');" +
//                "INSERT INTO `stations` (sta_code,sta_en_name,sta_fa_name,sta_grp,sta_detail) VALUES ('US','Uretan Supply','یورتان ساپلای',1,'');" +
//                "INSERT INTO `stations` (sta_code,sta_en_name,sta_fa_name,sta_grp,sta_detail) VALUES ('WH','Warehouse','انبار/ انبار سام / انبار مانده',2,'');" +
//                "INSERT INTO `stations` (sta_code,sta_en_name,sta_fa_name,sta_grp,sta_detail) VALUES ('LC','Lines Charging','تغذیه خطوط',2,'');" +
//                "INSERT INTO `stations` (sta_code,sta_en_name,sta_fa_name,sta_grp,sta_detail) VALUES ('PM','Preventive Maintenance','خدمات فنی / تاسیسات',3,'');" +
//                "INSERT INTO `stations` (sta_code,sta_en_name,sta_fa_name,sta_grp,sta_detail) VALUES ('MM','Mold Maintenance','نت قالب',4,'');" +
//                "INSERT INTO `stations` (sta_code,sta_en_name,sta_fa_name,sta_grp,sta_detail) VALUES ('EN','Engineering','مهندسی',5,'');" +
//                "INSERT INTO `stations` (sta_code,sta_en_name,sta_fa_name,sta_grp,sta_detail) VALUES ('QC','Quality Control','کنترل کیفیت',6,'');" +
//                "INSERT INTO `stations` (sta_code,sta_en_name,sta_fa_name,sta_grp,sta_detail) VALUES ('VO','VOC','VOC',6,'');" +
//                "INSERT INTO `stations` (sta_code,sta_en_name,sta_fa_name,sta_grp,sta_detail) VALUES ('IS','Internal Supplier','تامین کننده داخلی',7,'');" +
//                "INSERT INTO `stations` (sta_code,sta_en_name,sta_fa_name,sta_grp,sta_detail) VALUES ('GU','General & Unknown','کلی و ناشناخته',8,'');";

        String stationFaultsTableSQL = "CREATE TABLE IF NOT EXISTS `station_faults` (" +
                "`id`INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "`sta_flt_code`TEXT NOT NULL," +
                "`sta_flt_name`TEXT NOT NULL," +
                "`sta_flt_station`TEXT NOT NULL" +
                ");"; // +
//                "INSERT INTO `station_faults` (id,sta_flt_code,sta_flt_name,sta_flt_station) VALUES (1,'SE10','رد زرد رنگ روی شیت','SE');" +
//                "INSERT INTO `station_faults` (id,sta_flt_code,sta_flt_name,sta_flt_station) VALUES (2,'GA10','تعویض گسکت جوش نامناسب','GA');" +
//                "INSERT INTO `station_faults` (id,sta_flt_code,sta_flt_name,sta_flt_station) VALUES (3,'GA11','جوش نامناسب چرخش','GA');" +
//                "INSERT INTO `station_faults` (id,sta_flt_code,sta_flt_name,sta_flt_station) VALUES (4,'GA12','دفرمگی گسکت','GA');";

        String faultsTableSQL = "CREATE TABLE IF NOT EXISTS `faults` (" +
                "`id`INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "`flt_date`TEXT NOT NULL," +
                "`flt_model`TEXT NOT NULL," +
                "`flt_station`TEXT NOT NULL," +
                "`flt_fault`TEXT NOT NULL" +
				"`flt_count`INTEGER NOT NULL" +
                ");";


        db.execSQL(groupsTableSQL);
        db.execSQL(modelsTableSQL);
        db.execSQL(stationTableSQL);
        db.execSQL(stationFaultsTableSQL);
        db.execSQL(faultsTableSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /**
     * create group
     */
    public long createGroup(groupsModel group) {
        SQLiteDatabase db = this.getWritableDatabase();

        try {
            db.execSQL("INSERT INTO `group` (grp_name) VALUES ('" + group.getGroupName() + "')");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

    /**
     * getting group
     */
    public groupsModel getGroup(long group_id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * " +
                "FROM 'group' " +
                "WHERE "
                + "id = " + group_id;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        groupsModel gm = new groupsModel();
        gm.setId(c.getInt(0));
        gm.setGroupName((c.getString(c.getColumnIndex("grp_name"))));

        c.close();
        return gm;
    }

    /**
     * getting all group
     */
    public ArrayList<groupsModel> getAllGroups() {
        ArrayList<groupsModel> groups = new ArrayList<>();
        String selectQuery = "SELECT * FROM 'group';";

        // Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                groupsModel gm = new groupsModel();
                gm.setId(c.getInt((c.getColumnIndex("id"))));
                gm.setGroupName((c.getString(c.getColumnIndex("grp_name"))));
                // adding to group list
                groups.add(gm);
            } while (c.moveToNext());
        }
        c.close();
        return groups;
    }

    /*
 * getting group count
 */
    public int getGroupCount() {
        String countQuery = "SELECT * FROM 'group';";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();

        // return count
        return count;
    }

    /*
     * Updating a group
	 */
    public int updateGroup(groupsModel group) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("grp_name", group.getGroupName());

        // updating row
        return db.update("group", values, "id" + " = ?",
                new String[]{String.valueOf(group.getId())});
    }

    /*
     * Deleting a group
     */
    public void deleteToDo(long tado_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("group", "id" + " = ?",
                new String[]{String.valueOf(tado_id)});
    }


    //**************************************************** Models**********************************************

    /**
     * create models
     */
    public long createModel(ProductModel model) {
        SQLiteDatabase db = this.getWritableDatabase();

        try {
            db.execSQL("INSERT INTO model (mdl_name) VALUES ('" + model.getProductName() + "')");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

    /**
     * getting group
     */
    public ProductModel getModel(long model_id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM model WHERE "
                + "id = " + model_id;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        groupsModel gm = new groupsModel();
        ProductModel pm = new ProductModel();

        pm.setId(c.getInt(0));
        pm.setProductName((c.getString(c.getColumnIndex("mdl_name"))));
        c.close();
        return pm;
    }

    /**
     * getting all group
     */
    public List<ProductModel> getAllModel() {
        List<ProductModel> models = new ArrayList<>();
        String selectQuery = "SELECT id, mdl_name " +
                "FROM `model`";

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                ProductModel pm = new ProductModel();
                pm.setId(c.getInt((c.getColumnIndex("id"))));
                pm.setProductName((c.getString(c.getColumnIndex("mdl_name"))));
                // adding to group list
                models.add(pm);
            } while (c.moveToNext());
        }
        c.close();
        return models;
    }

    /*
 * getting group count
 */
    public int getModelCount() {
        String countQuery = "SELECT * FROM 'model'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from model", null);

        int count = cursor.getCount();
        cursor.close();
        // return count
        return count;
    }

    /*
	 * Updating a group
	 */
    public int updateModel(ProductModel product) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("mdl_name", product.getProductName());

        // updating row
        return db.update("model", values, "id" + " = ?",
                new String[]{String.valueOf(product.getId())});
    }

    /*
     * Deleting a group
     */
    public void deleteProduct(long model_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("model", "id" + " = ?",
                new String[]{String.valueOf(model_id)});
    }

//    ===================================================== stations ================================

    /**
     * create station
     */
    public long createStation(StationModel stationModel) {
        SQLiteDatabase db = this.getWritableDatabase();

        try {
            db.execSQL("INSERT INTO `stations` (sta_code, sta_en_name, sta_fa_name, sta_grp, sta_detail)" +
                    " VALUES ('" + stationModel.getId() + "','" + stationModel.getEnName() + "'" + ","
                    + "'" + stationModel.getFaName() + "'" + "," +  stationModel.getGroupId() + ","
                    + "'" + stationModel.getDetails() + "')");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

    /**
     * getting all station
     */
    public List<StationModel> getAllStation() {
        List<StationModel> models = new ArrayList<>();
        String selectQuery = "SELECT * FROM `stations`";

        // Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                StationModel pm = new StationModel();
                pm.setId((c.getString(c.getColumnIndex("sta_code"))));
                pm.setFaName((c.getString(c.getColumnIndex("sta_fa_name"))));
                pm.setGroupId((c.getLong(c.getColumnIndex("sta_grp"))));
                // adding to group list
                models.add(pm);
            } while (c.moveToNext());
        }
        c.close();
        return models;
    }

    public List<StationModel> getAllStationByGroup(long  id) {
        List<StationModel> models = new ArrayList<>();
        String selectQuery = "SELECT * FROM `stations` where `sta_grp` = "+id;

        // Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                StationModel pm = new StationModel();
                pm.setId((c.getString(c.getColumnIndex("sta_code"))));
                pm.setFaName((c.getString(c.getColumnIndex("sta_fa_name"))));
                pm.setGroupId((c.getLong(c.getColumnIndex("sta_grp"))));
                // adding to group list
                models.add(pm);
            } while (c.moveToNext());
        }
        c.close();
        return models;
    }

//================================================== Station Faults ===================================

    /**
     * create station fault
     * station_faults
     */
    public long createStationFault(StationFaultModel stationFault) {
        SQLiteDatabase db = this.getWritableDatabase();

        try {
            db.execSQL("INSERT INTO `station_faults` (sta_flt_code, sta_flt_name, sta_flt_station)" +
                    " VALUES ('" + stationFault.getStaFaultCode() + "','" + stationFault.getStaFaultName() + "'," +
                    "'" + stationFault.getStaFaultStationId() + "')");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

    /**
     * getting station fault
     */
    public StationFaultModel getStationFault(long stationFault_id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * " +
                "FROM 'station_faults' " +
                "WHERE "
                + "id = " + stationFault_id;

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        StationFaultModel gm = new StationFaultModel();
        gm.setId(c.getInt(0));
        gm.setStaFaultCode((c.getString(c.getColumnIndex("sta_flt_code"))));

        c.close();
        return gm;
    }

    /**
     * getting all station fault
     */
    public ArrayList<StationFaultModel> getAllStationFaults() {
        ArrayList<StationFaultModel> groups = new ArrayList<>();
        String selectQuery = "SELECT * FROM 'station_faults';";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                StationFaultModel gm = new StationFaultModel();
                gm.setId(c.getInt((c.getColumnIndex("id"))));
                gm.setStaFaultCode(c.getString(c.getColumnIndex("sta_flt_code")));
                gm.setStaFaultName(c.getString(c.getColumnIndex("sta_flt_name")));
                gm.setStaFaultStationId(c.getString(c.getColumnIndex("sta_flt_station")));
                // adding to group list
                groups.add(gm);
            } while (c.moveToNext());
        }
        c.close();
        return groups;
    }

    /**
     * getting station fault count
     */
    public int getStationFaultCount() {
        String countQuery = "SELECT * FROM 'station_faults';";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();

        // return count
        return count;
    }
}