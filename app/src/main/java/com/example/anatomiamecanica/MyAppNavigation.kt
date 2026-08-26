package com.example.anatomiamecanica

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.anatomiamecanica.pages.HomePage
import com.example.anatomiamecanica.pages.LoginPage
import com.example.anatomiamecanica.pages.RecupSenhaPage
import com.example.anatomiamecanica.pages.SignupPage

@Composable
fun MyAppNavigation(
    modifier: Modifier = Modifier,
    authViewModel: AuthViewModel,
    pecaViewModel: PecaViewModel
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login",
        modifier = modifier
    ) {
        composable("login") {
            LoginPage(
                navController = navController,
                authViewModel = authViewModel
            )
        }
        composable("signup") {
            SignupPage(
                navController = navController,
                authViewModel = authViewModel
            )
        }
        composable("home") {
            HomePage(
                navController = navController,
                authViewModel = authViewModel,
                pecaViewModel = pecaViewModel
            )
        }
        composable("recupsenha") {
            RecupSenhaPage(
                navController = navController,
                authViewModel = authViewModel
            )
        }
    }
}