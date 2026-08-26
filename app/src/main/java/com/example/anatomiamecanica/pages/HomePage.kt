package com.example.anatomiamecanica.pages

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.anatomiamecanica.AuthViewModel
import com.example.anatomiamecanica.PecaViewModel
import com.example.anatomiamecanica.data.PecaMecanica

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(
    navController: NavController,
    authViewModel: AuthViewModel,
    pecaViewModel: PecaViewModel
) {
    val listaPecas by pecaViewModel.listaPecas.collectAsState()
    var mostrarDialogo by remember { mutableStateOf(false) }
    var pecaSelecionada by remember { mutableStateOf<PecaMecanica?>(null) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { LogoKachow() },
                actions = {
                    IconButton(onClick = {
                        authViewModel.signout()
                        navController.navigate("login")
                    }) {
                        Icon(imageVector = Icons.Default.ExitToApp, contentDescription = "Sair")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    pecaSelecionada = null
                    mostrarDialogo = true
                }
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Adicionar Peça")
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            if (listaPecas.isEmpty()) {
                Column(
                    modifier = Modifier.align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Nenhuma peça cadastrada.")
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = { pecaViewModel.popularBancoComPecasPadrao() }) {
                        Icon(imageVector = Icons.Default.Refresh, contentDescription = null)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Restaurar Peças Padrão")
                    }
                }
            } else {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(listaPecas) { peca ->
                        PecaItemCard(
                            peca = peca,
                            onEditar = {
                                pecaSelecionada = peca
                                mostrarDialogo = true
                            },
                            onExcluir = {
                                pecaViewModel.excluirPeca(peca.id)
                            }
                        )
                    }
                }
            }

            if (mostrarDialogo) {
                PecaFormDialog(
                    pecaParaEditar = pecaSelecionada,
                    onDismiss = { mostrarDialogo = false },
                    onSalvar = { peca ->
                        if (pecaSelecionada == null) {
                            pecaViewModel.adicionarPeca(peca)
                        } else {
                            pecaViewModel.atualizarPeca(peca)
                        }
                        mostrarDialogo = false
                    }
                )
            }
        }
    }
}