package com.example.administrator.albaminjok

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityCompat.startActivityForResult
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import com.example.administrator.albaminjok.R.layout.join_member


 class JoinMember : AppCompatActivity() {
     private val SEARCH_ADDRESS_ACTIVITY = 10000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(join_member)

        val btn_search = findViewById(R.id.button) as Button

        if (btn_search != null)
            btn_search.setOnClickListener(
                object : View.OnClickListener {
                    override fun onClick(v: View) {
                        val i = Intent(this@JoinMember, WebViewActivity::class.java)
                        startActivityForResult(i, SEARCH_ADDRESS_ACTIVITY)
                    }
                })
    }


}

