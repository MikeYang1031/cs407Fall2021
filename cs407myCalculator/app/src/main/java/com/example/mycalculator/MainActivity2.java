package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        output = (TextView) findViewById(R.id.output);

        Intent intent = getIntent();
        int answers = intent.getIntExtra("answer", 0);

        output.setText(String.valueOf(answers));
    }
}