package com.avh.tour_dev;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import java.util.ArrayList;
import java.util.HashMap;

import static android.R.id.list;


/**
 * Created by ${avishek_shahi} on ${2017}.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    static String name = "class330pmdb";
    static int version = 1;

    String createUserTable = "CREATE TABLE if not exists `user` (`Id` INTEGER PRIMARY KEY AUTOINCREMENT, `username` TEXT, `password` TEXT, `email` TEXT, `address` TEXT, `phone` INTEGER, `gender` TEXT, `dob` TEXT, `photo` BLOB )";

    public DatabaseHelper(Context context) {
        super(context, name, null, version);
        getWritableDatabase().execSQL(createUserTable);
    }


    public void insertUser(ContentValues cv) {

        getWritableDatabase().insert("user", "", cv);
    }

    public ArrayList<userinfo> getUserlist() {

        String getdata = "Select * from user";
        Cursor cursor = getWritableDatabase().rawQuery(getdata, null);
        ArrayList<userinfo> list = new ArrayList<userinfo>();
        while (cursor.moveToNext()) {
            userinfo info = new userinfo();
            info.id = cursor.getString(cursor.getColumnIndex("Id"));
            info.username = cursor.getString(cursor.getColumnIndex("username"));
            info.password = cursor.getString(cursor.getColumnIndex("password"));
            info.email = cursor.getString(cursor.getColumnIndex("email"));
            info.phone = cursor.getString(cursor.getColumnIndex("phone"));
            info.address = cursor.getString(cursor.getColumnIndex("address"));
            info.gender = cursor.getString(cursor.getColumnIndex("gender"));
            info.dob = cursor.getString(cursor.getColumnIndex("dob"));
            list.add(info);
        }
        cursor.close();
        return list;
    }


public userinfo getselecteduserinfo(String id) {
        String getdata1 = "Select * from user where Id=" + id;
        Cursor cursor = getWritableDatabase().rawQuery(getdata1, null);
        userinfo info = new userinfo();
        // ArrayList<userinfo> list = new ArrayList<userinfo>();
        while (cursor.moveToNext()) {

            info.id = cursor.getString(cursor.getColumnIndex("Id"));
            info.username = cursor.getString(cursor.getColumnIndex("username"));
            info.password = cursor.getString(cursor.getColumnIndex("password"));
            info.email = cursor.getString(cursor.getColumnIndex("email"));
            info.phone = cursor.getString(cursor.getColumnIndex("phone"));
            info.address = cursor.getString( cursor.getColumnIndex("address"));
            info.gender = cursor.getString(cursor.getColumnIndex("gender"));
            info.dob = cursor.getString(cursor.getColumnIndex("dob"));
        }
    cursor.close();
    return info;


    }
     public boolean isLoggedsucess(String username,String password)
     {
         String sql1="Select count(*)from user Where username='"+username+"'and password='"+password+"'";
         SQLiteStatement statement=getWritableDatabase().compileStatement(sql1);
         long l=statement.simpleQueryForLong();
         return l > 0;
     }


    // public ArrayList<userinfo> getsearchresult(String key){
    //  String getdata1="Select * from user where username='?'" ;
    // Cursor cursor=getWritableDatabase().rawQuery(getdata1,new String[]{key});
    //// userinfo info=new userinfo();

    //while(cursor.moveToNext()){

    //  info.id = cursor.getString(cursor.getColumnIndex("Id"));
    // info.username = cursor.getString(cursor.getColumnIndex("username"));
    //info.password = cursor.getString(cursor.getColumnIndex("password"));
    // info.email = cursor.getString(cursor.getColumnIndex("email"));
    //// info.phone= cursor.getString(cursor.getColumnIndex("phone"));
    // info.address= cursor.getString(cursor.getColumnIndex("address"));
    // info.gender = cursor.getString(cursor.getColumnIndex("gender"));
    // info.dob = cursor.getString(cursor.getColumnIndex("dob"));
    // }
    //cursor.close();
    //return userinfo;


    //}




    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
