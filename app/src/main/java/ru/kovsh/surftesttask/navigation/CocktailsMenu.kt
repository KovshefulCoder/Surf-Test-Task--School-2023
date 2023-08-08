package ru.kovsh.surftesttask.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ru.kovsh.surftesttask.entities.Cocktail
import ru.kovsh.surftesttask.ui.introduction.IntroductionScreen
import ru.kovsh.surftesttask.ui.mainScreen.MainScreen

fun NavGraphBuilder.myCocktails(
    onCocktailCreate : () -> Unit,
) {
    composable(route = "MyCocktails")
    {
        MainScreen(
        )
    }
}
