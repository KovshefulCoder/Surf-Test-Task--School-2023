package ru.kovsh.surftesttask.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cocktails")
data class Cocktail(
    @PrimaryKey(autoGenerate = true)
    val id: Int = -1,
    val title: String = "",
    val description: String = "",
    val recipe: String = "",
)
