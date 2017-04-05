package com.example.pc.homechefparty;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by pc on 2017/3/19.
 */

public class Upload extends Activity {
    Button recipe_upload;
    EditText recipe_name;
    EditText recipe_label;
    Firebase main_ref;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = database.getReference();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);

        main_ref = new Firebase("https://homechefparty-e0f77.firebaseio.com/");
        recipe_upload = (Button)findViewById(R.id.bt_upload);
        recipe_name = (EditText)findViewById(R.id.et_recipe);
        recipe_label = (EditText)findViewById(R.id.et_labels);

        recipe_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String getvalue_name = recipe_name.getText().toString();
                String getvalue_label = recipe_label.getText().toString();
                Recipe r = new Recipe();
                r.setRecipeName(getvalue_name);
                databaseReference.child("Recipes").push().setValue(r);



                ;
            }
        });
    }
}
