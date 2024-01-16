package br.com.alura.alugames.modelo

import kotlin.random.Random

data class Gamer(
    var nome: String,
    var email: String
){
    var dataNascimento: String? = null
    var usuario: String? = null
    private var idInterno: String? = null

    constructor(nome: String, email: String, dataNascimento: String, usuario: String):
            this(nome, email){
                this.dataNascimento = dataNascimento
                this.usuario = usuario
                criarIdIterno()
            }



    override fun toString(): String {
        return "Gamer(nome='$nome', email='$email', dataNascimento=$dataNascimento, usuario=$usuario, idInterno=$idInterno)"
    }


    fun criarIdIterno(){
        val numero = Random.nextInt(10000)
        val tag = String.format("%04d", numero)
        this.idInterno = "$usuario@$tag"
    }


}
