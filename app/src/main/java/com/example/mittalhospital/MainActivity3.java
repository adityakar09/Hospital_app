package com.example.mittalhospital;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity3 extends AppCompatActivity  {
    EditText name;
    EditText age;
    EditText phone;
    EditText address;

    Button bt, view, update, delete;
    EditText dateformat;
    int year;
    int month;
    int day;

//    Spinner spinner;
//    Spinner spinner2;

    DBpatient DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        name = findViewById(R.id.et);
        age = findViewById(R.id.et1);
        phone = findViewById(R.id.et2);
        address = findViewById(R.id.et3);
        bt = findViewById(R.id.button4);
//        update = findViewById(R.id.button9);
//        delete = findViewById(R.id.button10);
        view = findViewById(R.id.button8);


        Calendar calendar = Calendar.getInstance();
        dateformat = findViewById(R.id.dobformat);
        dateformat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity3.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        dateformat.setText(SimpleDateFormat.getDateInstance().format(calendar.getTime()));

                    }
                }, year, month, day);
                datePickerDialog.show();


            }
        });

        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.string, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Spinner spinner2 = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.disease, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter1);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        DB = new DBpatient(this);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String patientname = name.getText().toString();
                String patientage = age.getText().toString();
                String date = dateformat.getText().toString();
                String phoneno = phone.getText().toString();
                String patientaddress = address.getText().toString();


                Boolean savedata = DB.insertuserdata(patientname, patientage, phoneno, patientaddress, date);
                if (TextUtils.isEmpty(patientname) || TextUtils.isEmpty(patientage) || TextUtils.isEmpty(phoneno) || TextUtils.isEmpty(patientaddress) || TextUtils.isEmpty(date)) {
                    Toast.makeText(MainActivity3.this, "Add name", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    if (savedata == true) {
                        Toast.makeText(MainActivity3.this, "Save user data", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity3.this, "Exists user Saved", Toast.LENGTH_SHORT).show();
                    }
                }

            }


        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Cursor WL = DB.getdata();
               if(WL.getCount()==0){
                   Toast.makeText(MainActivity3.this, "User data not exists", Toast.LENGTH_SHORT).show();
                   return;
               }
               StringBuffer buffer = new StringBuffer();
               while (WL.moveToNext()) {
                   buffer.append("Name: " +WL.getString(0)+"\n");
                   buffer.append("Age: " +WL.getString(1)+"\n\n");
                   buffer.append("Gender: " +"Male"+"\n\n\n");
                   buffer.append("Date: " +WL.getString(2)+"\n\n\n\n");
                   buffer.append("Disease Type: " +"Cancer"+"\n\n\n\n\n");
                   buffer.append("Phone: " +WL.getString(3)+"\n\n\n\n\n\n");
                   buffer.append("Address: " +WL.getString(4)+"\n\n\n\n\n\n\n");
                   buffer.append("Medical Claim: " +"Yes"+"\n\n\n\n\n\n\n\n");

               }

               AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity3.this);
               builder.setCancelable(true);
               builder.setTitle("Patient Data");
               builder.setMessage(buffer.toString());
               builder.show();            }
        });


    }


}