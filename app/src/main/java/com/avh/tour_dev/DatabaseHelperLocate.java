package com.avh.tour_dev;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

 /**
 * Created by ${avishek_shahi} on ${2017}.
 */

public class DatabaseHelperLocate extends SQLiteOpenHelper {


    static String name = "locationdb";
    static int version = 1;

    String createLocationtable="CREATE TABLE  if not exists `location` ( `id` INTEGER PRIMARY KEY AUTOINCREMENT, `image1` BLOB, `image2` BLOB, `locationname` TEXT, `address1` TEXT, `description` TEXT, `accomodation` TEXT, `feature` TEXT, `route` TEXT, `addedby` TEXT )";
    public DatabaseHelperLocate(Context context) {
        super(context, name, null, version);
        getWritableDatabase().execSQL(createLocationtable);
    }
    public void insertlocation(ContentValues cv) {

        getWritableDatabase().insert("location",null, cv);
    }

    public ArrayList<locationinfo> getlocationlist() {

        String getdata = "Select * from location";
        Cursor cursor = getWritableDatabase().rawQuery(getdata, null);
        ArrayList<locationinfo> list = new ArrayList<locationinfo>();
        while (cursor.moveToNext()) {
            locationinfo info1 = new locationinfo();
            info1.id = cursor.getString(cursor.getColumnIndex("id"));
            info1.locationname= cursor.getString(cursor.getColumnIndex("locationname"));
            info1.address = cursor.getString(cursor.getColumnIndex("address1"));
            info1.description = cursor.getString(cursor.getColumnIndex("description"));
            info1.accomodation = cursor.getString(cursor.getColumnIndex("accomodation"));
            info1.feature = cursor.getString(cursor.getColumnIndex("feature"));
            info1.route = cursor.getString(cursor.getColumnIndex("route"));
            info1.addedby = cursor.getString(cursor.getColumnIndex("addedby"));
            info1.image1=cursor.getBlob(cursor.getColumnIndex("image1"));
            info1.image2=cursor.getBlob(cursor.getColumnIndex("image2"));
            list.add(info1);

        }
        cursor.close();
        return list;
    }


    public locationinfo getselectedlocation(String id) {
        String getdata2 = "Select * from location where id=" + id;
        Cursor cursor = getWritableDatabase().rawQuery(getdata2, null);
        locationinfo info1 = new locationinfo();
        // ArrayList<userinfo> list = new ArrayList<userinfo>();
        while (cursor.moveToNext()) {

            info1.id = cursor.getString(cursor.getColumnIndex("id"));
            info1.locationname = cursor.getString(cursor.getColumnIndex("locationname"));
            info1.address = cursor.getString(cursor.getColumnIndex("address1"));
            info1.description = cursor.getString(cursor.getColumnIndex("description"));
            info1.accomodation = cursor.getString(cursor.getColumnIndex("accomodation"));
            info1.feature = cursor.getString(cursor.getColumnIndex("feature"));
            info1.route = cursor.getString(cursor.getColumnIndex("route"));
            info1.addedby = cursor.getString(cursor.getColumnIndex("addedby"));
            info1.image1=cursor.getBlob(cursor.getColumnIndex("image1"));
            info1.image2=cursor.getBlob(cursor.getColumnIndex("image2"));

        }
        cursor.close();
        return info1;


    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
