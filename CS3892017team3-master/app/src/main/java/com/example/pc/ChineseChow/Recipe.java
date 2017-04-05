package com.example.pc.ChineseChow;

import java.util.List;

/**
 * Created by Daniel on 3/27/2017.
 */

public class  Recipe {

    private String cookTime;
    private String prepTime;
    private String recipeName;
    private String recipeSteps;
    private String ingredientsList;
    private String servingSize;

    public Recipe(){}

    public Recipe(String cookTime, String prepTime, String recipeName, String recipeSteps, String ingredientsList, String servingSize){

        this.cookTime = cookTime;
        this.prepTime = prepTime;
        this.recipeName = recipeName;

        this.recipeSteps = recipeSteps;
        this.servingSize = servingSize;
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

    public String getRecipeSteps(){
        return recipeSteps;
    }

    public void setRecipeSteps(String recipeStep){
        this.recipeSteps = recipeStep;
    }

    public String getIngredients() { return ingredientsList; }

    public void setIngredients(String ingredientsList)
    {
        this.ingredientsList = ingredientsList;
    }


    public String getServingSize() {
        return servingSize;
    }

    public void setServingSize(String servingSize) {
        this.servingSize = servingSize;
    }
}
