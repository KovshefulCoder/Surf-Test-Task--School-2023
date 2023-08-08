package ru.kovsh.surftesttask.model.room

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import ru.kovsh.surftesttask.entities.Ingredient

@Dao
interface IngredientDao {
    @Query("SELECT * FROM ingredient where cocktailId = :cocktail_id")
    suspend fun getIngredients(cocktail_id: Int): List<Ingredient>

    @Upsert
    suspend fun insertIngredients(ingredients: List<Ingredient>)
}