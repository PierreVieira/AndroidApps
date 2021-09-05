package com.example.crud

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.crud.ui.screens.HomeScreen
import com.example.crud.ui.screens.register.RegisterScreen
import com.example.crud.ui.theme.CRUDTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CRUDTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    NavigationComponent(rememberNavController())
                }
            }
        }
    }

    @Composable
    private fun NavigationComponent(navController: NavHostController) {
        NavHost(navController = navController, startDestination = Routes.HOME) {
            composable(Routes.HOME) { HomeScreen { navController.navigate(Routes.REGISTER) } }
            composable(Routes.REGISTER) { RegisterScreen { navController.popBackStack() } }
        }
    }
}

