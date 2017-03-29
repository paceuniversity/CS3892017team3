package com.example.pc.homechefparty;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class Uploadrecipe extends AppCompatActivity {
    ImageButton selectimage;
    EditText et_recipename;
    EditText et_description;
    Button bt_submit;
   private static final int imagerequest = 1;
    private Uri mimageUri=null;
    private StorageReference mStorage;
    private ProgressDialog mProgress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uploadrecipe);

        mStorage = FirebaseStorage.getInstance().getReference();

        selectimage = (ImageButton)findViewById(R.id.bt_addimage);
        et_recipename = (EditText)findViewById(R.id.et_recipe_name);
        et_description = (EditText)findViewById(R.id.et_description);
        bt_submit = (Button)findViewById(R.id.bt_submit);
        mProgress = new ProgressDialog(this);
        selectimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent gallaryIntent = new Intent(Intent.ACTION_GET_CONTENT);
                gallaryIntent.setType("image/*");
                startActivityForResult(gallaryIntent, imagerequest);
            }
        });

        bt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    startposting();
            }
        });

    }

    private void startposting() {

        mProgress.setMessage("Now Posting....");
        mProgress.show();

        String title_val = et_recipename.getText().toString().trim();
        String descri_val = et_description.getText().toString().trim();
        if(!TextUtils.isEmpty(title_val)&&!TextUtils.isEmpty(descri_val)&& mimageUri!=null){
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == imagerequest && resultCode==RESULT_OK){
             mimageUri = data.getData();
            selectimage.setImageURI(mimageUri );
        }
    }
}
