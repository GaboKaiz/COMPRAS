package com.example.compras.sesiones

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.compras.R
import com.example.compras.principal.bievenidos

class omitir : AppCompatActivity() { // Nombre en mayúscula por convención
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Verifica si el XML existe antes de usarlo
        setContentView(R.layout.anuncio)

        // Verifica si el botón está en el XML antes de referenciarlo
        val btnFinalizar: Button? = findViewById(R.id.btnFinalizar)

        // Validar que el botón no sea nulo
        btnFinalizar?.setOnClickListener {
            // Navegar a otra pantalla cuando se presione el botón
            val intent = Intent(this, bievenidos::class.java) // Reemplaza con la actividad correcta
            startActivity(intent)
            finish() // Cierra la actividad actual
        }
    }
}
