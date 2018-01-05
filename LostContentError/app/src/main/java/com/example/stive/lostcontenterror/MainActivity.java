package com.example.stive.lostcontenterror;

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

    private RelativeLayout blankMapDetail;
    private RelativeLayout blurredMapDetail;
    private RelativeLayout blankImageDetail;
    private RelativeLayout lostFunctionalityDetail;
    private RelativeLayout lostTextDetail;

    private Button btnBlankMap;
    private Button btnBlurredMap;
    private Button btnBlankImage;
    private Button btnLostFunction;
    private Button btnLostText;
    private Button btnExampleBlankMap;
    private Button btnExampleBlurredMap;
    private Button btnExampleBlankImage;
    private Button btnExampleLostFuction;
    private Button btnExampleLostText;
    private Button btnTestBlankMap;
    private Button btnTestBlurredMap;
    private Button btnTestBlankImage;
    private Button btnTestLostFunction;
    private Button btnTestLostText;

    private TextView description;

    private Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        blankMapDetail = findViewById(R.id.blankMapDetail);
        blurredMapDetail = findViewById(R.id.blurredMapDetail);
        blankImageDetail = findViewById(R.id.blankImageDetail);
        lostFunctionalityDetail = findViewById(R.id.lostFunctionalityDetail);
        lostTextDetail = findViewById(R.id.lostTextDetail);

        btnBlankMap = findViewById(R.id.btnBlankMap);
        btnBlurredMap = findViewById(R.id.btnBlurredMap);
        btnBlankImage = findViewById(R.id.btnBlankImage);
        btnLostFunction = findViewById(R.id.btnLostFunctionality);
        btnLostText = findViewById(R.id.btnLostText);
        btnExampleBlankMap = findViewById(R.id.btnExamplesBlankMap);
        btnExampleBlurredMap = findViewById(R.id.btnExamplesBlurredMap);
        btnExampleBlankImage = findViewById(R.id.btnExamplesBlankImage);
        btnExampleLostFuction = findViewById(R.id.btnExamplesLostFunctionality);
        btnExampleLostText = findViewById(R.id.btnExamplesLostText);
        btnTestBlankMap = findViewById(R.id.btnTestBlankMap);
        btnTestBlurredMap = findViewById(R.id.btnTestBlurredMap);
        btnTestBlankImage = findViewById(R.id.btnTestBlankImage);
        btnTestLostFunction = findViewById(R.id.btnTestLostFunctionality);
        btnTestLostText = findViewById(R.id.btnTestLostText);

        description = findViewById(R.id.antipattern);

        description.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://ml-papers.gitlab.io/android.connectivity-2017/online-appendix/antipatterns.html?id=LC");
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

        btnBlankMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(blankMapDetail.getVisibility() == View.GONE) {
                    blankMapDetail.setVisibility(View.VISIBLE);
                }else{
                    blankMapDetail.setVisibility(View.GONE);
                }
            }
        });

        btnBlurredMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(blurredMapDetail.getVisibility() == View.GONE) {
                    blurredMapDetail.setVisibility(View.VISIBLE);
                }else{
                    blurredMapDetail.setVisibility(View.GONE);
                }
            }
        });

        btnBlankImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(blankImageDetail.getVisibility() == View.GONE) {
                    blankImageDetail.setVisibility(View.VISIBLE);
                }else{
                    blankImageDetail.setVisibility(View.GONE);
                }
            }
        });

        btnLostFunction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lostFunctionalityDetail.getVisibility() == View.GONE) {
                    lostFunctionalityDetail.setVisibility(View.VISIBLE);
                }else{
                    lostFunctionalityDetail.setVisibility(View.GONE);
                }
            }
        });

        btnLostText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lostTextDetail.getVisibility() == View.GONE) {
                    lostTextDetail.setVisibility(View.VISIBLE);
                }else{
                    lostTextDetail.setVisibility(View.GONE);
                }
            }
        });

        btnExampleBlankMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://ml-papers.gitlab.io/android.connectivity-2017/online-appendix/antipatternExample.html?pID=LC-BM");
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

        btnExampleBlurredMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://ml-papers.gitlab.io/android.connectivity-2017/online-appendix/antipatternExample.html?pID=LC-BMA");
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

        btnExampleBlankImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://ml-papers.gitlab.io/android.connectivity-2017/online-appendix/antipatternExample.html?pID=LC-BI");
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

        btnExampleLostFuction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://ml-papers.gitlab.io/android.connectivity-2017/online-appendix/antipatternExample.html?pID=LC-LF");
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

        btnExampleLostText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://ml-papers.gitlab.io/android.connectivity-2017/online-appendix/antipatternExample.html?pID=LC-LT");
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

        btnTestBlankMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,BlankMapActivity.class);
                startActivity(intent);
            }
        });

        btnTestBlurredMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,BlurredMapActivity.class);
                startActivity(intent);
            }
        });

        btnTestBlankImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnTestLostFunction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnTestLostText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
