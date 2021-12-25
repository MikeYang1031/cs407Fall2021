package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public void click(View v) {

        EditText myTextField = (EditText)findViewById(R.id.input1);
        EditText myTextField2 = (EditText)findViewById(R.id.input2);

        String value1 = myTextField.getText().toString();
        int one =Integer.parseInt(value1);
        String value2 = myTextField2.getText().toString();
        int two =Integer.parseInt(value2);

        switch(v.getId()){

            case R.id.button1:
                int answer = one + two;
                goToActivity2(answer);
                break;

            case R.id.button2:
                int answer2 = one - two;
                goToActivity2(answer2);
                break;

            case R.id.button3:
                int answer3 = one * two;
                goToActivity2(answer3);
                break;

            case R.id.button4:
                int answer4 = one / two;
                goToActivity2(answer4);
                break;
        }
    }

    public void goToActivity2(int s1){
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("answer", s1);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}