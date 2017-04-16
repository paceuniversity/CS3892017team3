package com.example.pc.ChineseChow;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecipe_list;
    private DatabaseReference mdatabase;
    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<Recipe,RecipeViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Recipe, RecipeViewHolder>(

                Recipe.class,
                R.layout.recipe_list,
                RecipeViewHolder.class,
                mdatabase

        ) {

            @Override
            protected void populateViewHolder(RecipeViewHolder viewHolder, Recipe model, int position) {
                viewHolder.setRecipename(model.getRecipeName());
                viewHolder.setImage(getApplicationContext(),model.getImageUri());
            }
        };
        mRecipe_list.setAdapter(firebaseRecyclerAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mdatabase = FirebaseDatabase.getInstance().getReference().child("Recipes");
       mRecipe_list = (RecyclerView)findViewById(R.id.recipe_list);
       mRecipe_list.setHasFixedSize(true);
       mRecipe_list.setLayoutManager(new LinearLayoutManager(this));


       Firebase.setAndroidContext(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



    }


    public static class RecipeViewHolder extends RecyclerView.ViewHolder{
        View mView;

        public RecipeViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
        }
        public void setRecipename(String name){

            TextView post_name = (TextView)mView.findViewById(R.id.recipe_list_title);
            post_name.setText(name);
        }
        public void setImage(Context ctx, String image){

            ImageView post_image = (ImageView)mView.findViewById(R.id.recipe__list_image);
            Picasso.with(ctx).load(image).into(post_image);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }else if(id == R.id.action_upload){
            Intent intent = new Intent(this,Upload.class);
            startActivity(intent);
        }
        else if (id == R.id.action_search){
            Intent intent = new Intent(this,Search.class);
            startActivity(intent);
        }



        return super.onOptionsItemSelected(item);
    }
}
