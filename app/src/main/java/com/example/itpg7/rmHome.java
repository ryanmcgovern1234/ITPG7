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

public class rmHome extends AppCompatActivity{

    RecyclerView newsRecycler;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN;
        setContentView(R.layout.activity_rmhome);

        //hooks
        newsRecycler = findViewById(R.id.news_recycler);

        newsRecycler();

        
        
        



    }

    private void newsRecycler() {
        newsRecycler.setHasFixedSize(true);
        newsRecycler.setLayoutManager(new LinearLayoutManager( this,LinearLayoutManager.HORIZONTAL, false));
    }


}