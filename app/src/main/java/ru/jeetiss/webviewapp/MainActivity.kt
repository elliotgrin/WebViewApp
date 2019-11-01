package ru.jeetiss.webviewapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.webkit.ConsoleMessage
import android.webkit.WebChromeClient
import kotlinx.android.synthetic.main.activity_main.*

private const val URL = "https://web-view.jeetiss.now.sh/"

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onStart() {
        super.onStart()
        Log.d("WEB_VIEW", "onStart()")
        setupWebView()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setupWebView() {
        webView.webChromeClient = MyWebChromeClient()
        webView.settings.javaScriptEnabled = true
        webView.settings.allowContentAccess = true
        webView.loadUrl(URL)
        Log.d("WEB_VIEW", "$URL has loaded")
    }


    private class MyWebChromeClient : WebChromeClient() {

        override fun onConsoleMessage(consoleMessage: ConsoleMessage?): Boolean {
            Log.d("WEB_VIEW", "Console log: ${consoleMessage?.message()}")

            return super.onConsoleMessage(consoleMessage)
        }

        // https://stackoverflow.com/questions/34891352/android-choose-file-button-in-webview

    }

}
