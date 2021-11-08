package com.example.imcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlin.math.log

class DashboardActivity : AppCompatActivity() {

    lateinit var tvNome: TextView
    lateinit var tvProfissao: TextView
    lateinit var tvAltura: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        tvNome = findViewById(R.id.tv_nome)
        tvProfissao = findViewById(R.id.tv_profissao)
        tvAltura = findViewById(R.id.tv_altura)

        preencherDashboard()

        supportActionBar!!.hide()
    }

    private fun preencherDashboard(){
        val arquivo = getSharedPreferences("usuario", MODE_PRIVATE)
        tvNome.text = arquivo.getString("nome", "xxx")
        tvProfissao.text = arquivo.getString("profissao", "xxx")
        tvAltura.text = arquivo.getFloat("altura", 0.0f).toString()
    }
}