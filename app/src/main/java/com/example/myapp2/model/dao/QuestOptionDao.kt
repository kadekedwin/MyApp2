package com.example.myapp2.model.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.myapp2.model.entity.QuestOption
import kotlinx.coroutines.flow.Flow

@Dao
interface QuestOptionDao {
    @Query("SELECT * FROM quest_option")
    fun getAll(): Flow<List<QuestOption>>

    @Insert
    suspend fun insert(questOption: QuestOption): Long

    @Delete
    suspend fun delete(questOption: QuestOption)
}