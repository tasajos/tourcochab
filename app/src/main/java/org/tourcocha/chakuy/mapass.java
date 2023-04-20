package org.tourcocha.chakuy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebView;

public class mapass extends AppCompatActivity {

    private WebView mWebView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapass);



        mWebView = (WebView) findViewById(R.id.my_webview);
        mWebView.getSettings().setJavaScriptEnabled(true); // habilitar JavaScript (opcional)

        String url = "https://www.google.com/maps/d/u/0/edit?mid=1O27JuI_HDgjAQvmcM7gJVpGp3dt23JQ&usp=sharing";
        mWebView.loadUrl(url);

        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

//Volver
        this.setTitle("Mapa");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




    }





    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }


}