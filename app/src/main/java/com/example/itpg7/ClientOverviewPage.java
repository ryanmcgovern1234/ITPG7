package com.example.itpg7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class ClientOverviewPage extends AppCompatActivity implements FirestoreAdapterKYC.OnListItemClick{


    private FirebaseFirestore firebaseFirestore;
    private RecyclerView recyclerView;
    private FirestoreAdapterKYC adapter;
    public static int adapterpos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_overview_page);

        firebaseFirestore = FirebaseFirestore.getInstance();
        recyclerView = findViewById(R.id.clientrecyclerview);

        //Query woo hoo
        Query query = firebaseFirestore.collection("users");

        //Recycler options
        FirestoreRecyclerOptions<ClientModel> options = new FirestoreRecyclerOptions.Builder<ClientModel>()
                .setQuery(query, ClientModel.class)
                .build();

        adapter = new FirestoreAdapterKYC(options, this);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);










        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);
        //Set Selected
        bottomNavigationView.setSelectedItemId(R.id.navigation_clientoverview);
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
                    // TODO Need to go on everyone's separate pages now
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

    @Override
    public void onItemClick(ClientModel snapshot, int position) {
        adapterpos = position;
        startActivity(new Intent(getApplicationContext(), ClientProfile.class));
        overridePendingTransition(0, 0);

    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }
}