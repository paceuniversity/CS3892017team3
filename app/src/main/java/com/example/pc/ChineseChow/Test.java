package com.example.pc.ChineseChow;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.client.ValueEventListener;
import com.firebase.client.authentication.Constants;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pc on 2017/4/14.
 */

public class Test extends Activity {
    Map<String,String> map = new HashMap<String,String>();
    String recipeUrl;
    String recipeNamefromupload;
    private TextView recipeName;
    Firebase ref;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.test);

        Bundle extras = getIntent().getExtras();
        recipeUrl=extras.getString("linkForTest");
        recipeNamefromupload = extras.getString("namefortest");
        Log.i("recipe's link",recipeUrl);
        Log.i("recipe's name",recipeNamefromupload);
        map.put(recipeUrl,recipeNamefromupload);
    /*    ref = new Firebase(recipeUrl);
        ref.child("recipeName").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
            recipeName.setText(value);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });*/



    }
}
