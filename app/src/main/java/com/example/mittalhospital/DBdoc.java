package com.example.mittalhospital;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBdoc extends SQLiteOpenHelper {
    public DBdoc(Context context ) {
        super(context, "doctordata", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Doctordetails(name Text primary key, year TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int oldVersion, int newVersion) {

        DB.execSQL("drop Table if exists Doctordetails");

    }
    public Boolean insertdoctordata (String name, String year)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("year",year);
        long result = DB.insert("Doctordetails", null, contentValues);
        if(result==-1){
            return false;
        }else {
            return true;
        }
    }



    public Cursor getdata()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Doctordetails", null  );
        return cursor;

    }


}
