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
import com.example.compras.principal.anuncio // Asegúrate de importar la clase anuncio

class login : AppCompatActivity() {

    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        databaseHelper = DatabaseHelper(this)

        val edtCorreo: EditText = findViewById(R.id.edtUsername)
        val edtPassword: EditText = findViewById(R.id.edtPassword)
        val btnIniciar: Button = findViewById(R.id.btnLogin)
        val btnRetroceder = findViewById<ImageButton>(R.id.btnretroceder)
        val btnRegistro = findViewById<TextView>(R.id.btnRegistro)



        btnIniciar.setOnClickListener {
            val correoIngresado = edtCorreo.text.toString().trim()
            val passwordIngresado = edtPassword.text.toString().trim()

            if (correoIngresado.isEmpty() || passwordIngresado.isEmpty()) {
                Toast.makeText(this, "Ingresa tus datos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val usuarioValido = databaseHelper.validarUsuario(correoIngresado, passwordIngresado)

            if (usuarioValido) {
                Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, anuncio::class.java)) // Aquí se cambia a "anuncio"
                finish()
            } else {
                Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
            }
        }
        btnRegistro.setOnClickListener {
            startActivity(Intent(this, registro::class.java))
        }
        btnRetroceder.setOnClickListener {
            finish()
        }
    }
}
