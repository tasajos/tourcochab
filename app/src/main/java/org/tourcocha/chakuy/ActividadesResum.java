package org.tourcocha.chakuy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.os.Handler;
import android.widget.ProgressBar;
import android.view.View;


public class ActividadesResum extends AppCompatActivity {

    private WebView mWebView;
    private ProgressBar mProgressBar;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividades_resum);

        mWebView = (WebView) findViewById(R.id.my_actividades_view);
        mWebView.getSettings().setJavaScriptEnabled(true); // habilitar JavaScript (opcional)
        mProgressBar = findViewById(R.id.progressBar);
        mHandler = new Handler();
        String url = "http://tour2kcbba.chakuy.com/actividades-diarias/";
        mWebView.loadUrl(url);

        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
            @Override
            public void onPageFinished(WebView view, String url) {
                mProgressBar.setVisibility(View.GONE);
            }

        });

//Volver
        this.setTitle("Atractivos Turisticos");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Mostrar ProgressBar durante 3 segundos
        mProgressBar.setVisibility(View.VISIBLE);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mProgressBar.setVisibility(View.GONE);
            }
        }, 3000);
    }





    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }


}
