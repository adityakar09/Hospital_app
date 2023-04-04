package com.example.mittalhospital;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBpatient extends SQLiteOpenHelper {
    public DBpatient( Context context ) {
        super(context, "patientdata", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Patientdetails(name Text primary key, age TEXT, dateformat TEXT, phone TEXT, address TEXT )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int oldVersion, int newVersion) {

        DB.execSQL("drop Table if exists Patientdetails");

    }
    public Boolean insertuserdata (String name, String age, String dateformat, String phone, String address)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("age",age);
        contentValues.put("dateformat",dateformat);
        contentValues.put("phone",phone);
        contentValues.put("address",address);
        long result = DB.insert("Patientdetails", null, contentValues);
        if(result==-1){
            return false;
        }else {
            return true;
        }
    }



    public Cursor getdata()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Patientdetails", null  );
        return cursor;

    }


}
