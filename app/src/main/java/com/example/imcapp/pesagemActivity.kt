package com.example.imcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import com.example.imcapp.utils.converteDataparaAgora
import java.time.LocalDate

class pesagemActivity : AppCompatActivity() {

    lateinit var tvDataPesagem: TextView
    lateinit var buttonRegistrarPeso: Button
    lateinit var editNovoPeso: EditText
    lateinit var spinnerAtividades: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesagem)

        tvDataPesagem =findViewById(R.id.tv_data_pesagem)

        tvDataPesagem.text = converteDataparaAgora(LocalDate.now())

        buttonRegistrarPeso = findViewById(R.id.button_registrar_peso)
        editNovoPeso = findViewById(R.id.edit_novo_peso)
        spinnerAtividades = findViewById(R.id.spinner)

        buttonRegistrarPeso.setOnClickListener {
            gravarPeso()
        }
    }
    private fun gravarPeso(){
        val arquivo = getSharedPreferences("usuario", MODE_PRIVATE)
        val editor = arquivo.edit()
        val peso = arquivo.getString("peso", "")
        val dataPesagem = arquivo.getString("data_pesagem", "")

        editor.putString("data_pesagem", "$dataPesagem;${LocalDate.now()}")
        editor.putString("peso", "$peso;${editNovoPeso.text}")
        editor.putInt("nivel_atividade", spinnerAtividades.selectedItemPosition)

        editor.commit()
    }
}