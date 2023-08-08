package ru.kovsh.surftesttask

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import dagger.hilt.android.AndroidEntryPoint
import ru.kovsh.surftesttask.navigation.cocktailEdit
import ru.kovsh.surftesttask.navigation.createFirstCocktail
import ru.kovsh.surftesttask.navigation.introduction
import ru.kovsh.surftesttask.navigation.myCocktails
import ru.kovsh.surftesttask.ui.theme.Backgroud
import ru.kovsh.surftesttask.ui.theme.SurfTestTaskTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SurfTestTaskTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Backgroud
                ) {
                    CocktailBar()
                }
            }
        }
    }
}

@Composable
fun CocktailBar() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "FirstCocktail"
    ) {
        navigation(
            route = "FirstCocktail",
            startDestination = "Introduction"
        ) {
            introduction(
                onCocktailCreate = {
                    Log.i("navigation", "onCocktailCreate")
                    navController.navigate("FirstCocktailCreate")
                }
            )
            createFirstCocktail(
                onCocktailCreated = {
                    navController.navigate("MainApp", navOptions {
                        popUpTo("FirstCocktail") {
                            inclusive = true
                        }
                    })
                },
                onBackClicked = { navController.popBackStack() }
            )
        }
        navigation(
            route = "MainApp",
            startDestination = "MyCocktails"
        ) {
            myCocktails(
                onCocktailEdit = {
                    navController.navigate("CocktailEdit")
                }
            )
            cocktailEdit(
                onSave = {
                    navController.navigate("MyCocktails")
                },
                onBackClicked = { navController.popBackStack() }
            )

        }
    }
}