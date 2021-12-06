package com.example.imcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.cardview.widget.CardView
import kotlin.math.log

class DashboardActivity : AppCompatActivity() {

    lateinit var tvNome: TextView
    lateinit var tvProfissao: TextView
    lateinit var tvAltura: TextView
    lateinit var cardPesarAgora: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        tvNome = findViewById(R.id.tv_nome)
        tvProfissao = findViewById(R.id.tv_profissao)
        tvAltura = findViewById(R.id.tv_altura)
        cardPesarAgora = findViewById(R.id.card_pesar_agora)

        cardPesarAgora.setOnClickListener{
            val abrirPesagem = Intent(this, pesagemActivity::class.java)
            startActivity(abrirPesagem)
        }

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