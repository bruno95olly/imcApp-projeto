package com.example.imcapp.utils

import android.util.Log
import java.time.LocalDate
import java.time.Period

fun calcularIdade(dataNascimento: String): Int{

    //obter a data atual
    val hoje = LocalDate.now()


    // Converter a dataNascimento que é string em localDate
    val dia = dataNascimento.subSequence(0, 2)

    Log.i("xpto",  dia.toString())


    val data = dataNascimento.split("-")


    Log.i("xpto", data.get(0))
    Log.i("xpto", data.get(1))
    Log.i("xpto", data.get(2))

    val nascimento = LocalDate.of(data.get(2).toInt(), data.get(1).toInt(), data.get(0).toInt())

    val idade = Period.between(nascimento, hoje).years

    Log.i("xpto", idade.toString())

    return 0
}