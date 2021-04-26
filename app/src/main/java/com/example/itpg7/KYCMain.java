package com.example.itpg7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class KYCMain extends AppCompatActivity {


    private RecyclerView recyclerView;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("users");
    private MyAdapterClient myClientAdapter;
    private ArrayList<ClientModel> clientList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_k_y_c_main);

        recyclerView = findViewById(R.id.kycrecyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        clientList = new ArrayList<>();
        myClientAdapter = new MyAdapterClient(this, clientList);

        recyclerView.setAdapter(myClientAdapter);


        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    ClientModel cModel = dataSnapshot.getValue(ClientModel.class);
                    clientList.add(cModel);
                }
                myClientAdapter.notifyDataSetChanged();
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        //Bottom Nav stuff - data ends at semicolon and bracket
        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);
        bottomNavigationView.setSelectedItemId(R.id.navigation_KYC);
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
                    case R.id.navigation_KYC:
                        startActivity(new Intent(getApplicationContext(), KYCMain.class));
                        overridePendingTransition(0, 0);
                        return true;

                }
                return false;
            }
        });
    }







}




