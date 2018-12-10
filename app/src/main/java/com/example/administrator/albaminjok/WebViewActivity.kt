package com.example.administrator.albaminjok

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.webkit.JavascriptInterface
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.widget.TextView
import android.widget.Toast


class WebViewActivity : AppCompatActivity() {
//    private var webView: WebView? = null
    private var result: TextView? = null
    private var handler: Handler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        result = findViewById<View>(R.id.result) as TextView

        // WebView 초기화
        init_webView()

        // 핸들러를 통한 JavaScript 이벤트 반응1
        handler = Handler()
    }

    fun init_webView() {
        val webView = findViewById<View>(R.id.webView) as WebView
        val settings = webView.settings
        settings.javaScriptEnabled = true
        settings.domStorageEnabled = true
        settings.javaScriptCanOpenWindowsAutomatically = true

        webView.addJavascriptInterface(AndroidBridge(), "TestApp")
        webView.webChromeClient = WebChromeClient()
        // webview url load
        webView.loadUrl("http://codeman77.ivyro.net/getAddress.php")
    }

    private inner class AndroidBridge {
        @JavascriptInterface
        fun setAddress(arg1: String, arg2: String, arg3: String) {
//            Toast.makeText(this@WebViewActivity, "1234567890", Toast.LENGTH_SHORT).show()

            handler?.post(object : Runnable {
                public override fun run() {
                    val addr = arg1 + arg2 + arg3
//                    Toast.makeText(this@WebViewActivity, addr, Toast.LENGTH_SHORT).show()

                   // Toast.makeText(this@WebViewActivity, "Runnable 안에ㅔㅔ", Toast.LENGTH_SHORT).show()
                    init_webView()

                    val intent = Intent(this@WebViewActivity, JoinMember::class.java)
                    //val addr = arg1 + arg2 + arg3
                   // Toast.makeText(this@WebViewActivity, addr, Toast.LENGTH_SHORT).show()
                    intent.putExtra("addr", addr)
                    startActivity(intent)
                    finish()
                }
            })



        } //setAddress
    }


}

