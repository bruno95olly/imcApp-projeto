package com.example.imcapp.utils

import java.time.LocalDate
import java.time.Period
import android.util.Log
import java.time.format.DateTimeFormatter

fun calcularIdade (dataNascimento : String): Int
{
    //Obter a data atual

    val hoje = LocalDate.now()

    // converter a dataNascimento que é String em LocalDate

    val data = dataNascimento.split("-")

    val nascimento = LocalDate.of(
        data.get(2).toInt(),
        data.get(1).toInt(),
        data.get(0).toInt())

    // calcular o intervalo entre a data atual(hoje) e a data de nascimento

    val idade = Period.between(nascimento, hoje).years

    Log.i("xpto", idade.toString())

    return  0
}

fun convertStringToLocalDate(brazilDate: String) : LocalDate {

    val dateFormatterFromBrazil = DateTimeFormatter
        .ofPattern("dd/MM/yyyy")

    val localDateFormat = LocalDate
        .parse(brazilDate, dateFormatterFromBrazil)

    return localDateFormat

}
fun converteDataparaAgora(data: LocalDate): String{
    val formatoBrasil = DateTimeFormatter.ofPattern("dd-MM-yyyy")
    val dataBrasil = data.format(formatoBrasil)

    return dataBrasil.toString();

}