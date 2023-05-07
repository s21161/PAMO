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

class MyOnItemClickListener(
    private val recipes: Array<String>,
    private val recipeDescriptions: Array<String>,
    private val recipeIngredients: Array<String>,
    private val recommendedRecipeTextView: TextView
) : OnItemClickListener {
    override fun onItemClick(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
        val recommendedRecipe = recipes[position]
        val recommendedRecipeDescription = recipeDescriptions[position]
        val recommendedRecipeIngredients = recipeIngredients[position]
        recommendedRecipeTextView.text =
            "Recommended recipe: $recommendedRecipe\n\n$recommendedRecipeDescription\n\nIngredients: $recommendedRecipeIngredients"
    }
}