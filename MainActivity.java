package com.websitename.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    //Class Variables; also are called 'Fields'
    private TextView resultText;
    private Button buttonCalculate;
    private RadioButton readioButtomFemale;
    private RadioButton readioButtomMale;
    private EditText editTextAge;
    private EditText editTextWeight;
    private EditText editTextFeet;
    private EditText editTextInches;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findeViews();
        setupButtonClickListener();

    }

    private void findeViews () {
        resultText= findViewById(R.id.text_view_result);
        resultText.setText("my first progaming code");
        readioButtomFemale = findViewById(R.id.radio_button_female);
        readioButtomMale = findViewById(R.id.radio_button_male);
        editTextAge = findViewById(R.id.edit_text_age);
        editTextWeight = findViewById(R.id.edit_text_weight);
        editTextFeet = findViewById(R.id.edit_text_feet);
        editTextInches = findViewById(R.id.edit_text_inches);
        buttonCalculate=findViewById(R.id.button_calculate);
    }

    private void setupButtonClickListener() {
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              calculateBmi();
            }
        });
    }

    private void calculateBmi() {
       String ageText=  editTextAge.getText().toString();
        String feetText=  editTextFeet.getText().toString();
        String inchesText=  editTextInches.getText().toString();
        String wightText=  editTextWeight.getText().toString();

        int age= Integer.parseInt(ageText);
        int feet= Integer.parseInt(feetText);
        int inches= Integer.parseInt(inchesText);
        int wight= Integer.parseInt(wightText);

        int totalInches= (feet*12)+inches;

        //height in meters is the inches multiplied by 0.254
        double heightInMeters = totalInches * 0.0254;
        // BMI foumula
        double bmi= wight/(heightInMeters*heightInMeters);

        DecimalFormat myDecimalFormatter= new DecimalFormat("0.00");
        String bmiText = myDecimalFormatter.format(bmi);


        String bmiTextResult = String.valueOf(bmiText);

        String fullResultString;

        if (bmi <18.5){
            fullResultString=bmiText + " - you are underwight";
        } else if (bmi>25) {
            fullResultString=bmiText + " - you are Overwight";
        } else {
            fullResultString=bmiText + " - you are healthy";
        }


        resultText.setText(fullResultString);
    }


}

