package com.example.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

// Classe representando o usuário com nome e senha
data class Usuario(val nome: String, val senha: String)

class LoginActivity : AppCompatActivity() {
    // Lista de usuários pré-existente
    val usuarios = listOf(
        Usuario("joao", "1234"),
        Usuario("maria", "4321"),
        Usuario("jose", "abcd")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val campoUsuario: EditText = findViewById(R.id.editTextText)
        val campoSenha: EditText = findViewById(R.id.editTextText2)
        val botaoLogin: Button = findViewById(R.id.loginb)

        botaoLogin.setOnClickListener {
            val nomeUsuario = campoUsuario.text.toString()
            val senha = campoSenha.text.toString()

            // Verifica se o usuário e senha estão corretos
            val usuarioValido = usuarios.find { it.nome == nomeUsuario && it.senha == senha }

            if (usuarioValido != null) {
                // Se login correto, redireciona para a tela principal
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("nomeUsuario", usuarioValido.nome)
                startActivity(intent)
            } else {
                // Se login inválido, exibe mensagem de erro
                Toast.makeText(this, "Login inválido", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
