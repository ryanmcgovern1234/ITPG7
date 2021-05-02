package com.example.itpg7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class ClientProfile extends AppCompatActivity {


    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private DocumentReference noteRef= db.collection("users").document("2Xte5La4YtN6dZ0dnnth");
    private DocumentReference noteRef1= db.collection("users").document("8xCaUyfF8Xv2cFOnIFmO");
    private DocumentReference noteRef2= db.collection("users").document("Q4YObwAgczOd8Cy1fRui");
    private DocumentReference noteRef3= db.collection("users").document("QpZVAetM7eAMnUpOy6So");
    private DocumentReference noteRef4= db.collection("users").document("q2hSFjYT3mbaXbuRovw8");
    private DocumentReference noteRef5= db.collection("users").document("w9AI8I49OGDg90roZ0Wm");
    private TextView clientname;
    private TextView clientDoB;
    private TextView clientnat;
    private TextView clientact;
    private TextView clientlang;
    private TextView clientocup;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_profile);

        clientact = (TextView)findViewById(R.id.textViewact);
        clientname = (TextView)findViewById(R.id.textViewname);
        clientDoB = (TextView)findViewById(R.id.textViewdob);
        clientnat = (TextView)findViewById(R.id.textViewnat);
        clientlang = (TextView)findViewById(R.id.textViewlang);
        clientocup = (TextView)findViewById(R.id.textViewocup);

        if(ClientOverviewPage.adapterpos == 0) {
            noteRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    DocumentSnapshot document = task.getResult();
                    ClientModel edit = document.toObject(ClientModel.class);
                    clientname.setText(edit.getName());
                    clientDoB.setText(edit.getDoB());
                    clientact.setText("Accounty Type: " + edit.getAccountType());
                    clientlang.setText("Language: " + edit.getLanguage());
                    clientocup.setText("Occupation: " + edit.getOccupation());
                    clientnat.setText("Nationality: " + edit.getNationality());


                }
            });
        }
        if(ClientOverviewPage.adapterpos == 1) {
            noteRef1.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    DocumentSnapshot document = task.getResult();
                    ClientModel edit = document.toObject(ClientModel.class);
                    clientname.setText(edit.getName());
                    clientDoB.setText(edit.getDoB());
                    clientact.setText("Accounty Type: " + edit.getAccountType());
                    clientlang.setText("Language: " + edit.getLanguage());
                    clientocup.setText("Occupation: " + edit.getOccupation());
                    clientnat.setText("Nationality: " + edit.getNationality());


                }
            });
        }
        if(ClientOverviewPage.adapterpos == 2) {
            noteRef2.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    DocumentSnapshot document = task.getResult();
                    ClientModel edit = document.toObject(ClientModel.class);
                    clientname.setText(edit.getName());
                    clientDoB.setText(edit.getDoB());
                    clientact.setText("Accounty Type: " + edit.getAccountType());
                    clientlang.setText("Language: " + edit.getLanguage());
                    clientocup.setText("Occupation: " + edit.getOccupation());
                    clientnat.setText("Nationality: " + edit.getNationality());


                }
            });
        }
        if(ClientOverviewPage.adapterpos == 3) {
            noteRef3.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    DocumentSnapshot document = task.getResult();
                    ClientModel edit = document.toObject(ClientModel.class);
                    clientname.setText(edit.getName());
                    clientDoB.setText(edit.getDoB());
                    clientact.setText("Accounty Type: " + edit.getAccountType());
                    clientlang.setText("Language: " + edit.getLanguage());
                    clientocup.setText("Occupation: " + edit.getOccupation());
                    clientnat.setText("Nationality: " + edit.getNationality());


                }
            });
        }
        if(ClientOverviewPage.adapterpos == 4) {
            noteRef4.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    DocumentSnapshot document = task.getResult();
                    ClientModel edit = document.toObject(ClientModel.class);
                    clientname.setText(edit.getName());
                    clientDoB.setText(edit.getDoB());
                    clientact.setText("Accounty Type: " + edit.getAccountType());
                    clientlang.setText("Language: " + edit.getLanguage());
                    clientocup.setText("Occupation: " + edit.getOccupation());
                    clientnat.setText("Nationality: " + edit.getNationality());


                }
            });
        }
        if(ClientOverviewPage.adapterpos == 5) {
            noteRef5.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    DocumentSnapshot document = task.getResult();
                    ClientModel edit = document.toObject(ClientModel.class);
                    clientname.setText(edit.getName());
                    clientDoB.setText(edit.getDoB());
                    clientact.setText("Accounty Type: " + edit.getAccountType());
                    clientlang.setText("Language: " + edit.getLanguage());
                    clientocup.setText("Occupation: " + edit.getOccupation());
                    clientnat.setText("Nationality: " + edit.getNationality());


                }
            });
        }




        //Bottom Nav stuff - data ends at semicolon and bracket
        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);
        bottomNavigationView.setSelectedItemId(R.id.navigation_clientoverview);
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
                        startActivity(new Intent(getApplicationContext(), KYCExisting.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
    }
}