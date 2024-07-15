package com.example.myapp2.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quiz")
data class Quiz(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val icon: Int,
//    val color: Color
)