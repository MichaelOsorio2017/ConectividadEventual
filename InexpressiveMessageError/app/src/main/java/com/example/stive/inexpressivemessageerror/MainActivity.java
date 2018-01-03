package com.example.stive.inexpressivemessageerror;

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

    private TextView description;
    private Button btnGenericMessage;
    private Button btnExceptionTrace;
    private Button btnExamplesGeneric;
    private Button btnExamplesException;
    private Button btnTestGeneric;
    private Button btnTestException;
    private Context context = this;
    private ImageView image;
    private RelativeLayout genericMessageDetail;
    private RelativeLayout exceptionTraceDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        description = (TextView)findViewById(R.id.antipattern);
        btnGenericMessage = (Button)findViewById(R.id.btnGenericMessage);
        image = (ImageView)findViewById(R.id.imageView);
        btnExceptionTrace = (Button)findViewById(R.id.btnExceptionTrace);
        genericMessageDetail = (RelativeLayout)findViewById(R.id.genericMessageDetail);
        exceptionTraceDetail = (RelativeLayout)findViewById(R.id.exceptionTraceDetail);
        btnExamplesGeneric = (Button)findViewById(R.id.btnExamplesGeneric);
        btnExamplesException = (Button)findViewById(R.id.btnExamplesException);
        btnTestGeneric = (Button)findViewById(R.id.btnLivetest);
        btnTestException = (Button)findViewById(R.id.btnLivetest2);

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
                }else if(wifiManager.isWifiEnabled() && wifiManager.getWifiState() != WifiManager.WIFI_STATE_ENABLING){
                    Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(),"No internet connection. Make sure Wi-Fi or cellular data is turned on, then try again.",Toast.LENGTH_LONG).show();
                }
            }
        });
        
        btnGenericMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(genericMessageDetail.getVisibility() == View.GONE) {
                    genericMessageDetail.setVisibility(View.VISIBLE);
                }else{
                    genericMessageDetail.setVisibility(View.GONE);
                }
            }
        });

        btnExceptionTrace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(exceptionTraceDetail.getVisibility() == View.GONE) {
                    exceptionTraceDetail.setVisibility(View.VISIBLE);
                }else{
                    exceptionTraceDetail.setVisibility(View.GONE);
                }
            }
        });

        btnExamplesGeneric.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://ml-papers.gitlab.io/android.connectivity-2017/online-appendix/antipatternExample.html?pID=IEM-GM");
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

        btnExamplesException.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://ml-papers.gitlab.io/android.connectivity-2017/online-appendix/antipatternExample.html?pID=IEM-MET");
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

        btnTestGeneric.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new callImageGenericMessage().execute();
            }
        });

        btnTestException.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new callImageExceptionTrace().execute();
            }
        });
    }

    private class callImageGenericMessage extends AsyncTask<Void,Void,Bitmap>{
        protected Bitmap doInBackground(Void... voids){

            URL urlImage = null;
            HttpURLConnection conn = null;
            try{
                urlImage = new URL("https://github.com/MichaelOsorio2017/ConectividadEventual/blob/master/Resourses/NoNetwork.png?raw=true");
                conn = (HttpURLConnection)urlImage.openConnection();
                conn.connect();
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 1;
                return BitmapFactory.decodeStream(conn.getInputStream(), new Rect(0,0,0,0),options);
            }catch (Exception e){
                e.printStackTrace();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run(){
                        Toast.makeText(MainActivity.this,"Could not load the image, please try again later.",Toast.LENGTH_SHORT).show();
                    }
                });

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

    private class callImageExceptionTrace extends AsyncTask<Void,Void,Bitmap>{

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
               final String ex = e.getMessage();
               e.printStackTrace();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run(){
                        Toast.makeText(MainActivity.this,ex,Toast.LENGTH_LONG).show();
                    }
                });

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
