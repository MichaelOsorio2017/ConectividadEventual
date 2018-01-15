package com.example.stive.browserembeddedincorrectly;

import android.animation.StateListAnimator;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView description;

    RelativeLayout webPageEmbeddedDetail;
    RelativeLayout externalWebPageEmbeddedDetail;
    RelativeLayout mapFileEmbeddedDetail;

    Button btnWebPage;
    Button btnExternalPage;
    Button btnMapFile;
    Button btnTestWebPage;
    Button btnTestExternalPage;
    Button btnTestMapFile;
    Button btnExampleWebPage;
    Button btnExampleExternalWebPage;
    Button btnExampleMapFile;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        description = findViewById(R.id.antipattern);

        webPageEmbeddedDetail = findViewById(R.id.webPageEmbeddedIncorrectlyDetail);
        externalWebPageEmbeddedDetail = findViewById(R.id.externalWebPageEmbeddedDetail);
        mapFileEmbeddedDetail = findViewById(R.id.mapFileEmbeddedDetail);

        btnWebPage = findViewById(R.id.btnWebPageEmbeddedIncorrectly);
        btnExternalPage = findViewById(R.id.btnExternalWebPageEmbeddedIncorrectly);
        btnMapFile = findViewById(R.id.btnMapFileEmbedded);

        btnTestWebPage = findViewById(R.id.btnTestWebPageEmbedded);
        btnTestExternalPage = findViewById(R.id.btnTestExternalWebPageEmbedded);
        btnTestMapFile = findViewById(R.id.btnTestMapFileEmbedded);

        btnExampleWebPage = findViewById(R.id.btnExampleWebPageEmbedded);
        btnExampleExternalWebPage = findViewById(R.id.btnExampleExternalWebPageEmbedded);
        btnExampleMapFile = findViewById(R.id.btnExampleMapFileEmbedded);

        description.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://ml-papers.gitlab.io/android.connectivity-2017/online-appendix/antipatterns.html?id=BEI");
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

        btnWebPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(webPageEmbeddedDetail.getVisibility() == View.VISIBLE){
                    webPageEmbeddedDetail.setVisibility(View.GONE);
                }else{
                    webPageEmbeddedDetail.setVisibility(View.VISIBLE);
                }
            }
        });

        btnExternalPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(externalWebPageEmbeddedDetail.getVisibility() == View.VISIBLE){
                    externalWebPageEmbeddedDetail.setVisibility(View.GONE);
                }else{
                    externalWebPageEmbeddedDetail.setVisibility(View.VISIBLE);
                }
            }
        });

        btnMapFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mapFileEmbeddedDetail.getVisibility() == View.VISIBLE){
                    mapFileEmbeddedDetail.setVisibility(View.GONE);
                }else{
                    mapFileEmbeddedDetail.setVisibility(View.VISIBLE);
                }

            }
        });

        btnExampleWebPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://ml-papers.gitlab.io/android.connectivity-2017/online-appendix/antipatternExample.html?pID=BEI-LWEI");
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

        btnExampleExternalWebPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri uri = Uri.parse("https://ml-papers.gitlab.io/android.connectivity-2017/online-appendix/antipatternExample.html?pID=BEI-EWEI");
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

        btnExampleMapFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://ml-papers.gitlab.io/android.connectivity-2017/online-appendix/antipatternExample.html?pID=BEI-MFEI");
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

        btnTestWebPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnTestExternalPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnTestMapFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
