package ru.kovsh.surftesttask.navigation

import android.util.Log
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import ru.kovsh.surftesttask.entities.Cocktail
import ru.kovsh.surftesttask.ui.cocktailEdit.EditCocktailScreen
import ru.kovsh.surftesttask.viewModels.CocktailEditViewModel


private const val COCKTAIL_ID = "cocktailID"

fun NavGraphBuilder.cocktailEdit(
    onSave : () -> Unit,
    onBackClicked: () -> Unit,
) {
    composable(
        route = "CocktailEdit/?id={$COCKTAIL_ID}",
        arguments = listOf(
            navArgument(COCKTAIL_ID) {
                type = NavType.StringType
                defaultValue = ""
                nullable = true
            }
        )
    )
    {NavBackStackEntry ->
        val cocktailId = NavBackStackEntry.arguments?.getInt(COCKTAIL_ID)
        val cocktailEditViewModel: CocktailEditViewModel = hiltViewModel()
        if (cocktailId != null && cocktailId != -1 && cocktailId != 0)
            LaunchedEffect(Unit) {
                Log.i("cocktailEdit", "cocktailId = $cocktailId")
                cocktailEditViewModel.updateWholeCocktail(cocktailId)
            }
        EditCocktailScreen(
            onSave = onSave,
            onBackClicked = onBackClicked,
            viewModel = cocktailEditViewModel,
        )
    }
}