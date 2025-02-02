package com.example.myapp2.model.entity

import androidx.room.Embedded
import androidx.room.Relation

data class QuestWithOptions(
    @Embedded val quest: Quest,
    @Relation(
        parentColumn = "id",
        entityColumn = "questId"
    )
    val options: List<QuestOption>
)
