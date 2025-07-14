package com.example.mywebviewapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.PermissionRequest
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var webView: WebView
    private lateinit var urlEditText: EditText
    private lateinit var userAgentEditText: EditText
    private lateinit var loadUrlButton: Button

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.webView)
        urlEditText = findViewById(R.id.urlEditText)
        userAgentEditText = findViewById(R.id.userAgentEditText)
        loadUrlButton = findViewById(R.id.loadUrlButton)

        loadUrlButton.setOnClickListener {
            val url = urlEditText.text.toString().trim()
            val userAgent = userAgentEditText.text.toString().trim()
            
            if (url.isNotEmpty()) {
                setupWebView(userAgent)
                webView.loadUrl(url)
            }
        }
        
        setupWebView("")
        webView.loadUrl(urlEditText.text.toString())
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setupWebView(customUserAgent: String) {
        val settings = webView.settings
        settings.javaScriptEnabled = true

        if (customUserAgent.isNotBlank()) {
            settings.userAgentString = customUserAgent
        }

        webView.webChromeClient = object : WebChromeClient() {
            override fun onPermissionRequest(request: PermissionRequest) {
                request.deny()
            }
        }
        webView.webViewClient = WebViewClient()
    }

    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}