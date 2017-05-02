package com.example.pc.ChineseChow;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

/**
 * Created by Turmateniri on 4/19/2017.
 */

public class RecipeFeed extends AppCompatActivity {

    private RecyclerView mRecipe_list;
    private LinearLayoutManager mLayoutManager;
    private DatabaseReference mdatabase;

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<Recipe, RecipeFeed.RecipeViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Recipe, RecipeFeed.RecipeViewHolder>(

                Recipe.class,
                R.layout.recipe_list,
                RecipeFeed.RecipeViewHolder.class,
                mdatabase

        ) {

            @Override
            protected void populateViewHolder(RecipeFeed.RecipeViewHolder viewHolder, Recipe model, int position) {
                viewHolder.setRecipename(model.getRecipeName());
                viewHolder.setImage(getApplicationContext(), model.getImageUri());
            }
        };
        mRecipe_list.setAdapter(firebaseRecyclerAdapter);
        firebaseRecyclerAdapter.notifyDataSetChanged();

    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        mdatabase = FirebaseDatabase.getInstance().getReference().child("Recipes");
        mLayoutManager = new LinearLayoutManager(RecipeFeed.this);
        mLayoutManager.setReverseLayout(true);
        mLayoutManager.setStackFromEnd(true);
        mRecipe_list = (RecyclerView) findViewById(R.id.recipe_list);
        mRecipe_list.setHasFixedSize(true);
        mRecipe_list.setLayoutManager(mLayoutManager);


        Firebase.setAndroidContext(this);

    }

    public static class RecipeViewHolder extends RecyclerView.ViewHolder {
        View mView;

        public RecipeViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
        }

        public void setRecipename(String name) {

            TextView post_name = (TextView) mView.findViewById(R.id.recipe_list_title);
            post_name.setText(name);
        }

        public void setImage(Context ctx, String image) {

            ImageView post_image = (ImageView) mView.findViewById(R.id.recipe__list_image);
            Picasso.with(ctx).load(image).into(post_image);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_add:
                startActivity(new Intent(this,NameUpload.class));
                return true;
            case R.id.menu_search:
                startActivity(new Intent(this,Search.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
