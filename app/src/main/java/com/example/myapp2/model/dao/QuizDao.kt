package com.example.myapp2.model.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.myapp2.model.entity.Quiz
import com.example.myapp2.model.entity.QuizWithQuests

@Dao
interface QuizDao {
    @Query("SELECT * FROM quiz")
    suspend fun getAll(): List<Quiz>

    @Insert
    suspend fun insert(quiz: Quiz): Long

    @Delete
    suspend fun delete(quiz: Quiz)

    @Transaction
    @Query("SELECT * FROM quiz WHERE id = :quizId")
    suspend fun getQuizWithQuests(quizId: Int): QuizWithQuests
}