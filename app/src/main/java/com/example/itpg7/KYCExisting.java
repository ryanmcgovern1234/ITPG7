package com.example.itpg7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.IntToDoubleFunction;

public class KYCExisting extends AppCompatActivity {


    private TextView clientname;
    private TextView clientID;
    private String jeffbby = "01012022";
    private Date JeffDate;
    private ProgressBar mProgressBar;
    private TextView tProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_k_y_c_existing);
        SimpleDateFormat JDateFormat = new SimpleDateFormat("yyyy-MM-dd-");
        try {
            Date JeffDate = JDateFormat.parse(jeffbby);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        ProgressBar mProgressBar = (ProgressBar)findViewById(R.id.progressBar);
        mProgressBar.setScaleY(6f);
        //Create Jeff Bezos
        /*ClientModel Jeff = new ClientModel("Jeff Bezos", 1234, "01/01/21", "America", "Discretionary", "CEO", JeffDate);
        TextView clientname = (TextView)findViewById(R.id.textView8);
        TextView clientID = (TextView)findViewById(R.id.textView2);
        clientname.setText(Jeff.getName());
        clientID.setText(Integer.toString(Jeff.getID()));
        TextView tProgressBar = (TextView)findViewById(R.id.textViewBar);
*/
        //Set Text View based on Bar
        double timeLeft = 365 - ((Double.valueOf(mProgressBar.getProgress()) * 0.01)*365);
        String progToDate = Double.toString(timeLeft);

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
}