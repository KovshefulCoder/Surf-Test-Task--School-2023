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
import ru.kovsh.surftesttask.entities.Ingredient
import ru.kovsh.surftesttask.model.room.CocktailDao
import ru.kovsh.surftesttask.model.room.IngredientDao
import javax.inject.Inject

@HiltViewModel
class CocktailEditViewModel @Inject constructor(
    private val cocktailDao: CocktailDao,
    private val ingredientDao: IngredientDao
) : ViewModel() {
    private val _state = MutableStateFlow(CocktailEditStates())
    val state: StateFlow<CocktailEditStates> = _state.asStateFlow()

    fun addIngredient() {

    }

    fun saveCocktail() {
        viewModelScope.launch {
            cocktailDao.insert(
                Cocktail(
                    title = _state.value.title,
                    description = _state.value.description,
                    recipe = _state.value.recipe
                )
            )
        }
    }

    fun updateWholeCocktail(cocktailID: Int) {
        val ingredients = listOf<String>() // replace to query to database TODO()
        viewModelScope.launch {
            val cocktail = cocktailDao.getCocktailById(cocktailID)
            _state.update { value ->
                value.copy(
                    title = cocktail.title,
                    description = cocktail.description,
                    recipe = cocktail.recipe,
                    ingredients = ingredients,
                    isValidDataInput = true
                )
            }
        }
    }

    fun onChangeDataValidityStatus(status: Boolean) {
        viewModelScope.launch {
            _state.update { value ->
                value.copy(
                    isValidDataInput = status
                )
            }
        }
    }
    fun onTitleChange(newTitle: String) {
        viewModelScope.launch {
            _state.update { value ->
                value.copy(
                    title = newTitle
                )
            }
        }
    }

    fun onDescriptionChange(newDescription: String) {
        viewModelScope.launch {
            _state.update { value ->
                value.copy(
                    description = newDescription
                )
            }
        }
    }

    fun onRecipeChange(newRecipe: String) {
        viewModelScope.launch {
            _state.update { value ->
                value.copy(
                    recipe = newRecipe
                )
            }
        }
    }

}