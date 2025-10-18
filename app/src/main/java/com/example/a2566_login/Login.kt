package com.example.a2566_login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        val et_username: EditText = findViewById(R.id.et_username)
        val et_password: EditText = findViewById(R.id.et_password)
        val btn_login: Button = findViewById(R.id.et_btn_login)
        val tv_register: TextView = findViewById(R.id.tv_register)

        // Tombol Login
        btn_login.setOnClickListener {
            val username = et_username.text.toString()

            val pindah = Intent(this, Dashboard::class.java)
            pindah.putExtra("nama", username)
            startActivity(pindah)
        }

        // TextView Register
        tv_register.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }
    }
}
