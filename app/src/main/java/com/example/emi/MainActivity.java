package com.example.emi;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.provider.Telephony;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText price,downpayment,interestrate,yearsmonth;
    Button calculate;
    TextView EMIANS;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        price = findViewById(R.id.etprice);
        downpayment = findViewById(R.id.etdp);
        interestrate = findViewById(R.id.etir);
        yearsmonth= findViewById(R.id.etym);
        calculate = findViewById(R.id.btca);
        EMIANS = findViewById(R.id.tvans);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Double p = Double.parseDouble(price.getText().toString());
                Double d = Double.parseDouble(downpayment.getText().toString());
                Double i = Double.parseDouble(interestrate.getText().toString());
                Double y = Double.parseDouble(yearsmonth.getText().toString());
                Double rate=(y/1200);
                Double res = (p * rate * Math.pow(1 + rate,y) - 1);
                EMIANS.setText("EMI="+String.valueOf(res));


            }
        });
    }
}