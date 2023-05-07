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

class Question(
    val questionText: String,
    val option1: String,
    val option2: String,
    val option3: String,
    val option4: String,
    val correctOption: Int
) {

    val options: Array<String?>
        get() = arrayOf(option1, option2, option3, option4)
}