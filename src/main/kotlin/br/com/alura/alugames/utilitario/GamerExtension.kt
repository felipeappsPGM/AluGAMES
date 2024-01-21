package br.com.alura.alugames.utilitario

import br.com.alura.alugames.modelo.Gamer
import br.com.alura.alugames.modelo.InfoGameJson

fun InfoGameJson.criaGamer(): Gamer{
    return Gamer(this.nome, this.email, this.email, this.dataNascimento)
}