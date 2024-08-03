package com.example.login

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nomeUsuario = intent.getStringExtra("nomeUsuario")
        val textoBemVindo: TextView = findViewById(R.id.textView2)

        textoBemVindo.text = "$nomeUsuario!"
    }
}
