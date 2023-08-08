package ru.kovsh.surftesttask.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ru.kovsh.surftesttask.ui.introduction.IntroductionScreen

fun NavGraphBuilder.myCocktails(
    onCocktailCreate : () -> Unit,
    onCocktailClick : () -> Unit
) {
    composable(route = "MyCocktails")
    {

    }
}
