package com.example.anatomiamecanica.pages

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.anatomiamecanica.data.PecaMecanica

@Composable
fun PecaItemCard(
    peca: PecaMecanica,
    onEditar: () -> Unit,
    onExcluir: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = peca.nome,
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White
                )
                Text(
                    text = "Categoria: ${peca.categoria}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.secondary
                )
                if (peca.especificacao.isNotEmpty()) {
                    Text(
                        text = "Espec: ${peca.especificacao}",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Gray
                    )
                }
                Text(
                    text = "Estoque: ${peca.quantidadeEstoque} uni.",
                    style = MaterialTheme.typography.bodySmall,
                    color = if (peca.quantidadeEstoque > 0) Color.Green else Color.Red
                )
            }

            Row {
                IconButton(onClick = onEditar) {
                    Icon(imageVector = Icons.Default.Edit, contentDescription = "Editar Peça", tint = Color.Yellow)
                }
                IconButton(onClick = onExcluir) {
                    Icon(imageVector = Icons.Default.Delete, contentDescription = "Excluir Peça", tint = Color.Red)
                }
            }
        }
    }
}