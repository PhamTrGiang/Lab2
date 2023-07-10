package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Bai4Activity extends AppCompatActivity implements View.OnClickListener {
    public static final String SERVER_NAME = "http://"+API.ip+"/giang_ph28126/giaiphuongtrinh_POST.php";
    private EditText edA,edB,edC;
    private Button btnSend;
    private TextView tvResult;

    private String strA,strB,strC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4);

        edA = findViewById(R.id.edA);
        edB = findViewById(R.id.edB);
        edC = findViewById(R.id.edC);

        btnSend = findViewById(R.id.btnSend);
        tvResult = findViewById(R.id.tvResult);
        btnSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        strA = edA.getText().toString();
        strB = edB.getText().toString();
        strC = edC.getText().toString();
        BackgroundBai4_POST backgroundBai4_post = new BackgroundBai4_POST(tvResult,this);
        backgroundBai4_post.execute(strA,strB,strC);

    }
}
