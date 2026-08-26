package com.example.anatomiamecanica

import androidx.lifecycle.ViewModel
import com.example.anatomiamecanica.data.PecaMecanica
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class PecaViewModel : ViewModel() {

    private val _listaPecas = MutableStateFlow<List<PecaMecanica>>(emptyList())
    val listaPecas: StateFlow<List<PecaMecanica>> = _listaPecas

    init {
        // Inicializa com as peças padrão do seu tema
        popularBancoComPecasPadrao()
    }

    fun adicionarPeca(peca: PecaMecanica) {
        val novaPeca = peca.copy(id = System.currentTimeMillis().toString())
        _listaPecas.value = _listaPecas.value + novaPeca
    }

    fun atualizarPeca(peca: PecaMecanica) {
        _listaPecas.value = _listaPecas.value.map { item ->
            if (item.id == peca.id) peca else item
        }
    }

    fun excluirPeca(id: String) {
        _listaPecas.value = _listaPecas.value.filter { it.id != id }
    }

    fun popularBancoComPecasPadrao() {
        val pecasPadrao = listOf(
            PecaMecanica(
                id = "1",
                nome = "Engrenagem Helicoidal Dupla",
                categoria = "Engrenagens",
                descricaoTecnica = "Transmissão suave de alto torque com ruído reduzido.",
                quantidadeEstoque = 15,
                possuiEmEstoque = true,
                especificacao = "Aço Forjado 8620, Módulo 4.5"
            ),
            PecaMecanica(
                id = "2",
                nome = "Engrenagem Cônica Hipóide",
                categoria = "Engrenagens",
                descricaoTecnica = "Utilizada em diferenciais automotivos para eixos desalinhados.",
                quantidadeEstoque = 8,
                possuiEmEstoque = true,
                especificacao = "Liga de Níquel-Cromo, Ângulo 45°"
            ),
            PecaMecanica(
                id = "3",
                nome = "Pistão Forjado V8",
                categoria = "Motores de Combustão",
                descricaoTecnica = "Pistão de alta performance com saia curta para alívio de peso.",
                quantidadeEstoque = 32,
                possuiEmEstoque = true,
                especificacao = "Alumínio 2618, Diâmetro 85mm"
            ),
            PecaMecanica(
                id = "4",
                nome = "Virabrequim Monobloco",
                categoria = "Motores de Combustão",
                descricaoTecnica = "Eixo de manivelas balanceado para motores de alta rotação.",
                quantidadeEstoque = 4,
                possuiEmEstoque = true,
                especificacao = "Aço Billet 4340, Curso 88mm"
            ),
            PecaMecanica(
                id = "5",
                nome = "Rotor de Turbina a Gás",
                categoria = "Turbinas",
                descricaoTecnica = "Pás aerodinâmicas para suportar altíssimas temperaturas de exaustão.",
                quantidadeEstoque = 2,
                possuiEmEstoque = true,
                especificacao = "Superliga Inconel 718, 12.000 RPM"
            ),
            PecaMecanica(
                id = "6",
                nome = "Eixo de Turbocompressor",
                categoria = "Turbinas",
                descricaoTecnica = "Conjunto rotativo para turbinas automotivas de alta rotação.",
                quantidadeEstoque = 6,
                possuiEmEstoque = true,
                especificacao = "Mancal flutuante de cerâmica"
            ),
            PecaMecanica(
                id = "7",
                nome = "Válvula Esférica Bi-Partida",
                categoria = "Peças Industriais Complexas",
                descricaoTecnica = "Controle de fluxo de alta pressão com vedação em PTFE.",
                quantidadeEstoque = 12,
                possuiEmEstoque = true,
                especificacao = "Aço Inox 316, Classe 300 PSI"
            ),
            PecaMecanica(
                id = "8",
                nome = "Acoplamento Elástico de Cruzeta",
                categoria = "Peças Industriais Complexas",
                descricaoTecnica = "Absorve choques mecânicos e desalinhamentos em eixos industriais.",
                quantidadeEstoque = 20,
                possuiEmEstoque = true,
                especificacao = "Poliuretano, Torque Max 1200Nm"
            )
        )
        _listaPecas.value = pecasPadrao
    }
}