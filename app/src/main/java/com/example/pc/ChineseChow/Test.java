package com.example.pc.ChineseChow;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.client.ValueEventListener;
import com.firebase.client.authentication.Constants;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import static com.example.pc.ChineseChow.Search.recipeName;

/**
 * Created by pc on 2017/4/14.
 */

public class Test extends Activity {

    TextView nameofRecipe;
    TextView cookTime;
    TextView prepTime;
    TextView recipeSteps;
    TextView ingredients;
    Button mtomain;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.test);



        nameofRecipe = (TextView) (findViewById(R.id.textView));
        cookTime = (TextView) (findViewById(R.id.textView2)) ;


        mtomain = (Button)findViewById(R.id.bt_tomain);
        mtomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Test.this,MainActivity.class);
                startActivity(i);
            }
        });
        DatabaseReference databaseReference =  FirebaseDatabase.getInstance().getReferenceFromUrl("https://homechefparty-e0f77.firebaseio.com/Recipes");

        databaseReference.orderByChild("recipeName").equalTo(Search.recipeName).addChildEventListener(new ChildEventListener() {
            public void onChildAdded(com.google.firebase.database.DataSnapshot dataSnapshot, String s) {
                Recipe value = dataSnapshot.getValue(Recipe.class);
                nameofRecipe.setText(value.getRecipeName());
                cookTime.setText(value.getCookTime());



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
