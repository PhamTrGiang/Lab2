package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Bai1_Activity extends AppCompatActivity implements View.OnClickListener{

    public static final String SERVER_NAME = "http://"+API.ip+"/giang_ph28126/student_GET.php";
    private EditText edName, edScore;
    private Button btnSend;
    private TextView tvResult;

    String strName,strScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);
        edName= findViewById(R.id.edName);
        edScore = findViewById(R.id.edScore);
        btnSend = findViewById(R.id.btnSend);
        tvResult = findViewById(R.id.tvResult);

        btnSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        strName = edName.getText().toString();
        strScore = edScore.getText().toString();
        BackgroundTask_GET backgroundTask = new BackgroundTask_GET(tvResult,strName,strScore,this);
        backgroundTask.execute();
    }
}