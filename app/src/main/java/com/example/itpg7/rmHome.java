package com.example.itpg7;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class rmHome extends AppCompatActivity {
    private Button buttonnews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rmhome);

        buttonnews = (Button) findViewById(R.id.newsbutton);
        buttonnews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                moveToNewspage();

            }
        });

    }

    private void moveToNewspage(){

        Intent intent = new Intent(rmHome.this, Newspage.class);
        startActivity(intent);

    }
}