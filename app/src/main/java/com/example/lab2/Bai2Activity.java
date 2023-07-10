package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Bai2Activity extends AppCompatActivity implements View.OnClickListener {
    public static final String SERVER_NAME = "http://"+API.ip+"/giang_ph28126/rectangle_POST.php";
    private EditText edWidth,edLength;
    private Button btnSend;
    private TextView tvResult;

    String strWidth,strLength;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);
        edWidth = findViewById(R.id.edWith);
        edLength = findViewById(R.id.edLength);
        btnSend = findViewById(R.id.btnSend);
        tvResult = findViewById(R.id.tvResult);

        btnSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        strWidth = edWidth.getText().toString();
        strLength = edLength.getText().toString();
        BackgroundTask_POST backgroundTask_Post = new BackgroundTask_POST(strWidth,strLength,tvResult,this);
        backgroundTask_Post.execute();

    }
}