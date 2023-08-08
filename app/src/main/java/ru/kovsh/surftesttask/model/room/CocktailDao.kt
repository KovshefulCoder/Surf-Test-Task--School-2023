package ru.kovsh.surftesttask.model.room

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import ru.kovsh.surftesttask.entities.Cocktail

@Dao
interface CocktailDao {
    @Query("SELECT * FROM cocktails")
    suspend fun getAllCocktails(): List<Cocktail>

    @Upsert
    suspend fun insert(cocktail: Cocktail)

    @Query("SELECT * FROM cocktails WHERE id = :cocktailID")
    suspend fun getCocktailById(cocktailID: Int): Cocktail
}