
package com.example.webviewapp;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webView = findViewById(R.id.webview);
        EditText inputUrl = findViewById(R.id.input_url);
        EditText inputUa = findViewById(R.id.input_ua);
        Button goButton = findViewById(R.id.go_button);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setMediaPlaybackRequiresUserGesture(false);
        webSettings.setDomStorageEnabled(true);
        webSettings.setAllowContentAccess(true);
        webSettings.setAllowFileAccess(true);
        webView.clearCache(true);

        goButton.setOnClickListener(v -> {
            String url = inputUrl.getText().toString();
            String ua = inputUa.getText().toString();
            webSettings.setUserAgentString(ua);
            webView.loadUrl(url);
        });
    }
}
