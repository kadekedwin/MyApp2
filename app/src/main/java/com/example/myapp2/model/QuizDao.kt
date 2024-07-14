package com.example.myapp2.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface QuizDao {
    @Query("SELECT * FROM quiz")
    suspend fun getAll(): List<Quiz>

    @Insert
    suspend fun insert(quiz: Quiz)

    @Delete
    suspend fun delete(quiz: Quiz)
}