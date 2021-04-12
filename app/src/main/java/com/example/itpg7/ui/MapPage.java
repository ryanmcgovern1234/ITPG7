package com.example.itpg7.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.itpg7.R;

public class MapPage extends AppCompatActivity {
TextView mytext;
ImageButton mybutton1;

    TextView mytext2;
    ImageButton mybutton2;

    TextView mytext3;
    ImageButton mybutton3;

    TextView mytext4;
    ImageButton mybutton4;

    TextView mytext5;
    ImageButton mybutton5;

    TextView mytext6;
    ImageButton mybutton6;

    TextView mytext7;
    ImageButton mybutton7;

    TextView mytext8;
    ImageButton mybutton8;

    TextView mytext9;
    ImageButton mybutton9;

    TextView mytext10;
    ImageButton mybutton10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
    mybutton1 = (ImageButton)findViewById(R.id.imageButton12);

    mybutton1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mytext.setText("Adams Williams" +
                    "25 Howard Road, Edinburgh, EH3 4RR");
        }



    });
        mybutton2 = (ImageButton)findViewById(R.id.imageButton27);

        mybutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mytext2.setText("Dupuis Louis" +
                        "10 Gardiner Rd, Edinburgh, EH4 3RR");
            }

    }
                mybutton3 = (ImageButton)findViewById(R.id.imageButton20);

        mybutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mytext3.setText("Clark Luca" +
                        "169-171 Boroughbridge Rd, York, YO26 6AN ");
            }
    }



