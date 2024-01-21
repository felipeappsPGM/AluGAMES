package org.example.br.com.alura.alugames.principal

import br.com.alura.alugames.modelo.Gamer
import br.com.alura.alugames.servicos.ConsunoApi
import br.com.alura.alugames.utilitario.transformarEmIdade
import org.example.br.com.alura.alugames.modelo.Jogo
import java.util.*


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main(array: Array<String>) {
    val leitura =  Scanner(System.`in`)
    val gamer = Gamer.criarGame(leitura)
    println("Cadastro concluido com sucesso")
    println(Gamer)
    println("Idade do gamer " + gamer.dataNascimento?.transformarEmIdade())
    do {
        println("Digite um código de jogo para buscar")
        val buscar = leitura.nextLine()

        val buscaApi = ConsunoApi()
        val informacaoJogo = buscaApi.buscaJogo(buscar)


        var meuJogo: Jogo? = null

        val resultado = runCatching {
            meuJogo = Jogo(informacaoJogo.info.title, informacaoJogo.info.thumb)
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
            gamer.jogosBuscadors.add(meuJogo)
        }
        println("Dejesa buscar novo jogo? S/N")
        val resposta = leitura.nextLine()
    }while (resposta.equals("s", true))

    println("Jogos buscados: ")
    println(gamer.jogosBuscadors)

    println("Jogos ordenados por titulo")
    gamer.jogosBuscadors.sortBy {
        it?.titulo
    }

    gamer.jogosBuscadors.forEach {
        println("Titulo: " + it?.titulo)
    }

    val jogosFiltrados = gamer.jogosBuscadors.filter {
        it?.titulo?.contains("batman", true) ?: false
    }
    println("jogos filtrados")
    println(jogosFiltrados)

    println("Deseja excluir algum item da lista original: S/N")
    val opcao = leitura.nextLine()
    if(opcao.equals("s", true)){
        println(gamer.jogosBuscadors)
        println("Informe a posição do jogo que deseja excluir: ")
        val posicao = leitura.nextInt()
        gamer.jogosBuscadors.removeAt(posicao)
    }

    println("Lista atualizada ${gamer.jogosBuscadors}")

    

    println("sucesso em buscar")
}