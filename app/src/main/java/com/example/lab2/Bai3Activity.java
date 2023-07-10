package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Bai3Activity extends AppCompatActivity implements View.OnClickListener {
    public static final String SERVER_NAME = "http://"+API.ip+"/giang_ph28126/canh_POST.php";
    private EditText edCanh;
    private Button btnSend;
    private TextView tvResult;

    private String strCanh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);
        btnSend = findViewById(R.id.btnSend);
        tvResult = findViewById(R.id.tvResult);
        edCanh = findViewById(R.id.edCanh);
        btnSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        strCanh = edCanh.getText().toString();
        BackgroundBai3_POST backgroundBai3_POST = new BackgroundBai3_POST(tvResult, this);
        backgroundBai3_POST.execute(strCanh);
    }
}