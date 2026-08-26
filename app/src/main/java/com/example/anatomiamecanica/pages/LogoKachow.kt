package com.example.anatomiamecanica.pages

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FlashOn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.anatomiamecanica.ui.theme.AmareloRaioMcQueen
import com.example.anatomiamecanica.ui.theme.VermelhoMcQueen

@Composable
fun LogoKachow(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "KA",
            fontSize = 32.sp,
            fontWeight = FontWeight.Black,
            color = VermelhoMcQueen
        )
        Icon(
            imageVector = Icons.Default.FlashOn,
            contentDescription = "Raio Ka-Chow",
            tint = AmareloRaioMcQueen,
            modifier = Modifier.size(36.dp)
        )
        Text(
            text = "CHOW",
            fontSize = 32.sp,
            fontWeight = FontWeight.Black,
            color = VermelhoMcQueen
        )
    }
}