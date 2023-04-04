package com.example.mittalhospital;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Staff_details extends AppCompatActivity  {

    EditText et1, et2;


    Spinner sp1, spinner;
    Button bt2, vi;

    DBdoc DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_details);

        et1 = findViewById(R.id.ett);
        et2 = findViewById(R.id.ettt);



        bt2 = findViewById(R.id.button5);
        vi = findViewById(R.id.button7);

//        bt2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Staff_details.this, staff2.class);
//                startActivity(intent);
//            }
//        });



//        Spinner spinner = findViewById(R.id.spinner3);
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.doctor, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);
//        spinner.setOnItemSelectedListener(this);

//        Spinner spinner7 = findViewById(R.id.spinner3);
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.disease, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner7.setAdapter(adapter);
//
//        Spinner spinner2 = findViewById(R.id.spinner5);
//        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.shift, android.R.layout.simple_spinner_item);
//        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner2.setAdapter(adapter1);
//
//
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });

        DB = new DBdoc(this);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String docname = et1.getText().toString();
                String docyear = et2.getText().toString();



                Boolean savedata = DB.insertdoctordata(docname, docyear);
                if (TextUtils.isEmpty(docname) || TextUtils.isEmpty(docyear)) {
                    Toast.makeText(Staff_details.this, "Add name", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    if (savedata == true) {
                        Toast.makeText(Staff_details.this, "Save user data", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Staff_details.this, "Exists user Saved", Toast.LENGTH_SHORT).show();
                    }
                }

            }


        });

        vi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor WL = DB.getdata();
                if(WL.getCount()==0){
                    Toast.makeText(Staff_details.this, "User data not exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (WL.moveToNext()) {
                    buffer.append("Doctor's Name: " +WL.getString(0)+"\n");
                    buffer.append("Department: " +"Cancer"+"\n\n");
                    buffer.append("Years of Experience: " +WL.getString(1)+"\n\n");
                    buffer.append("Shift: " +"Night"+"\n\n");

                }

                AlertDialog.Builder builder = new AlertDialog.Builder(Staff_details.this);
                builder.setCancelable(true);
                builder.setTitle("Patient Data");
                builder.setMessage(buffer.toString());
                builder.show();            }
        });







    }



    }



