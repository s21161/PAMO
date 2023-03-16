package com.example.tipper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private EditText heightEditText;
    private EditText weightEditText;
    private TextView bmiTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        heightEditText = findViewById(R.id.heightEditText);
        weightEditText = findViewById(R.id.weightEditText);
        bmiTextView = findViewById(R.id.bmiTextView);


        heightEditText.addTextChangedListener(textWatcher);
        weightEditText.addTextChangedListener(textWatcher);
    }

    private final TextWatcher textWatcher = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            calculateBmi();
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    private void calculateBmi() {
        String heightString = heightEditText.getText().toString();
        String weightString = weightEditText.getText().toString();

        if (heightString.equals("") || weightString.equals("")) {
            bmiTextView.setText("");
            return;
        }

        float height = Float.parseFloat(heightString) / 100;
        float weight = Float.parseFloat(weightString);

        float bmi = weight / (height * height);

        bmiTextView.setText(String.format("BMI: %.2f", bmi));
    }
}