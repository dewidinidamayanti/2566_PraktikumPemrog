package com.example.a2566_login

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        // Inisialisasi sesuai ID di XML kamu
        val etFullname: EditText = findViewById(R.id.et_fullname)
        val etUsername: EditText = findViewById(R.id.et_register_username)
        val etEmail: EditText = findViewById(R.id.et_register_email)
        val etPhone: EditText = findViewById(R.id.et_phone)
        val etPassword: EditText = findViewById(R.id.et_password)
        val etConfirmPassword: EditText = findViewById(R.id.et_confirm_password)
        val etKelamin: RadioGroup = findViewById(R.id.jenkel)
        val rbLaki: RadioButton = findViewById(R.id.rb_laki)
        val rbPerempuan: RadioButton = findViewById(R.id.rb_perempuan)
        val cbSk: CheckBox = findViewById(R.id.SK)
        val btnRegister: Button = findViewById(R.id.btn_register)

        // Aksi tombol "Daftar"
        btnRegister.setOnClickListener {
            val fullName = etFullname.text.toString()
            val username = etUsername.text.toString()
            val email = etEmail.text.toString()
            val phone = etPhone.text.toString()
            val password = etPassword.text.toString()
            val confirmPassword = etConfirmPassword.text.toString()

            val selectedId = etKelamin.checkedRadioButtonId
            val gender = when (selectedId) {
                R.id.rb_laki -> "Laki-Laki"
                R.id.rb_perempuan -> "Perempuan"
                else -> ""
            }

            val isAgreed = cbSk.isChecked

            // Validasi input
            when {
                fullName.isEmpty() || username.isEmpty() || email.isEmpty() || phone.isEmpty() ||
                        password.isEmpty() || confirmPassword.isEmpty() -> {
                    Toast.makeText(this, "Harap isi semua kolom", Toast.LENGTH_SHORT).show()
                }
                password != confirmPassword -> {
                    Toast.makeText(this, "Password tidak sama", Toast.LENGTH_SHORT).show()
                }
                selectedId == -1 -> {
                    Toast.makeText(this, "Pilih jenis kelamin terlebih dahulu", Toast.LENGTH_SHORT).show()
                }
                !isAgreed -> {
                    Toast.makeText(this, "Harap setujui syarat & ketentuan", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    // Tampilkan hasil di Toast sesuai instruksi tugas
                    Toast.makeText(
                        this,
                        "Jenis Kelamin: $gender, Setuju: $isAgreed",
                        Toast.LENGTH_LONG
                    ).show()

                    // Pindah ke halaman Login
                    val intent = Intent(this, Login::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }
    }
}
