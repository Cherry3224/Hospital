package com.example.hospital

import android.os.Bundle
import android.util.Patterns
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // GỌI ĐÚNG TÊN LAYOUT (không .xml, không "main")
        setContentView(R.layout.activity_main)

        val etEmail = findViewById<TextInputEditText>(R.id.etEmail)
        val etPassword = findViewById<TextInputEditText>(R.id.etPassword)
        val btnSignIn = findViewById<MaterialButton>(R.id.btnSignIn)
        val tvForgot = findViewById<TextView>(R.id.tvForgot)

        btnSignIn.setOnClickListener {
            val email = etEmail.text?.toString()?.trim().orEmpty()
            val pass = etPassword.text?.toString()?.trim().orEmpty()

            when {
                email.isEmpty() -> {
                    etEmail.error = "Email is required"
                }
                !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                    etEmail.error = "Invalid email"
                }
                pass.isEmpty() -> {
                    etPassword.error = "Password is required"
                }
                else -> {
                    Toast.makeText(this, "Signing in...", Toast.LENGTH_SHORT).show()
                    // TODO: call API/login ở đây
                }
            }
        }

        tvForgot.setOnClickListener {
            Toast.makeText(this, "Forgot password tapped", Toast.LENGTH_SHORT).show()
        }
    }
}
