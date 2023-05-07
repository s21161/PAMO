package com.example.tipper

import com.example.tipper.Question
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tipper.R
import android.content.Intent
import android.text.TextUtils
import android.widget.AdapterView.OnItemClickListener
import com.example.tipper.Quiz
import android.widget.AdapterView.OnItemSelectedListener
import android.text.TextWatcher
import android.text.Editable
import android.view.View
import android.widget.*
import com.example.tipper.MainActivity
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.data.LineData
import java.util.*

class QuizActivity : AppCompatActivity() {
    private lateinit var questionTextView: TextView
    private lateinit var optionsRadioGroup: RadioGroup
    private lateinit var submitButton: Button
    private var quiz: Quiz? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        // Inicjalizacja elementów interfejsu użytkownika
        questionTextView = findViewById(R.id.questionTextView)
        optionsRadioGroup = findViewById(R.id.optionsRadioGroup)
        submitButton = findViewById(R.id.submitButton)

        // Inicjalizacja quizu
        quiz = Quiz()

        // Ustawienie pierwszego pytania na ekranie
        displayQuestion()

        // Obsługa kliknięcia przycisku "Submit"
        submitButton.setOnClickListener(View.OnClickListener {
            val selectedOptionId = optionsRadioGroup.getCheckedRadioButtonId()
            if (selectedOptionId != -1) {
                val selectedOptionRadioButton = findViewById<RadioButton>(selectedOptionId)
                val selectedOption = optionsRadioGroup.indexOfChild(selectedOptionRadioButton) + 1
                quiz!!.answerQuestion(selectedOption)
                if (quiz!!.isQuizFinished) {
                    // Quiz zakończony, wyświetlenie wyników
                    showQuizResults()
                } else {
                    // Wyświetlenie kolejnego pytania
                    displayQuestion()
                }
            }
        })
    }

    private fun displayQuestion() {
        // Wyświetlenie aktualnego pytania na ekranie
        val currentQuestion = quiz?.getCurrentQuestion()
        if (currentQuestion != null) {
            questionTextView.setText(currentQuestion.javaClass)
        }
        val optionRadioButtons = arrayOfNulls<RadioButton>(4)
        optionRadioButtons[0] = findViewById(R.id.option1RadioButton)
        optionRadioButtons[1] = findViewById(R.id.option2RadioButton)
        optionRadioButtons[2] = findViewById(R.id.option3RadioButton)
        optionRadioButtons[3] = findViewById(R.id.option4RadioButton)
        for (i in 0..3) {
            if (currentQuestion != null) {
                optionRadioButtons[i].setText(currentQuestion.javaClass[i])
            }
        }
        optionsRadioGroup!!.clearCheck()
    }

    private fun showQuizResults() {
        // Wyświetlenie wyników quizu
        val correctAnswers = quiz?.getCorrectAnswers()
        val totalQuestions = quiz?.getTotalQuestions()
        val quizPercentage = quiz?.getQuizPercentage()
        val results = String.format(
            Locale.getDefault(),
            "Wynik: %d/%d (%.2f%%)",
            correctAnswers,
            totalQuestions,
            quizPercentage
        )
        questionTextView!!.text = results
        optionsRadioGroup!!.visibility = View.GONE
        submitButton!!.isEnabled = false
    }
}

private fun TextView.setText(javaClass: Class<Unit>) {

}

private operator fun <T> Class<T>.get(i: Int) {

}

private fun RadioButton?.setText(any: Any) {

}
