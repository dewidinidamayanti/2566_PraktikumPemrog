package com.example.a2566_login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import android.net.Uri
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val tvUcapan: TextView = findViewById(R.id.tv_ucapan)
        val username = intent.getStringExtra("nama")
        tvUcapan.text = getString(R.string.welcome_text, username)

        val btnOpenWebsite: Button = findViewById(R.id.btn_open_website)
        btnOpenWebsite.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, "https://amikom.ac.id".toUri())
            startActivity(intent)
        }

         // Tampilkan fragment dashboard_fragment.xml lewat DashboardFragment
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.fragment_container, DashboardFragment())
//            .commit()

        val rvMahasiswa: RecyclerView = findViewById(R.id.rv_mahasiswa)

        val dataMahasiswa = arrayListOf(
            Mahasiswa("Dewi Dini Damayanti", "25.22.2566"),
            Mahasiswa("Haikal", "22.02.0914"),
            Mahasiswa("Jenova", "22.02.0900"),
            Mahasiswa("Diandra", "22.02.0878"),
            Mahasiswa("Lana", "22.02.0888")
        )


//         rvMahasiswa.layoutManager = LinearLayoutManager(this)

        rvMahasiswa.layoutManager = GridLayoutManager(this, 2)

        val adapter = MahasiswaAdapter(dataMahasiswa)
        rvMahasiswa.adapter = adapter

        val bottomNav: BottomNavigationView = findViewById(R.id.bottom_navigation)

        // 1. Muat Fragment default (Dashboard) saat pertama kali dibuka
        loadFragment(DashboardFragment())

        // 2. Tambahkan listener untuk menangani klik item navigasi
        bottomNav.setOnItemSelectedListener { item ->
            var fragment: Fragment
            when (item.itemId) {
                R.id.nav_dashboard -> {
                    fragment = DashboardFragment()
                    loadFragment(fragment)
                    true // Mengembalikan true menandakan item telah ditangani
                }
                R.id.nav_profile -> {
                    fragment = ProfileFragment()
                    loadFragment(fragment)
                    true
                }
                R.id.nav_settings -> {
                    fragment = SettingsFragment()
                    loadFragment(fragment)
                    true
                }
                else -> false
            }
        }
    }

    // 3. Buat fungsi helper untuk memuat Fragment
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_home, fragment)
            .commit()
    }

}
