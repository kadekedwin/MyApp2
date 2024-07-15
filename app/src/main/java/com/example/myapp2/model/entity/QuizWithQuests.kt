package com.example.myapp2.model.entity

import androidx.room.Embedded
import androidx.room.Relation

data class QuizWithQuests(
    @Embedded val quiz: Quiz,
    @Relation(
        parentColumn = "id",
        entityColumn = "quizId"
    )
    val quests: List<Quest>
)
