package ru.kovsh.surftesttask.viewModels

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
import javax.inject.Inject

@HiltViewModel
class CocktailEditViewModel @Inject constructor(
) : ViewModel() {
    private val _state = MutableStateFlow(CocktailEditStates())
    val state: StateFlow<CocktailEditStates> = _state.asStateFlow()

    fun addIngredient() {

    }

    fun updateWholeCocktail(cocktail: Cocktail) {
        viewModelScope.launch {
            _state.update { value ->
                value.copy(
                    title = cocktail.title,
                    description = cocktail.description,
                    recipe = cocktail.recipe,
                    ingredients = cocktail.ingredients,
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