package org.example.br.com.alura.alugames.principal

import com.google.gson.Gson
import org.example.br.com.alura.alugames.modelo.InfoJogo
import org.example.br.com.alura.alugames.modelo.Jogo
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers
import java.util.Scanner


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main(array: Array<String>) {
    val leitura =  Scanner(System.`in`)
    println("Digite um código de jogo para buscar")
    val buscar = leitura.nextLine()


    val client: HttpClient? = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder()
        .uri(URI.create("https://www.cheapshark.com/api/1.0/games?id=$buscar"))
        .build()

    val response = client?.send(request, BodyHandlers.ofString())
    val json = response?.body()

    val gson = Gson()
    val meuInfoJogo = gson.fromJson(json, InfoJogo::class.java)


    var meuJogo: Jogo? = null

    val resultado = runCatching {
        meuJogo = Jogo(meuInfoJogo.info.title, meuInfoJogo.info.thumb)
    }
    resultado.onFailure {
        println("Jogo inexistente, tente outro ID")
    }

    resultado.onSuccess {
        println("Deseja inserir uma descrição personalizada S/N")
        val opcao = leitura.nextLine()
        if(opcao.equals("s", true)){
            println("Insira a descricao personalizada para o jogo: ")
            val descricaoPersonalizada = leitura.nextLine()
            meuJogo?.descricao = descricaoPersonalizada
        }else{
            meuJogo?.descricao = meuJogo?.titulo
        }
        println(meuJogo)
    }

    resultado.onSuccess {
        println("sucesso em buscar")
    }
}