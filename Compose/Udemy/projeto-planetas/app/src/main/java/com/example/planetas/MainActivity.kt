package com.example.planetas

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
import com.example.planetas.model.Planet
import com.example.planetas.screens.DetailsScreen
import com.example.planetas.screens.HomeScreen
import com.example.planetas.ui.theme.PlanetasTheme

class MainActivity : ComponentActivity() {

    companion object {
        private const val HOME = "home"
        const val DETAILS = "details"
        const val PLANET_KEY = "planet_key"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            PlanetasTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    NavigationComponent(navController)
                }
            }
        }
    }

    @Composable
    private fun NavigationComponent(navController: NavHostController) {
        NavHost(navController = navController, startDestination = HOME) {
            composable(HOME) { HomeScreen(navController) }
            composable(DETAILS) {
                val planet = navController
                    .previousBackStackEntry
                    ?.arguments
                    ?.getParcelable<Planet>(PLANET_KEY)
                planet?.let {
                    DetailsScreen(it, navController)
                }
            }
        }
    }
}
