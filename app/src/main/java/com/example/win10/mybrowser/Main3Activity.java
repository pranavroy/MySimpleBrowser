package com.example.win10.mybrowser;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Main3Activity extends AppCompatActivity {
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        image= (ImageView) findViewById(R.id.imageView);
        Bitmap bitmap= BitmapFactory.decodeFile(getIntent().getStringExtra("imagepath"));
        image.setImageBitmap(bitmap);
    }
}
