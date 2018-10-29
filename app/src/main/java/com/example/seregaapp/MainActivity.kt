package com.example.seregaapp

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.webkit.WebView
import com.example.seregaapp.ui.MainWebViewClient

class MainActivity : AppCompatActivity() {

    private lateinit var webViewMain: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setFullScreenMode()
        initWebView()
        loadUrlWebView(getString(R.string.main_url))
    }

    override fun onBackPressed() {
        if (webViewMain.canGoBack()) webViewMain.goBack()
        else super.onBackPressed()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun initWebView(){
        webViewMain = findViewById(R.id.webViewMain)
        webViewMain.webViewClient = MainWebViewClient()
        webViewMain.settings.javaScriptEnabled = true
    }

    private fun loadUrlWebView(url: String){
        webViewMain.loadUrl(url)
    }

    private fun setFullScreenMode(){
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}
