package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    public void clickFunction(View view){

        //get username and password
        EditText username = (EditText) findViewById(R.id.textField1);
        EditText password = (EditText) findViewById(R.id.textField2);


        if(username.getText().toString().length() <= 0 || password.getText().toString().length() <= 0){
            Toast.makeText(MainActivity.this, "Please Enter username or password", Toast.LENGTH_LONG).show();
        }else{
            // add username to shared preference project
            String str = username.getText().toString();
            SharedPreferences sharedPreferences = getSharedPreferences("com.example.cs407_lab5", Context.MODE_PRIVATE);
            sharedPreferences.edit().putString("username", str).apply();

            goToActivity2();
        }
    }

    public void goToActivity2(){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = getSharedPreferences("com.example.cs407_lab5", Context.MODE_PRIVATE);
        String currUsername = sharedPreferences.getString("username", "");

        if(!currUsername.equals("")){
            goToActivity2();
        }else{
            setContentView(R.layout.activity_main);
        }

    }
}