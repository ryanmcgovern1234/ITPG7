package com.example.itpg7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import org.json.JSONObject;

import java.util.ArrayList;

public class MarketView extends AppCompatActivity {

    private final FirebaseDatabase db = FirebaseDatabase.getInstance();
    private final DatabaseReference root = db.getReference();



    LineChart mpLineChart;
    LineChart customerChart;
    RadioButton rt;
    RadioButton rf;
    RadioButton re;
    RadioButton rc;
    RadioGroup rg;
    TextView blah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_view);
        rt = (RadioButton) findViewById(R.id.radioTech);
        rf = (RadioButton) findViewById(R.id.radioFinance);
        re = (RadioButton) findViewById(R.id.radioEnergy);
        rc = (RadioButton) findViewById(R.id.radioCrypto);
        rg = (RadioGroup) findViewById(R.id.radiogroup);
        customerChart = (LineChart) findViewById(R.id.customerview);
        mpLineChart = (LineChart) findViewById(R.id.trendview);
        blah = (TextView) findViewById(R.id.textView3);


            //Customer chart
        LineDataSet lineDataSetC = new LineDataSet(Customer(), "Customer");
        ArrayList<ILineDataSet> dataSetC = new ArrayList<>();
        dataSetC.add(lineDataSetC);
        LineData dataC = new LineData(dataSetC);
        customerChart.setDescription(null);
        customerChart.getLegend().setEnabled(false);
        customerChart.getXAxis().setDrawLabels(false);
        customerChart.setData(dataC);
        customerChart.invalidate();

        //Base case to initialize tech for line graph
        rt.setChecked(true);
        LineDataSet lineDataSet1 = new LineDataSet(Tech(), "Tech");
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(lineDataSet1);
        LineData data = new LineData(dataSets);
        mpLineChart.setDescription(null);
        mpLineChart.getLegend().setEnabled(false);
        mpLineChart.getXAxis().setDrawLabels(false);
        mpLineChart.setData(data);
        mpLineChart.invalidate();

        //Listener to see which box has been checked
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i) {
                    case R.id.radioTech:
                        LineDataSet lineDataSet1 = new LineDataSet(Tech(), "Tech");
                        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
                        dataSets.add(lineDataSet1);
                        LineData data = new LineData(dataSets);
                        mpLineChart.setDescription(null);
                        mpLineChart.getLegend().setEnabled(false);
                        mpLineChart.getXAxis().setDrawLabels(false);
                        mpLineChart.setData(data);
                        mpLineChart.invalidate();

                        break;
                    case R.id.radioFinance:
                        LineDataSet lineDataSet2 = new LineDataSet(Finance(), "Finance");
                        ArrayList<ILineDataSet> dataSetss = new ArrayList<>();
                        dataSetss.add(lineDataSet2);

                        LineData data2 = new LineData(dataSetss);
                        mpLineChart.setDescription(null);
                        mpLineChart.getLegend().setEnabled(false);
                        mpLineChart.getXAxis().setDrawLabels(false);
                        mpLineChart.setData(data2);
                        mpLineChart.invalidate();
                        break;
                    case R.id.radioEnergy:
                        LineDataSet lineDataSet3 = new LineDataSet(Energy(), "Energy");
                        ArrayList<ILineDataSet> dataSetsss = new ArrayList<>();
                        dataSetsss.add(lineDataSet3);

                        LineData data3 = new LineData(dataSetsss);
                        mpLineChart.setDescription(null);
                        mpLineChart.getLegend().setEnabled(false);
                        mpLineChart.getXAxis().setDrawLabels(false);
                        mpLineChart.setData(data3);
                        mpLineChart.invalidate();
                        break;
                    case R.id.radioCrypto:
                        LineDataSet lineDataSet4 = new LineDataSet(Crypto(), "Crypto");
                        ArrayList<ILineDataSet> dataSetssss = new ArrayList<>();
                        dataSetssss.add(lineDataSet4);

                        LineData data4 = new LineData(dataSetssss);
                        mpLineChart.setDescription(null);
                        mpLineChart.getLegend().setEnabled(false);
                        mpLineChart.getXAxis().setDrawLabels(false);
                        mpLineChart.setData(data4);
                        mpLineChart.invalidate();
                        break;
                }
            }
        });


        Button buttonsecurity = (Button) findViewById(R.id.buttonsec);

        buttonsecurity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                openSecurity();
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);

        //Set Selected
        bottomNavigationView.setSelectedItemId(R.id.navigation_dashboard);

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



    private ArrayList<Entry> Tech(){

        ArrayList<Entry> dataVals = new ArrayList<Entry>();
        dataVals.add(new Entry(0,100));
        dataVals.add(new Entry(1, 112));
        dataVals.add(new Entry(2, 120));
        dataVals.add(new Entry(3, 140));
        dataVals.add(new Entry(4, 145));
        dataVals.add(new Entry(5, 155));
        dataVals.add(new Entry(6, 118));


        return dataVals;
    }

    private ArrayList<Entry> Finance(){
        ArrayList<Entry> dataVals = new ArrayList<Entry>();
        dataVals.add(new Entry(0, 20));
        dataVals.add(new Entry(1, 25));
        dataVals.add(new Entry(2, 45));
        dataVals.add(new Entry(3, 28));
        dataVals.add(new Entry(4, 25));
        dataVals.add(new Entry(5, 30));
        dataVals.add(new Entry(6, 38));


        return dataVals;
    }

    private ArrayList<Entry> Energy(){
        ArrayList<Entry> dataVals = new ArrayList<Entry>();
        dataVals.add(new Entry(0, 10));
        dataVals.add(new Entry(1, 12));
        dataVals.add(new Entry(2, 14));
        dataVals.add(new Entry(3, 16));
        dataVals.add(new Entry(4, 15));
        dataVals.add(new Entry(5, 12));
        dataVals.add(new Entry(6, 11));


        return dataVals;
    }

    private ArrayList<Entry> Crypto(){
        ArrayList<Entry> dataVals = new ArrayList<Entry>();
        dataVals.add(new Entry(0, 25));
        dataVals.add(new Entry(1, 28));
        dataVals.add(new Entry(2, 30));
        dataVals.add(new Entry(3, 32));
        dataVals.add(new Entry(4, 54));
        dataVals.add(new Entry(5, 61));
        dataVals.add(new Entry(6, 50));


        return dataVals;
    }

    private ArrayList<Entry> Customer(){
        ArrayList<Entry> dataVals = new ArrayList<Entry>();
        dataVals.add(new Entry(0, 10000));
        dataVals.add(new Entry(1, 25000));
        dataVals.add(new Entry(2, 20000));
        dataVals.add(new Entry(3, 28000));

        return dataVals;
    }

   public void openSecurity() {
        Intent intent = new Intent(this, SecurityPage.class);
        startActivity(intent);
    }
}