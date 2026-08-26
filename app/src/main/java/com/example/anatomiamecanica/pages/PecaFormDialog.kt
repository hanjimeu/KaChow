package com.example.anatomiamecanica.pages

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.anatomiamecanica.data.PecaMecanica

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PecaFormDialog(
    pecaParaEditar: PecaMecanica? = null,
    onDismiss: () -> Unit,
    onSalvar: (PecaMecanica) -> Unit
) {
    val categoriasDisponiveis = listOf(
        "Engrenagens",
        "Motores de Combustão",
        "Turbinas",
        "Peças Industriais Complexas"
    )

    var nome by remember { mutableStateOf(pecaParaEditar?.nome ?: "") }
    var categoria by remember { mutableStateOf(pecaParaEditar?.categoria ?: categoriasDisponiveis.first()) }
    var descricaoTecnica by remember { mutableStateOf(pecaParaEditar?.descricaoTecnica ?: "") }
    var especificacao by remember { mutableStateOf(pecaParaEditar?.especificacao ?: "") }
    var quantidade by remember { mutableStateOf(pecaParaEditar?.quantidadeEstoque?.toString() ?: "1") }

    var dropdownExpanded by remember { mutableStateOf(false) }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(if (pecaParaEditar == null) "Nova Peça" else "Editar Peça") },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                OutlinedTextField(
                    value = nome,
                    onValueChange = { nome = it },
                    label = { Text("Nome da Peça") },
                    modifier = Modifier.fillMaxWidth()
                )

                ExposedDropdownMenuBox(
                    expanded = dropdownExpanded,
                    onExpandedChange = { dropdownExpanded = !dropdownExpanded }
                ) {
                    OutlinedTextField(
                        value = categoria,
                        onValueChange = {},
                        readOnly = true,
                        label = { Text("Categoria") },
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = dropdownExpanded) },
                        modifier = Modifier
                            .menuAnchor()
                            .fillMaxWidth()
                    )
                    ExposedDropdownMenu(
                        expanded = dropdownExpanded,
                        onDismissRequest = { dropdownExpanded = false }
                    ) {
                        categoriasDisponiveis.forEach { item ->
                            DropdownMenuItem(
                                text = { Text(item) },
                                onClick = {
                                    categoria = item
                                    dropdownExpanded = false
                                }
                            )
                        }
                    }
                }

                OutlinedTextField(
                    value = especificacao,
                    onValueChange = { especificacao = it },
                    label = { Text("Especificação Técnica") },
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = descricaoTecnica,
                    onValueChange = { descricaoTecnica = it },
                    label = { Text("Descrição") },
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = quantidade,
                    onValueChange = { quantidade = it },
                    label = { Text("Quantidade no Estoque") },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    val qtdInt = quantidade.toIntOrNull() ?: 0
                    val novaPeca = pecaParaEditar?.copy(
                        nome = nome,
                        categoria = categoria,
                        descricaoTecnica = descricaoTecnica,
                        especificacao = especificacao,
                        quantidadeEstoque = qtdInt,
                        possuiEmEstoque = qtdInt > 0
                    ) ?: PecaMecanica(
                        nome = nome,
                        categoria = categoria,
                        descricaoTecnica = descricaoTecnica,
                        especificacao = especificacao,
                        quantidadeEstoque = qtdInt,
                        possuiEmEstoque = qtdInt > 0
                    )
                    onSalvar(novaPeca)
                }
            ) {
                Text("Salvar")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancelar")
            }
        }
    )
}