package com.example.pc.ChineseChow;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

/**
 * Created by pc on 2017/4/14.
 */

public class ViewRecipeInSearch extends Activity {

    TextView nameofRecipe;
    TextView cookTime;
    TextView prepTime;
    TextView recipeSteps;
    TextView ingredients;
    Button mtomain;
    ImageView recipeImg;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.view_recipe);



        nameofRecipe = (TextView) (findViewById(R.id.recipeName));
        cookTime = (TextView) (findViewById(R.id.cookTime));
        prepTime = (TextView) (findViewById(R.id.prepTime));
        recipeSteps = (TextView) (findViewById(R.id.recipeDesc));
        ingredients = (TextView) (findViewById(R.id.ingredientsList));
        //recipeImg = (ImageView) (findViewById(R.id.recipeImage));

        mtomain = (Button)findViewById(R.id.bt_tomain);
        mtomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ViewRecipeInSearch.this,MainActivity.class);
                startActivity(i);
            }
        });
        DatabaseReference databaseReference =  FirebaseDatabase.getInstance().getReferenceFromUrl("https://homechefparty-e0f77.firebaseio.com/Recipes");

        databaseReference.orderByChild("recipeName").equalTo(Search.recipeName).addChildEventListener(new ChildEventListener() {
            public void onChildAdded(com.google.firebase.database.DataSnapshot dataSnapshot, String s) {
                Recipe value = dataSnapshot.getValue(Recipe.class);
                nameofRecipe.setText(value.getRecipeName());
                cookTime.setText(value.getCookTime());
                prepTime.setText(value.getPrepTime());
                recipeSteps.setText(value.getRecipeSteps());
                //ingredients.setText(value.getIngredients());







            }

            @Override
            public void onChildChanged(com.google.firebase.database.DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(com.google.firebase.database.DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(com.google.firebase.database.DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });









    }
}
