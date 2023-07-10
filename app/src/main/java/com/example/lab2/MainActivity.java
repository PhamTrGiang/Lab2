package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void bai1(View v){
        Intent i = new Intent(getBaseContext(),Bai1_Activity.class);
        startActivity(i);
    }
    public void bai2(View v){
        Intent i = new Intent(getBaseContext(), Bai2Activity.class);
        startActivity(i);
    }
    public void bai3(View v){
        Intent i = new Intent(getBaseContext(), Bai3Activity.class);
        startActivity(i);
    }
    public void bai4(View v){
        Intent i = new Intent(getBaseContext(), Bai4Activity.class);
        startActivity(i);
    }


}