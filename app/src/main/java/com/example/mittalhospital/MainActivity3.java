package com.example.mittalhospital;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
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

    Button bt;
    EditText dateformat;
    int year;
    int month;
    int day;

    Spinner spinner;
    Spinner spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        name = findViewById(R.id.et);
        age = findViewById(R.id.et1);
        phone = findViewById(R.id.et2);
        address = findViewById(R.id.et3);
        bt = findViewById(R.id.button4);

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
                },year, month, day);
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

        bt.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                String patientname = name.getText().toString();
                String patientage = age.getText().toString();
                String phoneno = phone.getText().toString();
                String patientaddress = address.getText().toString();
                String date = dateformat.getText().toString();
                String spin = spinner.getTransitionName();
                String spin2 = spinner2.getTransitionName();



                Intent intent = new Intent(MainActivity3.this, MainActivity5.class);
                intent.putExtra("keyname", patientname);
                intent.putExtra("keyname2", patientage);
                intent.putExtra("keyname3", phoneno);
                intent.putExtra("keyname4", patientaddress);
                intent.putExtra("keyname5", date);
                intent.putExtra("keyname6", spin);
                intent.putExtra("keyname7", spin2);
                startActivity(intent);

            }
        });

    }


}