package com.example.stive.redirectionwithoutconnectivitycheck;

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

    RelativeLayout redirectToWebPageDetail;
    RelativeLayout redirectToAppDetail;

    Button btnRedirectToWebPage;
    Button btnRedirectToApp;
    Button btnTestRedirectToWebPage;
    Button btnTestRedirectToApp;
    Button btnExampleRedirectToWebPage;
    Button btnExampleRedirectToApp;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        description = findViewById(R.id.antipattern);

        redirectToWebPageDetail = findViewById(R.id.redirecToWebPageDetail);
        redirectToAppDetail = findViewById(R.id.redirecToAppDetail);

        btnRedirectToWebPage = findViewById(R.id.btnRedirectToWebPage);
        btnRedirectToApp = findViewById(R.id.btnRedirectToApp);
        btnTestRedirectToWebPage = findViewById(R.id.btnTestRedirectionToWebPage);
        btnTestRedirectToApp = findViewById(R.id.btnTestRedirectionToApp);
        btnExampleRedirectToWebPage = findViewById(R.id.btnExampleRedirectionToWebPage);
        btnExampleRedirectToApp = findViewById(R.id.btnExampleRedirectionToApp);

        description.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://ml-papers.gitlab.io/android.connectivity-2017/online-appendix/antipatterns.html?id=RWCC");
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

        btnRedirectToWebPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(redirectToWebPageDetail.getVisibility() == View.VISIBLE){
                    redirectToWebPageDetail.setVisibility(View.GONE);
                }else{
                    redirectToWebPageDetail.setVisibility(View.VISIBLE);
                }
            }
        });

        btnRedirectToApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(redirectToAppDetail.getVisibility() == View.VISIBLE){
                    redirectToAppDetail.setVisibility(View.GONE);
                }else{
                    redirectToAppDetail.setVisibility(View.VISIBLE);
                }

            }
        });

        btnExampleRedirectToWebPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://ml-papers.gitlab.io/android.connectivity-2017/online-appendix/antipatternExample.html?pID=RWCC-RWPC");
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

        btnExampleRedirectToApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://ml-papers.gitlab.io/android.connectivity-2017/online-appendix/antipatternExample.html?pID=RWCC-RDAC");
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


    }
}
