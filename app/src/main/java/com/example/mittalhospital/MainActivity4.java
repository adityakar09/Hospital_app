package com.example.mittalhospital;

import static com.example.mittalhospital.R.id.spinner3;

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

public class MainActivity4 extends AppCompatActivity  {
    EditText name;
    EditText ID;

    EditText Dname;

    Button bt;
    EditText dateformat;
    int year;
    int month;
    int day;

    Spinner spinner;
    Spinner spinner3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        name = findViewById(R.id.et1);
        ID = findViewById(R.id.et);
        Dname = findViewById(R.id.et3);
        bt = findViewById(R.id.button4);

        Calendar calendar = Calendar.getInstance();
        dateformat = findViewById(R.id.dobformat);
        dateformat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity4.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        dateformat.setText(SimpleDateFormat.getDateInstance().format(calendar.getTime()));

                    }
                },year, month, day);
                datePickerDialog.show();


            }
        });



        Spinner spinner3 = findViewById(R.id.spinner3);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.disease, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter1);


        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
                String patientid = ID.getText().toString();
                String doctorname = Dname.getText().toString();
                String date = dateformat.getText().toString();
                String spin2 = spinner3.getTransitionName();



                Intent intent = new Intent(MainActivity4.this, appointmentappr.class);
                intent.putExtra("keyname11", patientname);
                intent.putExtra("keyname12", patientid);
                intent.putExtra("keyname13", doctorname);
                intent.putExtra("keyname14", date);
                intent.putExtra("keyname15", spin2);
                startActivity(intent);

            }
        });

    }


}