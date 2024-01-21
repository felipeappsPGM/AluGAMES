package br.com.alura.alugames.principal

import br.com.alura.alugames.modelo.Gamer

fun main(){
    val gamer1 = Gamer("felipe", "felipe@felipe.com")
    println(gamer1)

    val gamer2 = Gamer(
        "Jenin",
        "jeni@jeni.com",
        "19/19/1992",
        "jeniinn")
    println(gamer2)

    gamer1.let{
        it.dataNascimento = "1/1/2000"
        it.usuario = "felipeskywalker"

    }.also {
        gamer1.idInterno
    }

    gamer1.usuario = "Jake"

    println(gamer1)
}