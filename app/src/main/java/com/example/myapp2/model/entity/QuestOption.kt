package com.example.myapp2.model.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "quest_option",
    foreignKeys = [ForeignKey(
        entity = Quest::class,
        parentColumns = ["id"],
        childColumns = ["questId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class QuestOption(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val questId: Int,
    val option: String
)
