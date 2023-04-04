//package com.example.mittalhospital;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.TextView;
//
//import java.util.Calendar;
//import java.util.Date;
//
//public class appointmentappr extends AppCompatActivity {
//
//     TextView textView;
//    TextView tv1;
//    TextView tv2;
//    TextView tv3;
//    TextView tv4;
//    TextView tv5;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_appointmentappr);
//
//        tv1 = findViewById(R.id.textView23);
//        tv2 = findViewById(R.id.textView24);
//        tv3 = findViewById(R.id.textView25);
//        tv4 = findViewById(R.id.textView26);
//        tv5 = findViewById(R.id.textView27);
//
//        textView = findViewById(R.id.textView30);
//
//
//        String patientid = getIntent().getStringExtra("keyname12");
//        String patientname = getIntent().getStringExtra("keyname11");
//        String doctorname = getIntent().getStringExtra("keyname13");
//        String date = getIntent().getStringExtra("keyname14");
//
//
//        tv1.setText("Patient ID: " +patientid);
//        tv2.setText("Patient Name: " +patientname);
//        tv4.setText("Doctor Name: " +doctorname);
//        tv5.setText("Date of Appointment: " +date);
//
//    }
//
//    public void timeofapp(View view){
//        Date datecurrent= Calendar.getInstance().getTime();
//
//        textView.setText(datecurrent.toString());
//
//    }
//}