package com.example.administrator.albaminjok

import android.app.DatePickerDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.administrator.albaminjok.R.id.birthdaybtn
import com.example.administrator.albaminjok.R.layout.join_member
import kotlinx.android.synthetic.main.join_member.*
import java.text.SimpleDateFormat
import java.util.*


class JoinMember : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(join_member)

        val textView: TextView = findViewById(R.id.birthdate)
        //textView.text = SimpleDateFormat("yyyy 년 MM 월 dd 일").format(System.currentTimeMillis())

        var cal = Calendar.getInstance()
        val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, monthOfYear)
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            //val myFormat = "dd.MM.yyyy" // mention the format you need
            val myFormat = "yyyy.MM.dd"
            val sdf = SimpleDateFormat(myFormat, Locale.KOREA)
            textView.text = sdf.format(cal.time)
        }

        birthdaybtn.setOnClickListener{
            DatePickerDialog(
                this@JoinMember, dateSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
    }


}

