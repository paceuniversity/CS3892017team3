package com.example.pc.ChineseChow;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class ViewRecipeInFeed extends AppCompatActivity {
    String recipe_name;
    String image_url;
    String cooktime;
    String preptime;
    String steps;

    TextView tv_recipeName;
    ImageView im_image;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_recipe_in_feed);

        Bundle bundle = getIntent().getExtras();
        recipe_name = bundle.getString("name");
        image_url = bundle.getString("url");
        tv_recipeName = (TextView)findViewById(R.id.tv_recipe_name_in_view_feed);
        im_image = (ImageView)findViewById(R.id.im_image_in_view_feed);

        tv_recipeName.setText(recipe_name);


       Picasso.with(this).load(image_url).into(im_image);
    }
}
