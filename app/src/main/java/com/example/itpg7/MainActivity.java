package com.example.itpg7;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.itpg7.activities.ClientProfile;
import com.example.itpg7.activities.CreateNoteActivity;
import com.example.itpg7.activities.Notes_Listt;

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
        protected void onCreate(Bundle savedInstanceState) {
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
        Intent intent = new Intent(this, Notes_Listt.class);
        startActivity(intent);
    }

}
