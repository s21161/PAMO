package com.example.tipper;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
public class MyOnItemClickListener implements AdapterView.OnItemClickListener {

    private String[] recipes;
    private String[] recipeDescriptions;
    private String[] recipeIngredients;
    private TextView recommendedRecipeTextView;

    public MyOnItemClickListener(String[] recipes, String[] recipeDescriptions, String[] recipeIngredients, TextView recommendedRecipeTextView) {
        this.recipes = recipes;
        this.recipeDescriptions = recipeDescriptions;
        this.recipeIngredients = recipeIngredients;
        this.recommendedRecipeTextView = recommendedRecipeTextView;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String recommendedRecipe = recipes[position];
        String recommendedRecipeDescription = recipeDescriptions[position];
        String recommendedRecipeIngredients = recipeIngredients[position];
        recommendedRecipeTextView.setText("Recommended recipe: " + recommendedRecipe + "\n\n" + recommendedRecipeDescription + "\n\nIngredients: " + recommendedRecipeIngredients);
    }
}