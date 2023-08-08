package ru.kovsh.surftesttask.ui.cocktailEdit.entities

data class CocktailEditStates(
    val title: String = "",
    val description: String = "",
    val recipe: String = "",
    val ingredients: List<String> = listOf(),
    val isValidDataInput: Boolean = true
)
