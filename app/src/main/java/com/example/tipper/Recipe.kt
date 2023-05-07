package com.example.tipper

import com.example.tipper.Question
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.os.Bundle
import com.example.tipper.R
import android.content.Intent
import android.text.TextUtils
import android.widget.ArrayAdapter
import android.widget.AdapterView.OnItemClickListener
import android.widget.AdapterView
import android.widget.RadioGroup
import com.example.tipper.Quiz
import android.widget.RadioButton
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.EditText
import android.widget.Spinner
import android.text.TextWatcher
import android.text.Editable
import com.example.tipper.MainActivity
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.data.LineData

class Recipe : AppCompatActivity() {
    private lateinit var recipeNameTextView: TextView
    private lateinit var ingredientsTextView: TextView
    private lateinit var directionsTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe)
        val intent = intent
        val recipeName = intent.getStringExtra("recipe_name")
        val ingredients = intent.getStringExtra("recipe_ingredients")
        val directions = intent.getStringExtra("recipe_directions")
        recipeNameTextView = findViewById(R.id.textView_recipe_name)
        recipeNameTextView.setText(recipeName)
        ingredientsTextView = findViewById(R.id.textView_recipe_ingredients)
        ingredientsTextView.setText(ingredients)
        directionsTextView = findViewById(R.id.textView_recipe_directions)
        directionsTextView.setText(directions)
    }
}