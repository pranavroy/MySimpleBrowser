package com.example.win10.mybrowser;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Main2Activity extends AppCompatActivity {
    private WebView xyz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent=getIntent();
        String y=intent.getStringExtra(MainActivity.extra);
        xyz=(WebView)findViewById(R.id.webview);
        xyz.getSettings().setLoadsImagesAutomatically(true);
        xyz.getSettings().setJavaScriptEnabled(true);
        xyz.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        xyz.loadUrl(y);
        xyz.setWebViewClient(new WebViewClient());
    }
    public void onBackPressed(){
        if(xyz.canGoBack()){
            xyz.goBack();
        }else {
            super.onBackPressed();
        }
    }
}
