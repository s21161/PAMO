package com.example.tipper;
import android.content.Intent;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText heightEditText;
    private EditText weightEditText;
    private TextView bmiTextView;
    private TextView harrisTextView;
    private Button recipesButton;


    private String[] recipes = {"Przepis 1", "Przepis 2"};
    private String[] recipeDescriptions = {"Opis przepisu 1", "Opis przepisu 2"};
    private String[] recipeIngredients = {"Składnik 1 przepisu 1, Składnik 2 przepisu 1", "Składnik 1 przepisu 2, Składnik 2 przepisu 2"};
    private Button bmiButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bmiButton = findViewById(R.id.button_bmi);
        heightEditText = findViewById(R.id.heightEditText);
        weightEditText = findViewById(R.id.weightEditText);
        bmiTextView = findViewById(R.id.bmiTextView);
        harrisTextView = findViewById(R.id.harrisTextView);
        recipesButton = findViewById(R.id.button_recipes);

        recipesButton.setOnClickListener(this);
        bmiButton.setOnClickListener(this);
        heightEditText.addTextChangedListener(textWatcher);
        weightEditText.addTextChangedListener(textWatcher);


        }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_bmi:
                startActivity(new Intent(this, KcalCalculator.class));
                break;
            case R.id.button_recipes:
                startActivity(new Intent(this, Recipes.class));
                break;
        }}

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


        private void calculateBmi() {
            String heightString = heightEditText.getText().toString();
            String weightString = weightEditText.getText().toString();

            if (heightString.isEmpty() || weightString.isEmpty()) {
                bmiTextView.setText("");
                return;
            }

            float height = Float.parseFloat(heightString);
            float weight = Float.parseFloat(weightString);

            float height2 = Float.parseFloat(heightString) / 100;
            float bmi = weight / (height2 * height2);

            bmiTextView.setText(String.format("BMI: %.2f", bmi));

            int age = 30; // you can change this to the user's age
            int bmr;

            boolean isMale = true; // you can change this to the user's gender

            if (isMale) {
                bmr = (int) (66.5 + (13.75 * weight) + (5.003 * height) - (6.775 * age));
            } else {
                bmr = (int) (655.1 + (9.563 * weight) + (1.85 * height) - (4.676 * age));
            }

        }


    };}