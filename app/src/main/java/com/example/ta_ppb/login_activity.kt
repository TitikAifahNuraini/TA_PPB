package com.example.ta_ppb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.ta_ppb.api.ApiConfig
import com.example.ta_ppb.model.ResponModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class login_activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginButton = findViewById<Button>(R.id.Login)
        loginButton.setOnClickListener {
            login()
        }
    }

    fun login() {
        val emailEdit = findViewById<EditText>(R.id.email)
        val passwordEdit = findViewById<EditText>(R.id.password)

        if (emailEdit.text.isEmpty()) {
            emailEdit.error = "Kolom Email tidak boleh kosong"
            emailEdit.requestFocus()
            return

        } else if (passwordEdit.text.isEmpty()) {
            passwordEdit.error = "Kolom Password tidak boleh kosong"
            passwordEdit.requestFocus()
            return

        }
        ApiConfig.instanceRetrofit.login(emailEdit.text.toString(), passwordEdit.text.toString())
            .enqueue(object :
                Callback<ResponModel> {
                override fun onFailure(call: Call<ResponModel>, t: Throwable) {
                    Toast.makeText(this@login_activity, "Error:" + t.message, Toast.LENGTH_SHORT)
                        .show()
                }

                override fun onResponse(call: Call<ResponModel>, response: Response<ResponModel>) {
                    val respon = response.body()!!
                    if (respon.status == 200) {
                        Toast.makeText(
                            this@login_activity,
                            "Login Berhasil, Gass Ke Beranda",
                            Toast.LENGTH_SHORT
                        ).show()
                        Handler(Looper.getMainLooper()).postDelayed({
                            val intent = Intent(this@login_activity, DasboradActivity::class.java)
                            startActivity(intent)
                            finish()  // Menutup aktivitas saat ini agar pengguna tidak dapat kembali ke halaman pendaftaran
                        }, 2000)

                    } else {
                        Toast.makeText(this@login_activity, respon.message, Toast.LENGTH_SHORT)
                            .show()

                    }
                }


            })

    }
}

