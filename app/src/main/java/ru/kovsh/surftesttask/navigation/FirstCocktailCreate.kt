package ru.kovsh.surftesttask.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ru.kovsh.surftesttask.ui.cocktailEdit.EditCocktailScreen
import ru.kovsh.surftesttask.viewModels.CocktailEditViewModel


fun NavGraphBuilder.createFirstCocktail(
    onCocktailCreated : () -> Unit
) {
    composable(route = "FirstCocktailCreate")
    {
        val cocktailEditViewModel: CocktailEditViewModel = hiltViewModel()
        EditCocktailScreen(
            onSave = onCocktailCreated,
            viewModel = cocktailEditViewModel
        )
    }
}
