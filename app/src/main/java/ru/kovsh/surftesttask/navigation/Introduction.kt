package ru.kovsh.surftesttask.navigation

import android.util.Log
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ru.kovsh.surftesttask.ui.introduction.IntroductionScreen

fun NavGraphBuilder.introduction(
    onCocktailCreate : () -> Unit
) {
    composable(route = "Introduction")
    {
        IntroductionScreen(
            onFirstCocktailCreate = {
                Log.i("navigation", "onCocktailCreate1")
                onCocktailCreate()
            }
        )
    }
}
