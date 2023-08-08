package ru.kovsh.surftesttask.model.room

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.kovsh.surftesttask.entities.Cocktail
import ru.kovsh.surftesttask.entities.Ingredient

@Database(entities = [Cocktail::class, Ingredient::class], version = 1)
abstract class MyCocktailsDatabase: RoomDatabase() {
    abstract fun cocktailDao(): CocktailDao
    abstract fun ingredientDao(): IngredientDao
}