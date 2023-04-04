package com.example.bitfitpart1

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "food_table")
data class FoodEntity(

    @ColumnInfo(name = "food") val food: String?,
    @ColumnInfo(name = "calCount") val calCount: String?,
    @PrimaryKey(autoGenerate = true) val id: Long = 0

    )