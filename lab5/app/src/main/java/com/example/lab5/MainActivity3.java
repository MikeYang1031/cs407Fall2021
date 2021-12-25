package com.example.lab5;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity3 extends AppCompatActivity {

    int noteid = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //get edit text view
        EditText editText = (EditText) findViewById(R.id.editNote);

        //get intent
        Intent intent = getIntent();

        // get noteid
        noteid = intent.getIntExtra("noteid", -1);

        //initialize class note id
        if(noteid != -1){
            Note note = MainActivity2.notes.get(noteid);
            String noteContent = note.getContent();
            editText.setText(noteContent);
        }

    }

    public void clickSave(View view){
        String str = "noinfo";
        goToActivity2(str);
    }

    public void goToActivity2(String s){
        //get edit text view
        EditText editText = (EditText) findViewById(R.id.editNote);
        String content = editText.getText().toString();
        //init sql lite
        // 2.get sql instance
        Context context = getApplicationContext();
        SQLiteDatabase sqLiteDatabase = context.openOrCreateDatabase("notes", Context.MODE_PRIVATE,null);
        // 3. init db helper
        DBHelper db = new DBHelper(sqLiteDatabase);
        db.createTable();
        //set username
        SharedPreferences sharedPreferences = getSharedPreferences("com.example.cs407_lab5", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "");
        //save info
        String title;
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String date = dateFormat.format(new Date());

        if(noteid == -1){
            title = "NOTE_" + (MainActivity2.notes.size()+1);
            db.saveNotes(username, title, content, date);
        }else{
            title = "NOTE_" + (noteid +1);
            db.updateNotes(title, date, content, username);
        }

        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("message", s);
        startActivity(intent);
    }

}