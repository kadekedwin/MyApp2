package com.example.myapp2.model.entity

import androidx.room.Embedded
import androidx.room.Relation

data class QuizWithQuestsAndOptions(
    @Embedded val quiz: Quiz,
    @Relation(
        entity = Quest::class,
        parentColumn = "id",
        entityColumn = "quizId",
    )
    val quests: List<QuestWithOptions>
)

