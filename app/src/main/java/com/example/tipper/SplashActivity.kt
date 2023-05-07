package com.example.tipper

import com.example.tipper.Question
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.os.Bundle
import com.example.tipper.R
import android.content.Intent
import android.os.Handler
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

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        // Tworzy obiekt Handler, który opóźnia uruchomienie nowej aktywności
        Handler().postDelayed({ // Uruchom nową aktywność po zakończeniu czasu opóźnienia
            val i = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(i)

            // Zamknij obecną aktywność
            finish()
        }, 3000)
    }
}