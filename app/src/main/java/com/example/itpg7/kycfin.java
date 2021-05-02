package com.example.itpg7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class kycfin extends AppCompatActivity {

    private Button backbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kycfin);


        Button backbtn = (Button) findViewById(R.id.buttonback);

        backbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                backKYC();
            }
        });
    }

    public void backKYC() {
        Intent intent = new Intent(this, KYCIncoming.class);
        startActivity(intent);
    }
}