package br.com.alura.alugames.principal

import br.com.alura.alugames.modelo.InfoGameJson
import br.com.alura.alugames.servicos.ConsunoApi

fun main(){
    val consumo = ConsunoApi()
    val listaGamers = consumo.buscaGames()
    println(listaGamers)
}

open class Child(){
    val x = 5
}

class filho: Child() {
    fun myfun(){
        println(x)
    }
}