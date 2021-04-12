package com.example.itpg7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

public class SecurityPage extends AppCompatActivity  {

    private LineChart secgraph;
    private EditText edtxt;
    private Button loadbtn;
    private TextView txtview;
    private String ticker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security_page);

        txtview = (TextView) findViewById(R.id.textView3);
        secgraph = (LineChart) findViewById(R.id.security);
        edtxt = (EditText) findViewById(R.id.editText1);
        loadbtn = (Button) findViewById(R.id.loadbutton);
        //Loading graphs

        loadbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                ticker = edtxt.getText().toString();
                onClickMe();
                txtview.setText(ticker);

            }
        });

    }

    public void onClickMe()
    {
        if(ticker.equals("MSFT"))
        {
            LineDataSet lineDataSetC = new LineDataSet(MSFT(), "Microsoft");
            ArrayList<ILineDataSet> dataSetC = new ArrayList<>();
            dataSetC.add(lineDataSetC);
            LineData dataC = new LineData(dataSetC);
            secgraph.setData(dataC);
            secgraph.invalidate();
        }
        if(ticker.equals("TSLA"))
        {
            LineDataSet lineDataSetC = new LineDataSet(TSLA(), "Tesla");
            ArrayList<ILineDataSet> dataSetC = new ArrayList<>();
            dataSetC.add(lineDataSetC);
            LineData dataC = new LineData(dataSetC);
            secgraph.setData(dataC);
            secgraph.invalidate();
        }
        if(ticker.equals("AAPL"))
        {
            LineDataSet lineDataSetC = new LineDataSet(AAPL(), "Apple");
            ArrayList<ILineDataSet> dataSetC = new ArrayList<>();
            dataSetC.add(lineDataSetC);
            LineData dataC = new LineData(dataSetC);
            secgraph.setData(dataC);
            secgraph.invalidate();
        }
    }

    private ArrayList<Entry> MSFT(){

        ArrayList<Entry> dataVals = new ArrayList<Entry>();
        dataVals.add(new Entry(0,0));
        dataVals.add(new Entry(1, 35));
        dataVals.add(new Entry(2, 30));
        dataVals.add(new Entry(3, 28));

        return dataVals;
    }

    private ArrayList<Entry> TSLA(){

        ArrayList<Entry> dataVals = new ArrayList<Entry>();
        dataVals.add(new Entry(0,0));
        dataVals.add(new Entry(1, 35));
        dataVals.add(new Entry(2, 30));
        dataVals.add(new Entry(3, 28));

        return dataVals;
    }

    private ArrayList<Entry> AAPL(){

        ArrayList<Entry> dataVals = new ArrayList<Entry>();
        dataVals.add(new Entry(0,0));
        dataVals.add(new Entry(1, 35));
        dataVals.add(new Entry(2, 30));
        dataVals.add(new Entry(3, 28));

        return dataVals;
    }

}