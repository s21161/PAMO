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
import android.view.View
import com.example.tipper.MainActivity
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.data.LineData
import java.text.DecimalFormat

class KcalCalculator : AppCompatActivity(), OnItemSelectedListener {
    private lateinit var weightEditText: EditText
    private lateinit var heightEditText: EditText
    private lateinit var ageEditText: EditText
    private lateinit var bmiTextView: TextView
    private lateinit var genderSpinner: Spinner
    private var selectedGender = 0
    private var age = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi_calculator)
        weightEditText = findViewById(R.id.editTextWeight)
        heightEditText = findViewById(R.id.editTextHeight)
        ageEditText = findViewById(R.id.editTextAge)
        bmiTextView = findViewById(R.id.textViewBMI)
        genderSpinner = findViewById(R.id.spinnerGender)
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.gender_array, android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        genderSpinner.setAdapter(adapter)
        genderSpinner.setOnItemSelectedListener(this)
        weightEditText.addTextChangedListener(textWatcher)
        heightEditText.addTextChangedListener(textWatcher)
        ageEditText.addTextChangedListener(textWatcher)
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
        selectedGender = position
        calculateBMI()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        // do nothing
    }

    private fun calculateBMI() {
        if (weightEditText!!.text.toString().isEmpty() || heightEditText!!.text.toString().isEmpty()
            || ageEditText!!.text.toString().isEmpty()
        ) {
            bmiTextView!!.text = ""
            return
        }
        val weight = weightEditText!!.text.toString().toDouble()
        val height = heightEditText!!.text.toString().toDouble() / 100.0
        age = ageEditText!!.text.toString().toInt()
        val ppm: Double
        ppm = if (selectedGender == 0) { // female
            655.1 + 9.563 * weight + 1.85 * height * 100.0 - 4.676 * age
        } else { // male
            66.5 + 13.75 * weight + 5.003 * height * 100.0 - 6.775 * age
        }
        val bmi = weight / (height * height)
        val decimalFormat = DecimalFormat("#.##")
        val result =
            getString(R.string.bmi_result, decimalFormat.format(bmi), decimalFormat.format(ppm))
        bmiTextView!!.text = result
    }

    private val textWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            calculateBMI()
        }

        override fun afterTextChanged(s: Editable) {}
    }
}