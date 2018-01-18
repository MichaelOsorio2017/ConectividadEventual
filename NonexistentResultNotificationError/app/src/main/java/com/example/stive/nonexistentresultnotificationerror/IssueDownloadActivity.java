package com.example.stive.nonexistentresultnotificationerror;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

public class IssueDownloadActivity extends AppCompatActivity {

    private ImageView image;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issue_download);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        image = findViewById(R.id.imageIssue);

        new callImageExceptionTrace().execute();
    }

    private class callImageExceptionTrace extends AsyncTask<Void,Void,Bitmap> {

        protected Bitmap doInBackground(Void... voids) {
            try {
                InputStream inputStream = new java.net.URL("https://github.com/MichaelOsorio2017/ConectividadEventual/blob/master/Resources/androidIcon.png?raw=true").openStream();
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 1;
                return BitmapFactory.decodeStream(inputStream);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            try {
                image.setImageBitmap(bitmap);
                progressDialog.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        protected  void onPreExecute(){
            super.onPreExecute();
            progressDialog = new ProgressDialog(IssueDownloadActivity.this);
            progressDialog.setTitle("Downloading...");
            progressDialog.setIndeterminate(false);
            progressDialog.show();
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
