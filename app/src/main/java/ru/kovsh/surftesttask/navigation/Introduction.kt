package ru.kovsh.surftesttask.navigation

import android.util.Log
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ru.kovsh.surftesttask.ui.introduction.IntroductionScreen
import ru.kovsh.surftesttask.viewModels.CocktailsViewModel

fun NavGraphBuilder.introduction(
    onCocktailCreated : () -> Unit,
    onIntroductionSkip : () -> Unit,
) {
    composable(route = "Introduction")
    {
        val cocktailsViewModel: CocktailsViewModel = hiltViewModel()
        val cocktailsExists = remember { mutableStateOf(0) }

        LaunchedEffect(Unit) {
            cocktailsExists.value = cocktailsViewModel.isCocktailsExists()
        }
        if (cocktailsExists.value == 0) {
            IntroductionScreen(
                onFirstCocktailCreate = {
                    onCocktailCreated()
                }
            )
        } else {
            LaunchedEffect(Unit)
            {
                onIntroductionSkip()
            }
        }
    }
}
