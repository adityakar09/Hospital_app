//package com.example.mittalhospital;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//import android.widget.TextView;
//
//public class MainActivity5 extends AppCompatActivity {
//    TextView tv1;
//    TextView tv2;
//    TextView tv3;
//    TextView tv4;
//    TextView tv5;
//    TextView tv6;
//    TextView tv7;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main5);
//
//        tv1 = findViewById(R.id.textView2);
//        tv2 = findViewById(R.id.textView3);
//        tv3 = findViewById(R.id.textView5);
//        tv4 = findViewById(R.id.textView6);
//        tv5 = findViewById(R.id.textView7);
//        tv6 = findViewById(R.id.textView8);
//        tv7 = findViewById(R.id.textView9);
//
//        String patientname = getIntent().getStringExtra("keyname");
//        String patientage = getIntent().getStringExtra("keyname2");
//        String phoneno = getIntent().getStringExtra("keyname3");
//        String patientaddress = getIntent().getStringExtra("keyname4");
//        String date = getIntent().getStringExtra("keyname5");
//        String spin = getIntent().getStringExtra("keyname6");
//        String spin2 = getIntent().getStringExtra("keyname7");
//
//        tv1.setText("Patient Name: " +patientname);
//        tv2.setText("Patient Age: " +patientage);
//        tv3.setText("Patient Phone Number: " +phoneno);
//        tv4.setText("Patient Address: " +patientaddress);
//        tv5.setText("Patient Date of Birth: " +date);
//        tv6.setText("Patient Gender: " +spin);
//        tv7.setText("Patient Disease: " +spin2);
//    }
//}