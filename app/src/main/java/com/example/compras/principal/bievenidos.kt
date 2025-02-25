package com.example.compras.principal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.compras.R
import com.example.compras.principal.bievenidos
import com.example.compras.principal.MainActivity
import com.example.compras.sesiones.registro
import com.example.compras.sesiones.login


class bievenidos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bienvenidos)

        // Botón SENATRONIC II
        findViewById<Button>(R.id.btnLogin).setOnClickListener {
            startActivity(Intent(this, login::class.java))
        }

        // Botón Ingresar Empresa Software
        findViewById<Button>(R.id.btnRegistro).setOnClickListener {
            startActivity(Intent(this, registro::class.java))
        }

    }
}
