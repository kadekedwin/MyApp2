package com.example.myapp2.model.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.myapp2.model.entity.QuestOption

@Dao
interface QuestOptionDao {
    @Query("SELECT * FROM quest_option")
    suspend fun getAll(): List<QuestOption>

    @Insert
    suspend fun insert(questOption: QuestOption)

    @Delete
    suspend fun delete(questOption: QuestOption)
}