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
        EditText urlInput = findViewById(R.id.url_input);
        EditText uaInput = findViewById(R.id.ua_input);
        Button loadButton = findViewById(R.id.load_button);

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setMediaPlaybackRequiresUserGesture(true);
        settings.setUserAgentString("");

        // Вимкнення WebRTC (не дає гарантії, але вимикає MediaSource та WebRTC APIs максимально доступно)
        settings.setMediaPlaybackRequiresUserGesture(true);

        loadButton.setOnClickListener(v -> {
            String url = urlInput.getText().toString();
            String ua = uaInput.getText().toString();
            settings.setUserAgentString(ua);
            webView.loadUrl(url);
        });
    }
}
