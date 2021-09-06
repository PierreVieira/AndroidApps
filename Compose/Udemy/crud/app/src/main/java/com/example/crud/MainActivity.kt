package com.example.crud

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.crud.ui.screens.details.DetailScreen
import com.example.crud.ui.screens.home.HomeScreen
import com.example.crud.ui.screens.register.RegisterScreen
import com.example.crud.ui.theme.CRUDTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    companion object {
        const val HOME = "home"
        const val REGISTER = "register"
        const val DETAILS_BASE_ROUTE = "details/"
        const val CITY_ID_KEY = "cityId"
    }

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
        NavHost(navController = navController, startDestination = HOME) {
            composable(HOME) {
                HomeScreen(
                    navigateToDetailsAction = { navController.navigate(REGISTER) },
                    openCardDetailsAction = { cityId ->
                        navController.navigate("$DETAILS_BASE_ROUTE${cityId}")
                    }
                )
            }
            composable(REGISTER) { RegisterScreen { navController.popBackStack() } }
            composable(
                route = "$DETAILS_BASE_ROUTE{$CITY_ID_KEY}",
                arguments = listOf(navArgument(CITY_ID_KEY) { type = NavType.IntType })
            ) { backStackEntry ->
                val cityId = backStackEntry.arguments?.getInt(CITY_ID_KEY)
                cityId?.let {
                    DetailScreen(cityId = it, popNavigation = { navController.popBackStack() })
                }
            }
        }
    }
}

