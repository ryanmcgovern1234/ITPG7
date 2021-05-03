package com.example.itpg7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.Random;


public class KYCMain extends AppCompatActivity implements FirestoreAdapterKYC.OnListItemClick {

    private FirebaseFirestore firebaseFirestore;
    private RecyclerView recyclerView;
    private FirestoreAdapterKYC adapter;
    public static int adpos;
    private ImageButton darkmodebutton;
    private View view;
    int[] color;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_k_y_c_main);

        firebaseFirestore = FirebaseFirestore.getInstance();
        recyclerView = findViewById(R.id.kycrecyclerview);

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

        //View holder

        color = new int[] {Color.BLACK, Color.WHITE};

        view = findViewById(R.id.view);
        ImageButton darkmodebutton = (ImageButton) findViewById(R.id.darkmodebutton);

        darkmodebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                int aryLength = color.length;

                Random random = new Random();
                int rNum = random.nextInt(aryLength);

                view.setBackgroundColor(color[rNum]);


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
                        overridePendingTransition(0,0);
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

    @Override
    public void onItemClick(ClientModel snapshot, int position) {
        adpos = position;
        startActivity(new Intent(getApplicationContext(), KYCIncoming.class));
        overridePendingTransition(0, 0);
    }


    public interface OnItemClickListener{
        void onItemClick (DocumentSnapshot documentSnapshot, int position);
    }




}




