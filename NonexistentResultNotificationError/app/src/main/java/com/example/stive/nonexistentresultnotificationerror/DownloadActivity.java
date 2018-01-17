package com.example.stive.nonexistentresultnotificationerror;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadActivity extends AppCompatActivity {

    private ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        image = findViewById(R.id.image);

        new callImageExceptionTrace().execute();
    }

    private class callImageExceptionTrace extends AsyncTask<Void,Void,Bitmap>{

        protected Bitmap doInBackground(Void... voids){
            URL urlImage = null;
            HttpURLConnection conn = null;
            try{

                InputStream inputStream = new java.net.URL("https://github.com/MichaelOsorio2017/ConectividadEventual/blob/master/Resourses/androidIcon.png?raw=true").openStream();
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 1;
                return BitmapFactory.decodeStream(inputStream);
            }catch (Exception e){
               ;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run(){
                        ConnectivityManager connectivityManager = (ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
                        WifiManager wifiManager = (WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

                        if(networkInfo != null){
                            if(networkInfo.isAvailable() && networkInfo.isConnected()){
                                Toast.makeText(getApplicationContext(),"There was an error downloading file",Toast.LENGTH_LONG).show();
                            }
                        }else if(wifiManager.isWifiEnabled() && wifiManager.getWifiState() != WifiManager.WIFI_STATE_ENABLING){
                            Toast.makeText(getApplicationContext(),"There was an error downloading file",Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getApplicationContext(),"No internet connection. Make sure Wi-Fi or cellular data is turned on, then try again.",Toast.LENGTH_LONG).show();
                        }

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
            default:return super.onOptionsItemSelected(item);
        }
    }

}
