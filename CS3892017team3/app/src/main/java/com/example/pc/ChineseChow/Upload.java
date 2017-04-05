package com.example.pc.ChineseChow;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.sql.Array;
import java.util.List;

/**
 * Created by pc on 2017/3/19.
 */

public class Upload extends Activity {
    Button recipe_upload;
    EditText ingredients;
    EditText recipeSteps;
    EditText recipe_name;
    EditText prepTime;
    EditText cookTime;
    Firebase main_ref;
    ImageButton selectimage;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = database.getReference();

    private static final int imagerequest = 1;
    private Uri mimageUri=null;
    private StorageReference mStorage;
    private ProgressDialog mProgress;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);

        mStorage = FirebaseStorage.getInstance().getReference();

        selectimage = (ImageButton)findViewById(R.id.bt_addimage);

        main_ref = new Firebase("https://homechefparty-e0f77.firebaseio.com/");
        recipe_upload = (Button)findViewById(R.id.bt_upload);
        recipe_name = (EditText)findViewById(R.id.et_recipe);
        cookTime = (EditText) findViewById(R.id.cookTime);
        prepTime = (EditText) findViewById(R.id.prepTime);
        recipeSteps = (EditText) findViewById(R.id.recipeSteps);
        ingredients = (EditText) findViewById(R.id.ingredients);


        recipe_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getrecipeName = recipe_name.getText().toString();
                String getcookTime = cookTime.getText().toString();
                String getprepTime = prepTime.getText().toString();
                String getRecipeSteps = recipeSteps.getText().toString();
                String getIngredient = ingredients.getText().toString();

                Recipe r = new Recipe();

                r.setIngredients(getIngredient);
                r.setRecipeName(getrecipeName);
                r.setCookTime(getcookTime);
                r.setPrepTime(getprepTime);
                r.setRecipeSteps(getRecipeSteps);
                databaseReference.child("Recipes").push().setValue(r);



                ;
            }
        });
        selectimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent gallaryIntent = new Intent(Intent.ACTION_GET_CONTENT);
                gallaryIntent.setType("image/*");
                startActivityForResult(gallaryIntent, imagerequest);
            }
        });

        recipe_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startposting();
            }
        });

    }
    private void startposting() {

        mProgress.setMessage("Now Posting....");
        mProgress.show();

        String getrecipeNameforPicture = recipe_name.getText().toString();
        if(!TextUtils.isEmpty(getrecipeNameforPicture)&& mimageUri!=null){
            StorageReference filepath =  mStorage.child("Recipe_Images").child(mimageUri.getLastPathSegment());
            filepath.putFile(mimageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    @SuppressWarnings("VisibleForTests")Uri downloadUri = taskSnapshot.getDownloadUrl();
                    mProgress.dismiss();
                }
            });
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == imagerequest && resultCode==RESULT_OK){
            mimageUri = data.getData();
            selectimage.setImageURI(mimageUri );
        }
    }

}

