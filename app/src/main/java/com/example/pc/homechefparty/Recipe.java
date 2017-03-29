package com.example.daniel.chinesefood;

import java.util.List;

/**
 * Created by Daniel on 3/27/2017.
 */

public class Recipe {

    private int cookTime;
    private int prepTime;
    private String recipeName;
    private List<String> labels;
    private List<String> recipeSteps;


    public Recipe(){}

    public Recipe(int cookTime, int prepTime, String recipeName, List<String> labels, List<String> recipeSteps){

        this.cookTime = cookTime;
        this.prepTime = prepTime;
        this.recipeName = recipeName;
        this.labels = labels;
        this.recipeSteps = recipeSteps;
    }

    public int getCookTime(){
        return cookTime;
    }

    public int getPrepTime(){
        return prepTime;
    }

    public String getRecipeName(){
        return recipeName;
    }

    public List<String> getLabels(){
        return labels;
    }

    public List<String> getRecipeSteps(){
        return recipeSteps;
    }
}
