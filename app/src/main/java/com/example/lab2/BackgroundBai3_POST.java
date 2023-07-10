package com.example.lab2;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class BackgroundBai3_POST extends AsyncTask<String,Void,Void> {
    String duongdan = Bai3Activity.SERVER_NAME;
    TextView tvKetqua;
    String strKetqua;
    ProgressDialog pDialog;
    Context context;

    public BackgroundBai3_POST(TextView tvKetqua, Context context) {
        this.tvKetqua = tvKetqua;
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pDialog = new ProgressDialog(context);
        pDialog.setMessage("Calculating...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();
    }

    @Override
    protected Void doInBackground(String... voids) {
        try{
            URL url = new URL(duongdan);
            String param = "canh="+ URLEncoder.encode(voids[0].toString(),"utf-8");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("POST");
            urlConnection.setFixedLengthStreamingMode(param.getBytes().length);
            urlConnection.setRequestProperty("Context-Type","application/x-www-form-urlencoded");

            PrintWriter print = new PrintWriter(urlConnection.getOutputStream());
            print.print(param);
            print.close();

            String line = "";
            BufferedReader bfr = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuffer sb = new StringBuffer();
            while ((line = bfr.readLine())!=null){
                sb.append(line);
            }
            strKetqua = sb.toString();
            urlConnection.disconnect();

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);
        if(pDialog.isShowing()){
            pDialog.dismiss();
        }
        tvKetqua.setText(strKetqua);
    }
}
