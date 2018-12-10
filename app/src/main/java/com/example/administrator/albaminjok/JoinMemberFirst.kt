package com.example.administrator.albaminjok

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button

class JoinMemberFirst : AppCompatActivity() {

    private val JOINMEMBER = 1000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.join_member_first)

        var nextPage = findViewById<Button>(R.id.nextPage)
//        nextPage.setInputExtras(0)



        nextPage.setOnClickListener {
            val view = this.getCurrentFocus()
            if (view != null)
            {
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0)
            }

            val i = Intent(this@JoinMemberFirst, JoinMember::class.java)
            startActivityForResult(i, JOINMEMBER)
        }
    }
}
