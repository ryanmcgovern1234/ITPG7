package com.example.itpg7;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class ClientFinance extends AppCompatActivity {

    private LineChart clientgraph;
    private PieChart pieChart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_finance);

        pieChart = (PieChart)findViewById(R.id.piechart);

        setUpPieChart();
        loadPieChartData();

        clientgraph = (LineChart)findViewById(R.id.clienttrendview);
        LineDataSet lineDataSetC = new LineDataSet(CustomerVals(), "Customer");
        ArrayList<ILineDataSet> dataSetC = new ArrayList<>();
        dataSetC.add(lineDataSetC);
        clientgraph.setDescription(null);
        clientgraph.getXAxis().setDrawLabels(false);
        lineDataSetC.setValueTextSize(0f);
        clientgraph.getAxisLeft().setDrawLabels(false);
        clientgraph.getLegend().setEnabled(false);
        LineData dataC = new LineData(dataSetC);
        clientgraph.setData(dataC);
        clientgraph.invalidate();
    }

    private ArrayList<Entry> CustomerVals(){
        ArrayList<Entry> dataVals = new ArrayList<Entry>();
        dataVals.add(new Entry(0, 21000));
        dataVals.add(new Entry(1, 25000));
        dataVals.add(new Entry(2, 26000));
        dataVals.add(new Entry(3, 28000));
        dataVals.add(new Entry(4, 26000));
        dataVals.add(new Entry(5, 22000));
        dataVals.add(new Entry(6, 28000));
        dataVals.add(new Entry(7, 29000));
        dataVals.add(new Entry(8, 29000));
        dataVals.add(new Entry(9, 28000));
        dataVals.add(new Entry(10, 28000));
        dataVals.add(new Entry(11, 28000));
        dataVals.add(new Entry(12, 30000));
        dataVals.add(new Entry(13, 31000));
        dataVals.add(new Entry(14, 32000));
        dataVals.add(new Entry(15, 31000));
        dataVals.add(new Entry(16, 33000));
        dataVals.add(new Entry(17, 33000));
        dataVals.add(new Entry(18, 34000));
        dataVals.add(new Entry(19, 34000));
        dataVals.add(new Entry(20, 34000));
        dataVals.add(new Entry(21, 35000));
        dataVals.add(new Entry(22, 34500));
        dataVals.add(new Entry(23, 32500));
        dataVals.add(new Entry(24, 33500));
        dataVals.add(new Entry(25, 36000));
        dataVals.add(new Entry(26, 37000));



        return dataVals;
    }

    private void setUpPieChart(){
        pieChart.setDrawHoleEnabled(true);
        pieChart.setUsePercentValues(true);
        pieChart.setEntryLabelColor(Color.BLACK);
        pieChart.setEntryLabelTextSize(12);
        pieChart.setCenterText("Ownings by Category");
        pieChart.setCenterTextSize(24);
        pieChart.getDescription().setEnabled(false);

        Legend l = pieChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);
        l.setEnabled(true);

    }

    private void loadPieChartData(){
        ArrayList<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(0.5f, "Equities"));
        entries.add(new PieEntry(0.3f, "Bonds"));
        entries.add(new PieEntry(0.2f, "Real Estate?"));

        ArrayList<Integer> colors = new ArrayList<Integer>();
        for(int color: ColorTemplate.MATERIAL_COLORS){
            colors.add(color);
        }

        for(int color: ColorTemplate.VORDIPLOM_COLORS){
            colors.add(color);
        }

        PieDataSet pieDataSet = new PieDataSet(entries, "Distribution of Ownings");
        pieDataSet.setColors(colors);

        PieData dataPie = new PieData(pieDataSet);
        dataPie.setDrawValues(true);
        dataPie.setValueFormatter(new PercentFormatter(pieChart));
        dataPie.setValueTextSize(12f);
        dataPie.setValueTextColor(Color.BLACK);

        pieChart.setData(dataPie);
        pieChart.invalidate();

    }

}