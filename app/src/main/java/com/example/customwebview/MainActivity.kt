package com.example.customwebview

import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var webView: WebView
    private lateinit var urlInput: EditText
    private lateinit var userAgentInput: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.webView)
        urlInput = findViewById(R.id.urlInput)
        userAgentInput = findViewById(R.id.userAgentInput)

        setupWebView()

        findViewById<Button>(R.id.loadButton).setOnClickListener {
            loadUrl()
        }

        findViewById<Button>(R.id.setUserAgentButton).setOnClickListener {
            setUserAgent()
        }
    }

    private fun setupWebView() {
        val webSettings = webView.settings
        
        // Основні налаштування
        webSettings.javaScriptEnabled = true
        webSettings.domStorageEnabled = true
        
        // Вимкнення WebRTC
        webSettings.mediaPlaybackRequiresUserGesture = true
        webSettings.mixedContentMode = WebSettings.MIXED_CONTENT_NEVER_ALLOW
        
        webView.webViewClient = WebViewClient()
        urlInput.setText("https://google.com")
        loadUrl()
    }

    private fun loadUrl() {
        var url = urlInput.text.toString().trim()
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "https://$url"
        }
        webView.loadUrl(url)
    }

    private fun setUserAgent() {
        val userAgent = userAgentInput.text.toString().trim()
        if (userAgent.isNotEmpty()) {
            webView.settings.userAgentString = userAgent
        }
    }

    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}