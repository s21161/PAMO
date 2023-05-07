package com.example.tipper

import com.example.tipper.Question
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.os.Bundle
import com.example.tipper.R
import android.content.Intent
import android.graphics.Color
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
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.data.LineData
import java.util.ArrayList

class BmiChartActivity : AppCompatActivity() {
    private lateinit var mChart: LineChart
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chart_bmi)

        // Inicjalizacja wykresu
        mChart = findViewById(R.id.chartBmi)
        mChart.setDragEnabled(true)
        mChart.setScaleEnabled(true)

        // Tworzenie danych do wykresu (fikcyjne dane)
        val entries: MutableList<Entry> = ArrayList()
        entries.add(Entry(0F, 22.5f))
        entries.add(Entry(1F, 23.0f))
        entries.add(Entry(2F, 24.5f))
        entries.add(Entry(3F, 24.0f))
        entries.add(Entry(4F, 25.5f))
        entries.add(Entry(5F, 26.0f))

        // Ustawianie danych na wykresie
        val dataSet = LineDataSet(entries, "BMI")
        dataSet.color = Color.BLUE
        dataSet.lineWidth = 2f
        dataSet.circleRadius = 4f
        val lineData = LineData(dataSet)
        mChart.setData(lineData)

        // Ustawianie opisu wykresu
        val description = Description()
        description.text = "Zmiany BMI w czasie"
        mChart.setDescription(description)

        // Odświeżanie wykresu
        mChart.invalidate()
    }
}