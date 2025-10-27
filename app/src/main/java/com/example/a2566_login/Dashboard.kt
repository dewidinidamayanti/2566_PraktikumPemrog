package com.example.a2566_login

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri

class Dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard)

        val tvUcapan: TextView = findViewById(R.id.tv_ucapan)
        val username = intent.getStringExtra("nama")
        tvUcapan.text = getString(R.string.welcome_text, username)

        val btnOpenWebsite: Button = findViewById(R.id.btn_open_website)
        btnOpenWebsite.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, "https://amikom.ac.id".toUri())
            startActivity(intent)
        }

        // Tampilkan fragment dashboard_fragment.xml lewat DashboardFragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, DashboardFragment())
            .commit()
    }
}
