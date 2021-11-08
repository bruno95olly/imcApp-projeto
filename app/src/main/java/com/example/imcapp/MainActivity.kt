package com.example.imcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()

        val buttonEntrar = findViewById<Button>(R.id.button_entrar)
        val btnCadastrar = findViewById<Button>(R.id.button_cadastrar)


        buttonEntrar.setOnClickListener{

            val arquivo = getSharedPreferences("usuario", MODE_PRIVATE)
            val emailView = arquivo.getString("email", "")
            val senhaView = arquivo.getString("senha", "")

            val emailEdit = findViewById<EditText>(R.id.edit_email_login)
            val senhaEdit = findViewById<EditText>(R.id.edit_senha_login)

            if(emailView == emailEdit.text.toString()  &&  senhaView == senhaEdit.text.toString()){
                val abrirDashboard = Intent (this, DashboardActivity::class.java)
                startActivity(abrirDashboard)
            }
            else{
                Toast.makeText(this,"usuário ou senha incorreta!", Toast.LENGTH_SHORT).show()
            }



        }
        btnCadastrar.setOnClickListener{
            val abrirCadastro = Intent(this, activity_novo_usuario::class.java)
            startActivity(abrirCadastro)
        }
    }


}