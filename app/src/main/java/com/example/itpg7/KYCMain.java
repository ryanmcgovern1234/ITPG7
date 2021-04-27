package com.example.itpg7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.common.api.Api;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class KYCMain extends AppCompatActivity {

    private FirebaseFirestore firebaseFirestore;

    private RecyclerView recyclerView;
    private TextView textView;
    private ArrayList<ClientModel> clientList;
    private FirestoreRecyclerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_k_y_c_main);

        firebaseFirestore = FirebaseFirestore.getInstance();
        recyclerView = findViewById(R.id.kycrecyclerview);

        //Query
        Query query = firebaseFirestore.collection("users");

        //Recycler options
        FirestoreRecyclerOptions<ClientModel> options = new FirestoreRecyclerOptions.Builder<ClientModel>()
                .setQuery(query, ClientModel.class)
                .build();

         adapter = new FirestoreRecyclerAdapter<ClientModel, ClientsViewHolder>(options) {
            @NonNull
            @Override
            public ClientsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kyccard, parent, false);

                return new ClientsViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull ClientsViewHolder holder, int position, @NonNull ClientModel model) {
                holder.list_name.setText(model.getName());

            }
        };

         recyclerView.setHasFixedSize(true);
         recyclerView.setLayoutManager(new LinearLayoutManager(this));
         recyclerView.setAdapter(adapter);

        //View holder







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

    private class ClientsViewHolder extends RecyclerView.ViewHolder {

        private TextView list_name;
        public ClientsViewHolder(@NonNull View itemView) {
            super(itemView);

            list_name = itemView.findViewById(R.id.namekyclist);
        }
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




