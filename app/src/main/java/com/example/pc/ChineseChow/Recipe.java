package com.example.pc.ChineseChow;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel on 3/27/2017.
 */

public class  Recipe {

    private String cookTime;
    private String prepTime;
    private String recipeName;
    private String recipeSteps;
    private List<String> ingredientsList;
    private String servingSize;
    private String imageUri;
    public Recipe(){}

    public Recipe(String cookTime, String prepTime, String recipeName, String recipeSteps, List<String> ingredientsList, String servingSize, String imageUri){

        this.cookTime = cookTime;
        this.prepTime = prepTime;
        this.recipeName = recipeName;

        this.recipeSteps = recipeSteps;
        this.servingSize = servingSize;
        this.ingredientsList = ingredientsList;

        this.imageUri = imageUri;
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

    public List<String> getIngredientsList() { return ingredientsList; }

    public void setIngredientsList(List ingredientsList)
    {
        this.ingredientsList = ingredientsList;
    }


    public String getServingSize() {
        return servingSize;
    }

    public void setServingSize(String servingSize) {
        this.servingSize = servingSize;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }


}
