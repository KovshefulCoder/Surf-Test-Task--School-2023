package ru.kovsh.surftesttask.entities

data class Cocktail(
    val id: Int = 0,
    val title: String = "",
    val description: String = "",
    val recipe: String = "",
    val ingredients: List<String> = listOf(),
)
