package ru.kovsh.surftesttask.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.kovsh.surftesttask.entities.Cocktail
import ru.kovsh.surftesttask.entities.CocktailEditStates
import ru.kovsh.surftesttask.model.room.CocktailDao
import ru.kovsh.surftesttask.model.room.IngredientDao
import javax.inject.Inject

@HiltViewModel
class CocktailsViewModel @Inject constructor(
    private val cocktailDao: CocktailDao,
    private val ingredientDao: IngredientDao
) : ViewModel() {
    private val _cocktails = MutableStateFlow(listOf<Cocktail>())
    val cocktails: StateFlow<List<Cocktail>> = _cocktails.asStateFlow()

    init {
        viewModelScope.launch {
            _cocktails.value = cocktailDao.getAllCocktails()
        }
    }

    suspend fun isCocktailsExists(): Int {
        return cocktailDao.getAllCocktails().size
    }
}
