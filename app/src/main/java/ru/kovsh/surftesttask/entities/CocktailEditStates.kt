package ru.kovsh.surftesttask.entities

data class CocktailEditStates(
    val title: String = "",
    val description: String = "",
    val recipe: String = "",
    val ingredients: List<String> = listOf(),
    val isValidDataInput: Boolean = true
)
