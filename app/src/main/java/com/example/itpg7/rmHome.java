package com.example.itpg7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.itpg7.HelperClasses.HomeAdapter.FeaturedAdapter;
import com.example.itpg7.HelperClasses.HomeAdapter.FeaturedHelperClass;
import com.example.itpg7.activities.Notes_Listt;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Random;

public class rmHome extends AppCompatActivity{

    private ImageButton darkmode1;
    private View view2;
    int[] color2;
    private RecyclerView newsRecycler;
    private RecyclerView.Adapter adapter;
    private CardView trendingtest;
    private ImageView trendingsth;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_rmhome);

        //hooks
        newsRecycler = findViewById(R.id.news_recycler);
        newsRecycler();
        newsRecycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.ft.com/"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });


        trendingsth = (ImageView)findViewById(R.id.trendingsth);
        trendingsth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri uri = Uri.parse("https://www.ft.com/"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        trendingtest = (CardView) findViewById(R.id.trendingtest);
        trendingtest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openNotes();
            }
        });


        color2 = new int[] {Color.BLACK, Color.WHITE,};
        view2 = findViewById(R.id.view2);
        ImageButton darkmode1 = (ImageButton) findViewById(R.id.darkmode1);

        darkmode1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int aryLength = color2.length;

                Random random = new Random();
                int rNum = random.nextInt(aryLength);

                view2.setBackgroundColor(color2[rNum]);
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);

        //Set Selected
        bottomNavigationView.setSelectedItemId(R.id.navigation_home);

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

    private void newsRecycler() {
        newsRecycler.setHasFixedSize(true);
        newsRecycler.setLayoutManager(new LinearLayoutManager( this,LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelperClass(R.drawable.financialtimelogo223));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.londonstockexchange223));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.bbclogo));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.wallstreetjournal));

        adapter = new FeaturedAdapter(featuredLocations);
        newsRecycler.setAdapter(adapter);
    }

    public void openNotes() {
        Intent intent = new Intent(this, Notes_Listt.class);
        startActivity(intent);
    }



}