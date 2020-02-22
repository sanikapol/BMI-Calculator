//Assignment Inclass 02
//File Name: Group12_InClass02
//Sanika Pol
//Snehal Kekane

package com.example.inclass02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText et_weight;
    private EditText et_height_feet;
    private EditText et_height_inches;

    private TextView tv_result;
    private TextView tv_verdict;

    private Button btn_calculate_bmi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final double[] weight = {0};
        final double[] feet = {0}, inches = {0};


        et_weight = findViewById(R.id.editTxtWeight);
        et_height_feet = findViewById(R.id.et_height_feet);
        et_height_inches = findViewById(R.id.et_height_inches);

        tv_result = findViewById(R.id.tv_result);
        tv_verdict = findViewById(R.id.tv_verdict);

        btn_calculate_bmi = findViewById(R.id.btn_calculate_bmi);

        btn_calculate_bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String weight_text = et_weight.getText().toString();
                String feet_text = et_height_feet.getText().toString();
                String inch_text = et_height_inches.getText().toString();

                if(weight_text.equals("")) {
                    et_weight.setError("Can't be empty!!");
                    Toast.makeText(MainActivity.this,"Can't be empty!!", Toast.LENGTH_SHORT).show();
                }
                else if(Double.valueOf(weight_text) == 0.0){
                    et_weight.setError("Can't be zero!!");
                }
                else{
                    weight[0] = Double.parseDouble(weight_text);
                }
                if (feet_text.equals("")){
                    et_height_feet.setError("Can't be empty!!");
                }
                else if(Double.valueOf(feet_text) == 0.0){
                    et_height_feet.setError("Can't be zero!!");
                }
                else{
                    feet[0] = Double.parseDouble(feet_text);
                }
                if(inch_text.equals("")){
                    et_height_inches.setError("Can't be empty!!");
                }
                else{
                    inches[0] = Double.parseDouble(inch_text);
                }

                inches[0] = inches[0] + feet[0] * 12;



                DecimalFormat df = new DecimalFormat("#.##");
                double bmi = weight[0]/inches[0]/inches[0]*703;


                Log.d("demo", "weight: " + weight[0]+ " feet: " + feet[0] + " inches: " + inches[0]);
                Log.d("demo", "bmi: " + bmi);

                tv_result.setText("Your BMI: "+ String.valueOf(df.format(bmi)) +" ");


                if(bmi < 18.5)
                    tv_verdict.setText("You are Underweight");
                else if(bmi >= 18.5 && bmi <=24.9)
                    tv_verdict.setText("You are Normal weight");
                else if(bmi >= 25 && bmi < 29.9)
                    tv_verdict.setText("You are Overweight");
                else if(bmi >= 30){
                    tv_verdict.setText("You are Obese");
                }

            }
        });

    }
}
