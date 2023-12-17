package com.example.ta_ppb

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val actButton = findViewById<Button>(R.id.Start)

        actButton.setOnClickListener {
            val intent = Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }

        val actButton1 = findViewById<Button>(R.id.login)

        actButton1.setOnClickListener {
            val intent2 = Intent(this, login_activity::class.java)
            startActivity(intent2)
        }



    }
}