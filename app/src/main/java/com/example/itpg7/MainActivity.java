package com.example.itpg7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private EditText eUsername;
    private EditText ePasssword;
    private Button bLogin;

    String userName = "";
    String userPassword = "";

    boolean isValid = false;



    class Credentials
    {
        String name = "login";
        String password = "1234";
    }


        @Override
        protected void onCreate (Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);


            eUsername = findViewById(R.id.eUsername);
            ePasssword = findViewById(R.id.ePassword);
            bLogin = findViewById(R.id.bLogin);


            bLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    userName = eUsername.getText().toString();
                    userPassword = ePasssword.getText().toString();

                    if (userName.isEmpty() || userPassword.isEmpty()) {
                        Toast.makeText(MainActivity.this, "Please enter name and password!", Toast.LENGTH_LONG).show();
                    } else {
                        isValid = validate(userName, userPassword);

                        if (!isValid) {
                            Toast.makeText(MainActivity.this, "Incorrect credentials, please try again!", Toast.LENGTH_LONG).show();
                        } else {
                            openManagerHome();
                        }
                    }
                }
            });



        }


    private boolean validate(String userName, String userPassword)
    {
        Credentials credentials = new Credentials();

        if(userName.equals(credentials.name) && userPassword.equals(credentials.password))
        {
            return true;
        }

        return false;
    }

    public void openManagerHome() {
        Intent intent = new Intent(this, ClientOverviewPage.class);
        startActivity(intent);
    }



}
//hello
// hey!