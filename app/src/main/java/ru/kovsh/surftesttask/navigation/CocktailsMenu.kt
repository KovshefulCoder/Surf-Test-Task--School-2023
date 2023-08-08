package ru.kovsh.surftesttask.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ru.kovsh.surftesttask.entities.Cocktail
import ru.kovsh.surftesttask.ui.introduction.IntroductionScreen
import ru.kovsh.surftesttask.ui.mainScreen.MainScreen
import ru.kovsh.surftesttask.viewModels.CocktailEditViewModel
import ru.kovsh.surftesttask.viewModels.CocktailsViewModel

fun NavGraphBuilder.myCocktails(
    onCocktailEdit : (Cocktail) -> Unit,
) {
    composable(route = "MyCocktails")
    {
        val cocktailsViewModel: CocktailsViewModel = hiltViewModel()
        MainScreen(
            onCocktailEditClicked = onCocktailEdit,
            viewModel = cocktailsViewModel
        )
    }
}
