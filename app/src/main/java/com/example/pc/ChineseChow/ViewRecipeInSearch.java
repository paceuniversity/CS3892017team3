package com.example.pc.ChineseChow;

import android.app.Activity;
import android.content.Context;
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
<<<<<<< HEAD:app/src/main/java/com/example/pc/ChineseChow/Test.java

import org.w3c.dom.Text;

import static com.example.pc.ChineseChow.Search.recipeName;
=======
>>>>>>> d126da8161c8ed8e3e8273bb6db63e9d33a3f3b1:app/src/main/java/com/example/pc/ChineseChow/ViewRecipeInSearch.java

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
<<<<<<< HEAD:app/src/main/java/com/example/pc/ChineseChow/Test.java
    ImageView image;
    Context context;

=======
    ImageView recipeImg;
>>>>>>> d126da8161c8ed8e3e8273bb6db63e9d33a3f3b1:app/src/main/java/com/example/pc/ChineseChow/ViewRecipeInSearch.java
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.view_recipe);



<<<<<<< HEAD:app/src/main/java/com/example/pc/ChineseChow/Test.java
        nameofRecipe = (TextView) (findViewById(R.id.textView));
        cookTime = (TextView) (findViewById(R.id.textView2)) ;
        image = (ImageView)findViewById(R.id.iv_image_recipe);
=======
        nameofRecipe = (TextView) (findViewById(R.id.recipeName));
        cookTime = (TextView) (findViewById(R.id.cookTime));
        prepTime = (TextView) (findViewById(R.id.prepTime));
        recipeSteps = (TextView) (findViewById(R.id.recipeDesc));
        ingredients = (TextView) (findViewById(R.id.ingredientsList));
        //recipeImg = (ImageView) (findViewById(R.id.recipeImage));
>>>>>>> d126da8161c8ed8e3e8273bb6db63e9d33a3f3b1:app/src/main/java/com/example/pc/ChineseChow/ViewRecipeInSearch.java

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
<<<<<<< HEAD:app/src/main/java/com/example/pc/ChineseChow/Test.java
                Picasso.with(getApplicationContext()).load(value.getImageUri()).into(image);
=======
                prepTime.setText(value.getPrepTime());
                recipeSteps.setText(value.getRecipeSteps());
                ingredients.setText(value.getIngredients());





>>>>>>> d126da8161c8ed8e3e8273bb6db63e9d33a3f3b1:app/src/main/java/com/example/pc/ChineseChow/ViewRecipeInSearch.java


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
