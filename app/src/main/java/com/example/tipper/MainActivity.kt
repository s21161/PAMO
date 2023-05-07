package com.example.tipper

import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.TextView
import android.os.Bundle
import com.example.tipper.R
import android.content.Intent
import com.example.tipper.KcalCalculator
import com.example.tipper.Recipes
import com.example.tipper.QuizActivity
import com.example.tipper.BmiChartActivity
import android.text.TextWatcher
import android.text.Editable
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var heightEditText: EditText
    private lateinit var weightEditText: EditText
    private var bmiTextView: TextView? = null
    private var harrisTextView: TextView? = null
    private lateinit var recipesButton: Button
    private val recipes = arrayOf("Przepis 1", "Przepis 2")
    private val recipeDescriptions = arrayOf("Opis przepisu 1", "Opis przepisu 2")
    private val recipeIngredients = arrayOf(
        "Składnik 1 przepisu 1, Składnik 2 przepisu 1",
        "Składnik 1 przepisu 2, Składnik 2 przepisu 2"
    )
    private lateinit var bmiButton: Button
    private lateinit var quizButton: Button
    private lateinit var bmiChart: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bmiButton = findViewById(R.id.button_bmi)
        heightEditText = findViewById(R.id.heightEditText)
        weightEditText = findViewById(R.id.weightEditText)
        bmiTextView = findViewById(R.id.bmiTextView)
        harrisTextView = findViewById(R.id.harrisTextView)
        recipesButton = findViewById(R.id.button_recipes)
        quizButton = findViewById(R.id.button_quiz)
        bmiChart = findViewById(R.id.button_chart)
        bmiChart.setOnClickListener(this)
        quizButton.setOnClickListener(this)
        recipesButton.setOnClickListener(this)
        bmiButton.setOnClickListener(this)
        heightEditText.addTextChangedListener(textWatcher)
        weightEditText.addTextChangedListener(textWatcher)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.button_bmi -> startActivity(Intent(this, KcalCalculator::class.java))
            R.id.button_recipes -> startActivity(Intent(this, Recipes::class.java))
            R.id.button_quiz -> startActivity(Intent(this, QuizActivity::class.java))
            R.id.button_chart -> startActivity(Intent(this, BmiChartActivity::class.java))
        }
    }

    private val textWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
        override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
            calculateBmi()
        }

        override fun afterTextChanged(editable: Editable) {}
        private fun calculateBmi() {
            val heightString = heightEditText!!.text.toString()
            val weightString = weightEditText!!.text.toString()
            if (heightString.isEmpty() || weightString.isEmpty()) {
                bmiTextView!!.text = ""
                return
            }
            val height = heightString.toFloat()
            val weight = weightString.toFloat()
            val height2 = heightString.toFloat() / 100
            val bmi = weight / (height2 * height2)
            bmiTextView!!.text = String.format("BMI: %.2f", bmi)
            val age = 30 // you can change this to the user's age
            val bmr: Int
            val isMale = true // you can change this to the user's gender
            bmr = if (isMale) {
                (66.5 + 13.75 * weight + 5.003 * height - 6.775 * age).toInt()
            } else {
                (655.1 + 9.563 * weight + 1.85 * height - 4.676 * age).toInt()
            }
        }
    }
}