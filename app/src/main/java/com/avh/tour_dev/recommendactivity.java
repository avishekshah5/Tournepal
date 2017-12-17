package com.avh.tour_dev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class recommendactivity extends AppCompatActivity {
    WebView webview;
    ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recommend);
        webview= findViewById(R.id.webview);
        progress= findViewById(R.id.progress);
        webview.loadUrl("http://tourismnepal.net/");
        webview.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progress.setVisibility(View.GONE);
            }
        });

           webview.getSettings().setJavaScriptEnabled(true);
    }
}
