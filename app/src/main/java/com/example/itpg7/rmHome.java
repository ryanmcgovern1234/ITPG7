package com.example.itpg7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.itpg7.HelperClasses.HomeAdapter.FeaturedAdapter;
import com.example.itpg7.HelperClasses.HomeAdapter.FeaturedHelperClass;
import com.google.android.material.bottomnavigation.BottomNavigationView;

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

        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);

        //Set Selected
        bottomNavigationView.setSelectedItemId(R.id.navigation_home);

        //Listener to give functionality
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.navigation_home:
                        startActivity(new Intent(getApplicationContext(), rmHome.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.navigation_clientoverview:
                        startActivity(new Intent(getApplicationContext(), ClientOverviewPage.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.navigation_dashboard:
                        startActivity(new Intent(getApplicationContext(), MarketView.class));
                        overridePendingTransition(0, 0);
                        return true;

                }
                return false;
            }
        });
        
        
        



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