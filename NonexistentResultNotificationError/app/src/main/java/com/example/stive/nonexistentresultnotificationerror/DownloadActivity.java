package com.example.stive.nonexistentresultnotificationerror;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadActivity extends AppCompatActivity {

    private ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);

        image = findViewById(R.id.image);
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
                        Toast.makeText(getApplicationContext(),ex,Toast.LENGTH_LONG).show();
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
