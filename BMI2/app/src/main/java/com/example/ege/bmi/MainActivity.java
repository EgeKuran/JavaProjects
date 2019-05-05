package com.example.ege.bmi;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Scanner;

public class MainActivity extends Activity {
    EditText txtHeight;
    EditText txtWeight;
    Button btnCompute;
    TextView txtBmi;
    TextView txtResult;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_layout);
        txtHeight= findViewById(R.id.txtHeight);
        txtWeight=findViewById(R.id.txtWeight);

        txtBmi=findViewById(R.id.txtBmi);
        txtResult=findViewById(R.id.txtResult);
    }

    public void clickBtnCompute(View v)
    {
        double height = Double.parseDouble(txtHeight.getText().toString());
        double weight = Double.parseDouble(txtWeight.getText().toString());

        HealthProfile hp = new HealthProfile(height, weight);
        double BMI = hp.findBMI(height, weight);
        txtBmi.setText(String.valueOf(BMI));
        if (BMI < 18.5) {

            txtResult.setText("You are underweight");
        }
        if (BMI >= 18.5 & BMI < 25) {
            txtResult.setText("You are normal weight");
        }
        if (BMI >= 25 & BMI < 30) {
            txtResult.setText("You are overweight");
        }
        if (BMI >= 30) {
            txtResult.setText("You are obese");
        }
        System.out.println("-------------HEALTH-PROFILE-------------------");


    }
}


