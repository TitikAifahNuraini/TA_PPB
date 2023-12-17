package com.example.ta_ppb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class DasboradActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dasborad)

        val btn1 = findViewById<CardView>(R.id.btn1)

        btn1.setOnClickListener{
            val intent = Intent(this, JobsheetActivity::class.java)
            startActivity(intent)
        }

        val btn2 = findViewById<CardView>(R.id.btn2)

        btn2.setOnClickListener{
            val intent = Intent(this,EvaluasiActivity ::class.java)
            startActivity(intent)
        }

    }
}