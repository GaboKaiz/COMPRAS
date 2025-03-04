package com.example.compras.sesiones

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.compras.R
import com.example.compras.db.DatabaseHelper
import com.example.compras.principal.bievenidos

class registro : AppCompatActivity() {

    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registro)

        databaseHelper = DatabaseHelper(this)

        val edtCorreo: EditText = findViewById(R.id.edtUsername)
        val edtPassword: EditText = findViewById(R.id.edtPassword)
        val btnRegistro: Button = findViewById(R.id.btnRegistro)
        val btnRetroceder: ImageButton = findViewById(R.id.btnretroceder)
        val btnLogin = findViewById<TextView>(R.id.btnLogin)


        btnRegistro.setOnClickListener {
            val correo = edtCorreo.text.toString().trim()
            val password = edtPassword.text.toString().trim()

            if (correo.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val registrado = databaseHelper.registrarUsuario(correo, password)

            if (registrado) {
                Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, login::class.java))
                finish()
            } else {
                Toast.makeText(this, "Error: El usuario ya existe", Toast.LENGTH_SHORT).show()
            }
        }

        btnRetroceder.setOnClickListener {
            finish()
        }
        btnLogin.setOnClickListener {
            startActivity(Intent(this, login::class.java))
        }
    }
}
