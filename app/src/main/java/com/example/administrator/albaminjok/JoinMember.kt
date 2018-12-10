@file:Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")

package com.example.administrator.albaminjok

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityCompat.startActivityForResult
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.administrator.albaminjok.R.layout.join_member
import kotlinx.android.synthetic.main.join_member.*


class JoinMember : AppCompatActivity() {
     private val SEARCH_ADDRESS_ACTIVITY = 10000

    // private val btn_search: Button? =null

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         setContentView(join_member)

         var address = findViewById(R.id.et_address) as TextView


         //Log.d("현주", "getIntent 위에에")
        val btn_search = findViewById<Button>(R.id.button)

       // if (btn_search != null)
         btn_search.setOnClickListener {
                val i = Intent(this@JoinMember, WebViewActivity::class.java)
                startActivityForResult(i, SEARCH_ADDRESS_ACTIVITY)
            }

         val intent = this.getIntent()
         val addr =  intent.getStringExtra("addr")

         if ("" != addr)
         {
             Log.d("현주", "if 문 안 주소오오오$addr")
             address.setText(addr)
//             et_address?.setText("addr")
         }

    }

     //여기부터 없없없
     internal fun onActivityResult(requestCode:Int, resultCode:Int, intent:Intent) {
         super.onActivityResult(requestCode, resultCode, intent)
         Toast.makeText(this@JoinMember, "hyunjuuuuuuuu", Toast.LENGTH_SHORT).show()
         when (requestCode) {

             SEARCH_ADDRESS_ACTIVITY ->
                 if (resultCode == RESULT_OK)
                 {
                     val data = intent.extras.getString("data")
                     Log.v("현주", "hyunjuuuuuuuu")
                     if (data != null)
                         et_address?.setText(data)
                 }
         }
     }

}

