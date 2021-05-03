package com.example.itpg7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class KYCIncoming extends AppCompatActivity {


    private ImageButton kycfinbut;
    private TextView clientname;
    private TextView clientID;
    private String jeffbby = "01012022";
    private ProgressBar mProgressBar;
    private TextView tProgressBar;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private DocumentReference noteRef= db.collection("users").document("2Xte5La4YtN6dZ0dnnth");
    private DocumentReference noteRef1= db.collection("users").document("8xCaUyfF8Xv2cFOnIFmO");
    private DocumentReference noteRef2= db.collection("users").document("Q4YObwAgczOd8Cy1fRui");
    private DocumentReference noteRef3= db.collection("users").document("QpZVAetM7eAMnUpOy6So");
    private DocumentReference noteRef4= db.collection("users").document("q2hSFjYT3mbaXbuRovw8");
    private DocumentReference noteRef5= db.collection("users").document("w9AI8I49OGDg90roZ0Wm");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_k_y_c_incoming);

        kycfinbut = (ImageButton)findViewById(R.id.imageButtonfin);
        kycfinbut.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                KYCFin();
            }
        });

        SimpleDateFormat JDateFormat = new SimpleDateFormat("yyyy-MM-dd-");
        try {
            Date JeffDate = JDateFormat.parse(jeffbby);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        ProgressBar mProgressBar = (ProgressBar)findViewById(R.id.progressBar);
        mProgressBar.setScaleY(6f);

        clientname = (TextView)findViewById(R.id.textViewName);
        clientID = (TextView)findViewById(R.id.textViewID);

        if(KYCMain.adpos == 0) {
            noteRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    DocumentSnapshot document = task.getResult();
                    ClientModel edit = document.toObject(ClientModel.class);
                    clientname.setText(edit.getName());
                    clientID.setText(edit.getDoB());
                }
            });
        }
        if(KYCMain.adpos == 1) {
            noteRef1.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    DocumentSnapshot document = task.getResult();
                    ClientModel edit = document.toObject(ClientModel.class);
                    clientname.setText(edit.getName());
                    clientID.setText(edit.getDoB());
                }
            });
        }
        if(KYCMain.adpos == 2) {
            noteRef2.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    DocumentSnapshot document = task.getResult();
                    ClientModel edit = document.toObject(ClientModel.class);
                    clientname.setText(edit.getName());
                    clientID.setText(edit.getDoB());
                }
            });
        }
        if(KYCMain.adpos == 3) {
            noteRef3.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    DocumentSnapshot document = task.getResult();
                    ClientModel edit = document.toObject(ClientModel.class);
                    clientname.setText(edit.getName());
                    clientID.setText(edit.getDoB());
                }
            });
        }
        if(KYCMain.adpos == 4) {
            noteRef4.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    DocumentSnapshot document = task.getResult();
                    ClientModel edit = document.toObject(ClientModel.class);
                    clientname.setText(edit.getName());
                    clientID.setText(edit.getDoB());
                }
            });
        }
        if(KYCMain.adpos == 5) {
            noteRef5.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    DocumentSnapshot document = task.getResult();
                    ClientModel edit = document.toObject(ClientModel.class);
                    clientname.setText(edit.getName());
                    clientID.setText(edit.getDoB());
                }
            });
        }



        //Set Text View based on Bar
        double timeLeft = 365 - ((Double.valueOf(mProgressBar.getProgress()) * 0.01)*365);
        String progToDate = Double.toString(timeLeft);
        tProgressBar = (TextView)findViewById(R.id.textViewBarI);
        tProgressBar.setText("You have " + progToDate + " days left until KYC due");




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
    public void KYCFin() {
        Intent intent = new Intent(this, kycfin.class);
        startActivity(intent);
    }
}