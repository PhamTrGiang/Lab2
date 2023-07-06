package com.example.lab2;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class BackgroundTask_POST extends AsyncTask<Void,Void,Void> {
    String duongdan = Bai2Activity.SERVER_NAME;
    TextView tvResult;
    String strWidth,strLength,strResult;
    ProgressDialog pDialog;
    Context context;

    public BackgroundTask_POST(String strWidth, String strLength,TextView tvResult, Context context) {
        this.strWidth = strWidth;
        this.strLength = strLength;
        this.tvResult = tvResult;
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
    protected Void doInBackground(Void... voids) {
        try{
            URL url = new URL(duongdan);
            String param = "chieurong="+ URLEncoder.encode(strWidth,"utf-8")+"&chieudai="+URLEncoder.encode(strLength,"utf-8");
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
            strResult = sb.toString();
            urlConnection.disconnect();

        }catch (Exception e){

        }
        return null;
    }

    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);
        if(pDialog.isShowing()){
            pDialog.dismiss();
        }
        tvResult.setText(strResult);
    }
}
