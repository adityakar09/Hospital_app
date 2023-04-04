package com.example.mittalhospital;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBappointment extends SQLiteOpenHelper {
    public DBappointment( Context context ) {
        super(context, "appointdata", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Appointmentdetails(name Text primary key, id TEXT, doctorname TEXT, dateformat TEXT )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int oldVersion, int newVersion) {

        DB.execSQL("drop Table if exists Appointmentdetails");

    }
    public Boolean insertpatientdata (String name, String id, String doctorname, String dateformat)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("id",id);
        contentValues.put("doctorname",doctorname);
        contentValues.put("dateformat",dateformat);
        long result = DB.insert("Appointmentdetails", null, contentValues);
        if(result==-1){
            return false;
        }else {
            return true;
        }
    }



    public Cursor getdata()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Appointmentdetails", null  );
        return cursor;

    }


}
