package com.example.tipper;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

public class BmiChartActivity extends AppCompatActivity {

    private LineChart mChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart_bmi);

        // Inicjalizacja wykresu
        mChart = findViewById(R.id.chartBmi);
        mChart.setDragEnabled(true);
        mChart.setScaleEnabled(true);

        // Tworzenie danych do wykresu (fikcyjne dane)
        List<Entry> entries = new ArrayList<>();
        entries.add(new Entry(0, 22.5f));
        entries.add(new Entry(1, 23.0f));
        entries.add(new Entry(2, 24.5f));
        entries.add(new Entry(3, 24.0f));
        entries.add(new Entry(4, 25.5f));
        entries.add(new Entry(5, 26.0f));

        // Ustawianie danych na wykresie
        LineDataSet dataSet = new LineDataSet(entries, "BMI");
        dataSet.setColor(Color.BLUE);
        dataSet.setLineWidth(2f);
        dataSet.setCircleRadius(4f);
        LineData lineData = new LineData(dataSet);
        mChart.setData(lineData);

        // Ustawianie opisu wykresu
        Description description = new Description();
        description.setText("Zmiany BMI w czasie");
        mChart.setDescription(description);

        // Odświeżanie wykresu
        mChart.invalidate();
    }
}
