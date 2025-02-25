package com.example.compras.sesiones

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.compras.R
import com.example.compras.sesiones.registro
import com.example.compras.principal.bievenidos

class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login) // Asegúrate de que este XML está creado

        // Referencia al TextView de "Registrarse Ahora"
        val txtRegister: TextView = findViewById(R.id.btnRegistro)
        val btnretroceder = findViewById<ImageButton>(R.id.btnretroceder)

        // Redireccionamiento a la pantalla de registro
        txtRegister.setOnClickListener {
            val intent = Intent(this, registro::class.java)
            startActivity(intent)
        }

        // Evento para retroceder
        btnretroceder.setOnClickListener {
            val intent = Intent(this, bievenidos::class.java)
            startActivity(intent)
        }
    }
}
