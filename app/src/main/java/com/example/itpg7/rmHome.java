package com.example.itpg7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.itpg7.HelperClasses.HomeAdapter.FeaturedAdapter;
import com.example.itpg7.HelperClasses.HomeAdapter.FeaturedHelperClass;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class rmHome extends AppCompatActivity{

    RecyclerView newsRecycler;
    RecyclerView.Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_rmhome);

        //hooks
        newsRecycler = findViewById(R.id.news_recycler);

        newsRecycler();

        
        
        



    }

    private void newsRecycler() {
        newsRecycler.setHasFixedSize(true);
        newsRecycler.setLayoutManager(new LinearLayoutManager( this,LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelperClass(R.drawable.financialtimeslogo));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.lselogo));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.bbclogo));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.wallstreetjournal2));

        adapter = new FeaturedAdapter(featuredLocations);
        newsRecycler.setAdapter(adapter);
    }





}