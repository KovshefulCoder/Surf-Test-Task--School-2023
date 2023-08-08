package ru.kovsh.surftesttask.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ingredient")
data class Ingredient(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val cocktailId: Int,
    val name: String,
)
