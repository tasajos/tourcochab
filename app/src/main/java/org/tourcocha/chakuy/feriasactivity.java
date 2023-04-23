package org.tourcocha.chakuy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class feriasactivity extends AppCompatActivity {
    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feriasactivity);
        mWebView = (WebView) findViewById(R.id.my_ferias_view);
        mWebView.getSettings().setJavaScriptEnabled(true); // habilitar JavaScript (opcional)

        String url = "http://tour2kcbba.chakuy.com/actividades/";
        mWebView.loadUrl(url);

        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

//Volver
        this.setTitle("Ferias");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




    }

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }


}
