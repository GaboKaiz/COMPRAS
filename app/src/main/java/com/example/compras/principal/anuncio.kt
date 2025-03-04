package com.example.compras.principal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.compras.R
import com.example.compras.inicio.inicio // CORREGIDO: Importación correcta de la clase

class anuncio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.anuncio) // CORREGIDO: Debe coincidir con `anuncio.xml`

        // Botón para redirigir a `Inicio`
        val btnFinalizar = findViewById<Button>(R.id.btnFinalizar)
        btnFinalizar.setOnClickListener {
            val intent = Intent(this@anuncio, inicio::class.java)
            startActivity(intent)
            finish() // Opcional: Cierra la actividad actual para evitar que vuelva atrás
        }
    }
}
