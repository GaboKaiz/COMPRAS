package com.example.compras.principal

import com.example.compras.principal.bievenidos
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.compras.R

class MainActivity : AppCompatActivity() {

    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        handler.postDelayed({
            try {
                val intent = Intent(this, bievenidos::class.java)//Redireccionar a otra pestaña
                startActivity(intent)
                finish() // Cierra MainActivity después de abrir ChatPrincipal
            } catch (e: Exception) {
                e.printStackTrace() // Muestra errores en Logcat si algo falla
            }
        }, 1500)
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null) // Limpia los callbacks para evitar fugas de memoria
    }
}