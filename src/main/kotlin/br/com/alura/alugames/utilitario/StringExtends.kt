package br.com.alura.alugames.utilitario

import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

fun String.transformarEmIdade(): Int {
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    var idade = 0
    var dataNascimento = LocalDate.parse(this, formatter)
    var hoje = LocalDate.now()
    idade = Period.between(dataNascimento, hoje).years

    return idade
}