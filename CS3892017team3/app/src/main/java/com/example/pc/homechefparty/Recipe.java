package com.example.pc.homechefparty;

import java.util.List;

/**
 * Created by Daniel on 3/27/2017.
 */

public class  Recipe {

    private String cookTime;
    private String prepTime;
    private String recipeName;
    private List<String> labels;
    private List<String> recipeSteps;
    private List<String> ingredientsList;


    public Recipe(){}

    public Recipe(String cookTime, String prepTime, String recipeName, List<String> labels, List<String> recipeSteps, List<String> ingredients){

        this.cookTime = cookTime;
        this.prepTime = prepTime;
        this.recipeName = recipeName;
        this.labels = labels;
        this.recipeSteps = recipeSteps;
        this.ingredientsList = ingredientsList;
    }

    public String getCookTime(){
        return cookTime;
    }

    public void setCookTime(String cookTime) {this.cookTime=cookTime;}

    public String getPrepTime(){
        return prepTime;
    }

    public void setPrepTime(String prepTime) {this.prepTime=prepTime; }

    public String getRecipeName(){
        return recipeName;
    }

    public void setRecipeName(String recipeName){ this.recipeName= recipeName;}

    public List<String> getLabels(){
        return labels;
    }

    public void setLabels(String label, int labelNumber){
        List<String> labels = null;
        labels.add(labelNumber, label);
    }

    public List<String> getRecipeSteps(){
        return recipeSteps;
    }

    public void setRecipeSteps(String recipeStep, int stepNumber){
        List<String> recipeSteps = null;
        recipeSteps.add(stepNumber, recipeStep);
    }

    public List<String> getIngredients() { return ingredientsList; }

    public void setIngredients(String ingredient, int ingredientNumber)
    {
        List<String> ingredientsList = null;
        ingredientsList.add(ingredientNumber, ingredient);
    }




}
