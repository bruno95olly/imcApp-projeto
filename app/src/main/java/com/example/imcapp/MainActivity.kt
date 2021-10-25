package com.example.imcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()

        val buttonEntrar = findViewById<Button>(R.id.button_entrar)
        val btnCadastrar = findViewById<Button>(R.id.button_cadastrar)

        buttonEntrar.setOnClickListener{
            val abrirDashboard = Intent (this, DashboardActivity::class.java)
            startActivity(abrirDashboard)
        }
        btnCadastrar.setOnClickListener{
            val abrirCadastro = Intent(this, activity_novo_usuario::class.java)
            startActivity(abrirCadastro)
        }
    }


}