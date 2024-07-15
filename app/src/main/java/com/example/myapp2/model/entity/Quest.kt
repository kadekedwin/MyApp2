package com.example.myapp2.model.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "quest",
    foreignKeys = [ForeignKey(
        entity = Quiz::class,
        parentColumns = ["id"],
        childColumns = ["quizId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class Quest(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val quizId: Int,
    val quest: String
)