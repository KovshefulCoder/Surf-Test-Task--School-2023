package ru.kovsh.surftesttask.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ru.kovsh.surftesttask.entities.Cocktail
import ru.kovsh.surftesttask.ui.cocktailEdit.EditCocktailScreen
import ru.kovsh.surftesttask.viewModels.CocktailEditViewModel

fun NavGraphBuilder.cocktailEdit(
    onSave : () -> Unit,
    onBackClicked: () -> Unit,
    cocktail: Cocktail = Cocktail(),
) {
    composable(route = "CocktailEdit")
    {
        val cocktailEditViewModel: CocktailEditViewModel = hiltViewModel()
        if (cocktail == Cocktail())
            cocktailEditViewModel.updateWholeCocktail(Cocktail())
        EditCocktailScreen(
            onSave = onSave,
            onBackClicked = onBackClicked,
            viewModel = cocktailEditViewModel,
        )
    }
}