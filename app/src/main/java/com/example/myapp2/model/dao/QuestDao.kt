package com.example.myapp2.model.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.myapp2.model.entity.Quest

@Dao
interface QuestDao {
    @Query("SELECT * FROM quest")
    suspend fun getAll(): List<Quest>

    @Insert
    suspend fun insert(quest: Quest)

    @Delete
    suspend fun delete(quest: Quest)
}