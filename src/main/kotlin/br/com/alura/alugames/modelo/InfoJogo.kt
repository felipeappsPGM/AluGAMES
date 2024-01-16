package org.example.br.com.alura.alugames.modelo

data class InfoJogo(val info: InfoApiClass) {
    override fun toString(): String {
        return info.toString()
    }
}