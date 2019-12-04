package com.example.exercicio1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.InputStream;

public class exercicio8part1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio8part1);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        new exercicio8part1.DownloadImageTask2((ImageView) findViewById(R.id.imginicial))
                .execute("https://faculdadeam.edu.br/Content/upload/noticias/814ac3a4-383a-4885-a60a-f97411b1068e.png");
        Button lermais = findViewById(R.id.lermais);
        lermais.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                try{

                    System.out.println("Indo para a activity 7");
                    Intent intent = new Intent(exercicio8part1.this,exercicio8part2.class);
                    startActivity(intent);
                }catch (Throwable e){
                    System.out.println(e);
                }

            }
        });

    }
    private class DownloadImageTask2 extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask2(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }


}
