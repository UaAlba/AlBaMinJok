package com.example.administrator.albaminjok

import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.webkit.WebView
import android.widget.TextView


class WebViewActivity : AppCompatActivity() {
    private var webView: WebView? = null
    private var result: TextView? = null
    private var handler: Handler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        result = findViewById(R.id.result) as TextView

        // WebView 초기화
        init_webView()


        // 핸들러를 통한 JavaScript 이벤트 반응
        handler = Handler()
    }

    fun init_webView() {
        // WebView 설정
//        webView = findViewById(R.id.webView) as WebView
        // JavaScript 허용
//        webView.getSettings().javaScriptEnabled = true


        val webView = findViewById<View>(R.id.webView) as WebView
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(true)
        }
        val settings = webView.settings
        settings.javaScriptEnabled = true
        settings.domStorageEnabled = true





        // JavaScript의 window.open 허용
        /*webView.getSettings().javaScriptCanOpenWindowsAutomatically = true
        // JavaScript이벤트에 대응할 함수를 정의 한 클래스를 붙여줌
        // 두 번째 파라미터는 사용될 php에도 동일하게 사용해야함
                webView.addJavascriptInterface(AndroidBridge(), "TestApp")
        // web client 를 chrome 으로 설정
        webView.setWebChromeClient(WebChromeClient())
        // webview url load
        //        webView.loadUrl("file:///android_asset/search_address.html");
        webView.loadUrl("http://codeman77.ivyro.net/getAddress.php")*/

    }

  /*  private inner class AndroidBridge {
        @JavascriptInterface
        fun setAddress(arg1: String, arg2: String, arg3: String) {
            handler.post(Runnable {
                //                    Toast.makeText(WebViewActivity.this, arg1+arg2+arg3, Toast.LENGTH_SHORT).show();
                //                    Toast.makeText(WebViewActivity.this, arg1, Toast.LENGTH_SHORT).show();
                //                    Toast.makeText(WebViewActivity.this, arg1, Toast.LENGTH_SHORT).show();

                result.setText(String.format("(%s) %s %s", arg1, arg2, arg3))
                // WebView를 초기화 하지않으면 재사용할 수 없음
                init_webView()
                //onPause();

                val intent = Intent(this@WebViewActivity, MainActivity::class.java)

                val addr = arg1 + arg2 + arg3
                Toast.makeText(this@WebViewActivity, addr, Toast.LENGTH_SHORT).show()
                intent.putExtra("addr", addr)
                startActivity(intent)
                finish()
            })

        }
    }*/

}
