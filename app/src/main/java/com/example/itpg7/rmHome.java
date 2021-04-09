package com.example.itpg7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class rmHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rm_home);
        //Initialize Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);

        //Set Selected
        bottomNavigationView.setSelectedItemId(R.id.navigation_home);

        //Listener to give functionality
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.navigation_home:
                        return true;
                    case R.id.navigation_clientoverview:
                        startActivity(new Intent(getApplicationContext(),ClientOverviewPage.class));
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
}