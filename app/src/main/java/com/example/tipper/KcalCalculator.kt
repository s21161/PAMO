package com.example.tipper;
import java.text.DecimalFormat;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class KcalCalculator extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText weightEditText, heightEditText, ageEditText;
    private TextView bmiTextView;
    private Spinner genderSpinner;
    private int selectedGender, age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_calculator);

        weightEditText = findViewById(R.id.editTextWeight);
        heightEditText = findViewById(R.id.editTextHeight);
        ageEditText = findViewById(R.id.editTextAge);
        bmiTextView = findViewById(R.id.textViewBMI);
        genderSpinner = findViewById(R.id.spinnerGender);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.gender_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderSpinner.setAdapter(adapter);
        genderSpinner.setOnItemSelectedListener(this);

        weightEditText.addTextChangedListener(textWatcher);
        heightEditText.addTextChangedListener(textWatcher);
        ageEditText.addTextChangedListener(textWatcher);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selectedGender = position;
        calculateBMI();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // do nothing
    }

    private void calculateBMI() {
        if (weightEditText.getText().toString().isEmpty() || heightEditText.getText().toString().isEmpty()
                || ageEditText.getText().toString().isEmpty()) {
            bmiTextView.setText("");
            return;
        }

        double weight = Double.parseDouble(weightEditText.getText().toString());
        double height = Double.parseDouble(heightEditText.getText().toString()) / 100.0;
        age = Integer.parseInt(ageEditText.getText().toString());

        double ppm;
        if (selectedGender == 0) { // female
            ppm = 655.1 + (9.563 * weight) + (1.85 * height * 100.0) - (4.676 * age);
        } else { // male
            ppm = 66.5 + (13.75 * weight) + (5.003 * height * 100.0) - (6.775 * age);
        }

        double bmi = weight / (height * height);

        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String result = getString(R.string.bmi_result, decimalFormat.format(bmi), decimalFormat.format(ppm));
        bmiTextView.setText(result);
    }

    private final TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            calculateBMI();
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };
}