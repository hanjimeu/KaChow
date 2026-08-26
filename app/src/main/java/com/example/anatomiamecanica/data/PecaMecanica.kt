package com.example.anatomiamecanica.data

data class PecaMecanica(
    var id: String = "",
    val nome: String = "",
    val categoria: String = "",
    val descricaoTecnica: String = "",
    val quantidadeEstoque: Int = 0,
    val possuiEmEstoque: Boolean = true,
    val especificacao: String = ""
)