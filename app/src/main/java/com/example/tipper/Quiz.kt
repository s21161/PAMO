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
import java.util.ArrayList

class Quiz {
    private val questions: MutableList<Question>
    private var currentQuestionIndex: Int
    var correctAnswers: Int
        private set

    init {
        questions = ArrayList()
        currentQuestionIndex = 0
        correctAnswers = 0
        // Dodaj pytania do listy
        addQuestions()
    }

    private fun addQuestions() {
        // Dodaj pytania do listy
        questions.add(
            Question(
                "Co jest najlepszym źródłem białka?",
                "Mięso",
                "Ryby",
                "Warzywa",
                "Owoce",
                1
            )
        )
        questions.add(
            Question(
                "Które z poniższych nie jest zdrowym tłuszczem?",
                "Masło",
                "Awokado",
                "Orzechy",
                "Oliwa z oliwek",
                1
            )
        )
        questions.add(
            Question(
                "Ile wody powinno się pić dziennie?",
                "1 litr",
                "2 litry",
                "3 litry",
                "4 litry",
                2
            )
        )
        questions.add(
            Question(
                "Które z poniższych jest źródłem węglowodanów złożonych?",
                "Chleb pełnoziarnisty",
                "Biały chleb",
                "Cukier",
                "Bakłażan",
                1
            )
        )
        questions.add(
            Question(
                "Które z poniższych jest najbogatszym źródłem witaminy C?",
                "Marchewka",
                "Pomarańcza",
                "Banany",
                "Gruszka",
                2
            )
        )
        questions.add(
            Question(
                "Które z poniższych nie jest źródłem wapnia?",
                "Mleko",
                "Ser",
                "Jogurt",
                "Kiełbasa",
                4
            )
        )
    }

    val currentQuestion: Question
        get() = questions[currentQuestionIndex]

    fun answerQuestion(selectedOption: Int) {
        if (selectedOption == currentQuestion.correctOption) {
            correctAnswers++
        }
        currentQuestionIndex++
    }

    fun getCurrentQuestion() {

    }

    fun getCorrectAnswers() {

    }

    fun getTotalQuestions() {

    }

    fun getQuizPercentage() {

    }

    val isQuizFinished: Boolean
        get() = currentQuestionIndex == questions.size
    val totalQuestions: Int
        get() = questions.size
    val quizPercentage: Double
        get() = correctAnswers.toDouble() / questions.size * 100
}