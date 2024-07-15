package com.example.myapp2.model.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.myapp2.model.entity.Quest
import com.example.myapp2.model.entity.QuestWithOptions
import com.example.myapp2.model.entity.QuizWithQuests

@Dao
interface QuestDao {
    @Query("SELECT * FROM quest")
    suspend fun getAll(): List<Quest>

    @Insert
    suspend fun insert(quest: Quest): Long

    @Delete
    suspend fun delete(quest: Quest)

    @Transaction
    @Query("SELECT * FROM quest WHERE id = :questId")
    suspend fun getQuestWithOptions(questId: Long): QuestWithOptions
}