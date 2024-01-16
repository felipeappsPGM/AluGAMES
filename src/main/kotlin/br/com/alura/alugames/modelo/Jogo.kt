package org.example.br.com.alura.alugames.modelo

data class Jogo(var titulo: String, var capa: String) {
    var descricao: String? = null
    override fun toString(): String {
        return "Jogo(titulo='$titulo', capa='$capa', descricao='$descricao')"
    }
}