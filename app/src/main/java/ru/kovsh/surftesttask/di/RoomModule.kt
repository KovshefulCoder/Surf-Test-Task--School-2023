package ru.kovsh.surftesttask.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.kovsh.surftesttask.model.room.CocktailDao
import ru.kovsh.surftesttask.model.room.IngredientDao
import ru.kovsh.surftesttask.model.room.MyCocktailsDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    @Provides
    @Singleton
    fun provideRoomDatabase(@ApplicationContext context: Context): MyCocktailsDatabase {
        return Room.databaseBuilder(
            context,
            MyCocktailsDatabase::class.java,
            "database"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun provideCocktailsDao(database: MyCocktailsDatabase): CocktailDao {
        return database.cocktailDao()
    }

    @Provides
    @Singleton
    fun provideIngredientsDao(database: MyCocktailsDatabase): IngredientDao {
        return database.ingredientDao()
    }


}