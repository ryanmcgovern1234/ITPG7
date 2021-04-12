package com.example.itpg7.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.itpg7.R;
import com.example.itpg7.clientAdapter;
import com.example.itpg7.model;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.FirebaseDatabase;

public class ClientOverviewPage extends AppCompatActivity {

    RecyclerView clientRecyclerView;
    clientAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_overview_page);

        clientRecyclerView = (RecyclerView)findViewById(R.id.clientRecyclerView);
        clientRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<model> options =
                new FirebaseRecyclerOptions.Builder<model>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("clients"), model.class)
                        .build();

        adapter = new clientAdapter(options);
        clientRecyclerView.setAdapter(adapter);



      //  BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);

        //Set Selected
       // bottomNavigationView.setSelectedItemId(R.id.navigation_clientoverview);

        //Listener to give functionality
       // bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
        //    @Override
       //     public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
      //          switch (menuItem.getItemId()){
      //              case R.id.navigation_home:
       //                 startActivity(new Intent(getApplicationContext(),rmHome.class));
       //                 overridePendingTransition(0, 0);
       //                 return true;
       //             case R.id.navigation_clientoverview:
       //                 return true;
                    // TODO Need to go on everyone's separate pages now

      //          }
      //          return false;
     //       }
    //    });
    }

    @Override
    protected void onStart(){
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop(){
        super.onStop();
        adapter.stopListening();
    }
}