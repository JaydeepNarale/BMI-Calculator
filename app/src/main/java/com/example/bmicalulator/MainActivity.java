package com.example.bmicalulator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtResult;
        EditText edtHeightft, edtWieght, edtHeightin;
        Button btnCalculator;
        LinearLayout llMain;


        edtWieght=findViewById(R.id.edtWeight);
        edtHeightft=findViewById(R.id.edtHeightft);
        edtHeightin=findViewById(R.id.edtHeightin);
        btnCalculator=findViewById(R.id.btnCalculator);
        txtResult=findViewById(R.id.txtResult);
        llMain=findViewById(R.id.llMain);

        btnCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               int wt=Integer.parseInt(edtWieght.getText().toString());
              int htf=Integer.parseInt(edtHeightft.getText().toString());
              int hti=Integer.parseInt(edtHeightin.getText().toString());

              int totalIn=htf*12+hti;
              double totalCm=totalIn*2.53;
              double totalM=totalCm/100;

              double bmi=wt/(totalM*totalM);

              if (bmi>25){
                  txtResult.setText("You are OverWeight.");
                  llMain.setBackgroundColor(getResources().getColor(R.color.colorOW));
              }
              else if(bmi<18){
                  txtResult.setText("You are UnderWeight.");
                  llMain.setBackgroundColor(getResources().getColor(R.color.colorUW));
              }
              else {
                  txtResult.setText("You are Healthy!");
                  llMain.setBackgroundColor(getResources().getColor(R.color.colorH));
              }
            }
        });

    }
}