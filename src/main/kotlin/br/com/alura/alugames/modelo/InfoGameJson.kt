package br.com.alura.alugames.modelo

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.example.br.com.alura.alugames.modelo.InfoJogo
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

data class InfoGameJson(
    val nome: String, val email: String, val dataNascimento: String, val usuario: String
) {

}