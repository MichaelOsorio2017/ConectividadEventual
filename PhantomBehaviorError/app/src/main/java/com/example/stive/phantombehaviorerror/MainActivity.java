package com.example.stive.phantombehaviorerror;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private Button btnStuckedProgressNotification;
    private RelativeLayout stuckedProgressDetail;
    private TextView description;
    private Context context = this;
    private Button btnStuckedProgressNotiExamples;
    private Button btnLiveTest;
    private ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnStuckedProgressNotification = (Button)findViewById(R.id.btnStuckedProgressNoti);
        stuckedProgressDetail = (RelativeLayout)findViewById(R.id.stuckedProgressNotiDetail);
        description = (TextView)findViewById(R.id.antipattern);
        btnStuckedProgressNotiExamples = (Button)findViewById(R.id.btnStuckedProgressNotiExample);
        btnLiveTest = (Button)findViewById(R.id.btnLivetest);
        image = (ImageView)findViewById(R.id.imageView);

        btnStuckedProgressNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(stuckedProgressDetail.getVisibility() == View.GONE){
                    stuckedProgressDetail.setVisibility(View.VISIBLE);
                }else{
                    stuckedProgressDetail.setVisibility(View.GONE);
                }
            }
        });

        description.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://ml-papers.gitlab.io/android.connectivity-2017/online-appendix/antipatterns.html?id=IEM");
                ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
                WifiManager wifiManager = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

                if(networkInfo != null){
                    if(networkInfo.isAvailable() && networkInfo.isConnected()){
                        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                        startActivity(intent);
                    }
                }else if(wifiManager.isWifiEnabled() && (wifiManager.getWifiState() != WifiManager.WIFI_STATE_ENABLING)){
                    Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(),"No internet connection. Make sure Wi-Fi or cellular data is turned on, then try again.",Toast.LENGTH_LONG).show();
                }
            }
        });

        btnStuckedProgressNotiExamples.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://ml-papers.gitlab.io/android.connectivity-2017/online-appendix/antipatternExample.html?pID=PHB-SPN");
                ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
                WifiManager wifiManager = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

                if(networkInfo != null){
                    if(networkInfo.isAvailable() && networkInfo.isConnected()){
                        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                        startActivity(intent);
                    }
                }else if(wifiManager.isWifiEnabled() && wifiManager.getWifiState() != WifiManager.WIFI_STATE_ENABLING){
                    Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(),"No internet connection. Make sure Wi-Fi or cellular data is turned on, then try again.",Toast.LENGTH_LONG).show();
                }
            }
        });

        btnLiveTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,StuckedProgressActivity.class);
                startActivity(intent);
            }
        });
    }

    private class callImageExceptionTrace extends AsyncTask<Void,Void,Bitmap> {

        protected Bitmap doInBackground(Void... voids){
            URL urlImage = null;
            HttpURLConnection conn = null;
            try{
                urlImage = new URL("https://github.com/MichaelOsorio2017/ConectividadEventual/blob/master/Resourses/noConnection.png?raw=true");
                conn = (HttpURLConnection)urlImage.openConnection();
                conn.connect();
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 1;
                return BitmapFactory.decodeStream(conn.getInputStream(), new Rect(0,0,0,0),options);
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }

        protected void onPostExecute(Bitmap bitmap){
            try{
                image.setImageBitmap(bitmap);
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }


}
