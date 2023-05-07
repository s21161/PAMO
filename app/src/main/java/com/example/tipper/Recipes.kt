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
import android.widget.*
import com.example.tipper.MainActivity
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.data.LineData
import java.util.HashMap

class Recipes : AppCompatActivity() {
    private lateinit var recipeNames: Array<String>
    private var recipeMap: MutableMap<String, Array<String>>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipes)

        // Get the recipe names and their corresponding ingredients and directions from the string resources
        recipeNames = resources.getStringArray(R.array.list_of_recipes)
        val ingredients = resources.getStringArray(R.array.recipe_ingredients)
        val directions = resources.getStringArray(R.array.recipe_directions)

        // Create a map that links each recipe name to its corresponding ingredients and directions
        recipeMap = HashMap()
        for (i in recipeNames.indices) {
            val recipeName = recipeNames[i]
            val recipeIngredients = ingredients[i].split("\\r?\\n").toTypedArray()
            val recipeDirections = directions[i].split("\\r?\\n").toTypedArray()
            (recipeMap as HashMap<String, Array<String>>)[recipeName] = arrayOf(
                TextUtils.join("\n", recipeIngredients),
                TextUtils.join("\n", recipeDirections)
            )
        }

        // Set up the ListView to display the recipe names
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, recipeNames)
        val listView = findViewById<ListView>(R.id.ListView_recipes)
        listView.adapter = adapter

        // Set an item click listener for the ListView to launch the Recipe activity and pass the selected recipe's ingredients and directions
        listView.onItemClickListener = OnItemClickListener { parent, view, position, id ->
            val recipeName = recipeNames[position]
            val recipeData = (recipeMap as HashMap<String, Array<String>>).get(recipeName)!!
            val intent = Intent(this@Recipes, Recipe::class.java)
            intent.putExtra("recipe_name", recipeName)
            intent.putExtra("recipe_ingredients", recipeData[0])
            intent.putExtra("recipe_directions", recipeData[1])
            startActivity(intent)
        }
    }
}