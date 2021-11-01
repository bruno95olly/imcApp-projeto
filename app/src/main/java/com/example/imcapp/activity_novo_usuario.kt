package com.example.imcapp

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.RadioButton
import java.util.*

class activity_novo_usuario : AppCompatActivity() {

    lateinit var editNome: EditText
    lateinit var editProfissao: EditText
    lateinit var editAltura: EditText
    lateinit var editNascimento: EditText
    lateinit var editMasculino: RadioButton
    lateinit var editFeminino: RadioButton
    lateinit var editEmail: EditText
    lateinit var editSenha: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novo_usuario)

        editEmail = findViewById(R.id.edit_email)
        editSenha = findViewById(R.id.edit_senha)
        editNome = findViewById(R.id.edit_nome)
        editProfissao = findViewById(R.id.edit_profissao)
        editAltura = findViewById(R.id.edit_altura)
        editNascimento = findViewById(R.id.edit_nascimento)
        editMasculino = findViewById(R.id.rdo_masculino)
        editFeminino = findViewById(R.id.rdo_feminino)

        supportActionBar!!.title = "Nova Conta"

        // Criar um calendario
        //***Obter a data atual (hoje)

        val calendario = Calendar.getInstance()
        val dia = calendario.get(Calendar.DAY_OF_MONTH)
        val mes = calendario.get(Calendar.MONTH)
        val ano = calendario.get(Calendar.YEAR)

        // Colocar um lisetener de click no editText data de nascimento
        //para abrir o calendario
        editNascimento.setOnClickListener {
            criarDatePicker(ano, mes, dia)
        }
    }

    private fun criarDatePicker(ano: Int, mes: Int, dia: Int) {
        val datePicker = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, _ano, _mes, _dia ->

            var mesReal = _mes + 1

            var diaString = "$_dia"
            var mesString = "$mesReal"

            if (mesReal < 10) {
                mesString = "0$mesReal"
            }
            if (_dia < 10) {
                diaString = "0$_dia"

            }

            Log.i("xxx", "$diaString/$mesString/$_ano")

            editNascimento.setText("$diaString/$mesString/$_ano")
        }, ano, mes, dia)

        datePicker.show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_cadastro, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(validarCampos()){

        }
        else{

        }

        return true
    }

    private fun validarCampos() : Boolean{
        var valido = true

        if(editEmail.text.isEmpty()){
           editEmail.error = "Email é obrigatório!"
            valido = false
        }

        if(editSenha.text.isEmpty()){
            editSenha.error = "Senha é obrigatório"
            valido = false
        }

        return valido
    }

}