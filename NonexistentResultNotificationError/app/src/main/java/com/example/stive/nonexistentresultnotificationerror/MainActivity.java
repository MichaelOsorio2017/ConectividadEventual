package com.example.stive.nonexistentresultnotificationerror;

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

    RelativeLayout downloadingContentDetail;
    RelativeLayout issueDownloadingContentDetail;
    RelativeLayout actionPerformedSuccessfullyDetail;
    RelativeLayout problemWhenPerformingAnActionDetail;
    RelativeLayout executedInBackgroundDetail;
    RelativeLayout retryingAnActionDetail;

    Button btnDownloadingContent;
    Button btnIssueDownloadingContent;
    Button btnActionPerformedSuccessfully;
    Button btnProblemWhenPerformingAction;
    Button btnExecutedInBackground;
    Button btnRetryingAction;

    Button btnTestDownLoadingContent;
    Button btnTestIssueDownloading;
    Button btnTestActionPerformedSuccessfully;
    Button btnTestProblemWhenPerformingAction;
    Button btnTestExecutedInBackground;
    Button btnTestRetryingAnAction;

    Button btnExampleDownloadingContent;
    Button btnExampleIssueDownloadingContent;
    Button btnExampleActionPerformedSuccess;
    Button btnExampleProblemExecutedAnAction;
    Button btnExampleExecutedInBackground;
    Button btnExampleRetryingAnAction;

    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        description = findViewById(R.id.antipattern);

        downloadingContentDetail = findViewById(R.id.downloadingContentDetail);
        issueDownloadingContentDetail = findViewById(R.id.downloadingContentIssueDetail);
        actionPerformedSuccessfullyDetail = findViewById(R.id.actionPerformedSuccessfullyDetail);
        problemWhenPerformingAnActionDetail = findViewById(R.id.actionProblemPerformingAction);
        executedInBackgroundDetail = findViewById(R.id.actionProcessInBackgroundDetail);
        retryingAnActionDetail = findViewById(R.id.retryingAnActionDetail);

        btnDownloadingContent = findViewById(R.id.btnDownloadingContent);
        btnIssueDownloadingContent = findViewById(R.id.btnIssueDownloadingContent);
        btnActionPerformedSuccessfully = findViewById(R.id.btnActionPerformedSuccessfully);
        btnProblemWhenPerformingAction = findViewById(R.id.btnProblemWhenPerformedAnAction);
        btnExecutedInBackground = findViewById(R.id.btnProcessInBackground);
        btnRetryingAction = findViewById(R.id.btnRetryingAnAction);

        btnTestDownLoadingContent = findViewById(R.id.btnTestDownloadContent);
        btnTestIssueDownloading = findViewById(R.id.btnIssueDownloadingContent);
        btnTestActionPerformedSuccessfully = findViewById(R.id.btnTestActionPerformedSuccess);
        btnTestProblemWhenPerformingAction = findViewById(R.id.btnTestProblemPerformingAction);
        btnTestExecutedInBackground = findViewById(R.id.btnTestProcessInBackground);
        btnTestRetryingAnAction = findViewById(R.id.btnTestRetryingAnAction);

        btnExampleDownloadingContent = findViewById(R.id.btnExamplesDownloadContent);
        btnExampleIssueDownloadingContent = findViewById(R.id.btnExamplesDownloadContentIssue);
        btnExampleActionPerformedSuccess = findViewById(R.id.btnExamplesActionPerformedSuccess);
        btnExampleProblemExecutedAnAction = findViewById(R.id.btnExamplesProblemPerformingAction);
        btnExampleExecutedInBackground = findViewById(R.id.btnExamplesProcessInBackground);
        btnExampleRetryingAnAction = findViewById(R.id.btnExampleRetryingAnAction);

        description.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://ml-papers.gitlab.io/android.connectivity-2017/online-appendix/antipatterns.html?id=NRN");
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

        btnDownloadingContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(downloadingContentDetail.getVisibility() == View.VISIBLE){
                    downloadingContentDetail.setVisibility(View.GONE);
                }else{
                    downloadingContentDetail.setVisibility(View.VISIBLE);
                }
            }
        });

        btnIssueDownloadingContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(issueDownloadingContentDetail.getVisibility() == View.VISIBLE){
                    issueDownloadingContentDetail.setVisibility(View.GONE);
                }else{
                    issueDownloadingContentDetail.setVisibility(View.VISIBLE);
                }
            }
        });

        btnActionPerformedSuccessfully.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(actionPerformedSuccessfullyDetail.getVisibility() == View.VISIBLE){
                    actionPerformedSuccessfullyDetail.setVisibility(View.GONE);
                }else{
                    actionPerformedSuccessfullyDetail.setVisibility(View.VISIBLE);
                }
            }
        });

        btnProblemWhenPerformingAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(problemWhenPerformingAnActionDetail.getVisibility() == View.VISIBLE){
                    problemWhenPerformingAnActionDetail.setVisibility(View.GONE);
                }else{
                    problemWhenPerformingAnActionDetail.setVisibility(View.VISIBLE);
                }
            }
        });

        btnExecutedInBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(executedInBackgroundDetail.getVisibility() == View.VISIBLE){
                    executedInBackgroundDetail.setVisibility(View.GONE);
                }else{
                    executedInBackgroundDetail.setVisibility(View.VISIBLE);
                }
            }
        });

        btnRetryingAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(retryingAnActionDetail.getVisibility() == View.VISIBLE){
                    retryingAnActionDetail.setVisibility(View.GONE);
                }else{
                    retryingAnActionDetail.setVisibility(View.VISIBLE);
                }
            }
        });

        btnExampleDownloadingContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://ml-papers.gitlab.io/android.connectivity-2017/online-appendix/antipatternExample.html?pID=NRN-NNDS");
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

        btnExampleIssueDownloadingContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://ml-papers.gitlab.io/android.connectivity-2017/online-appendix/antipatternExample.html?pID=NRN-NNDP");
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

        btnExampleActionPerformedSuccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://ml-papers.gitlab.io/android.connectivity-2017/online-appendix/antipatternExample.html?pID=NRN-NNAPS");
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

        btnExampleProblemExecutedAnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://ml-papers.gitlab.io/android.connectivity-2017/online-appendix/antipatternExample.html?pID=NRN-NNPPA");
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

        btnExampleExecutedInBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://ml-papers.gitlab.io/android.connectivity-2017/online-appendix/antipatternExample.html?pID=NRN-NNPEB");
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

        btnExampleRetryingAnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://ml-papers.gitlab.io/android.connectivity-2017/online-appendix/antipatternExample.html?pID=NRN-NNRA");
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
