package com.example.myapp2.model.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.myapp2.model.entity.Quiz
import com.example.myapp2.model.entity.QuizWithQuests
import com.example.myapp2.model.entity.QuizWithQuestsAndOptions
import kotlinx.coroutines.flow.Flow

@Dao
interface QuizDao {
    @Query("SELECT * FROM quiz")
    fun getAll(): Flow<List<Quiz>>

    @Insert
    suspend fun insert(quiz: Quiz): Long

    @Delete
    suspend fun delete(quiz: Quiz)

    @Transaction
    @Query("SELECT * FROM quiz")
    fun getAllQuizWithQuestsAndOptions(): Flow<List<QuizWithQuestsAndOptions>>

    @Transaction
    @Query("SELECT * FROM quiz WHERE id = :quizId")
    fun getQuizWithQuestsAndOptions(quizId: Long): Flow<QuizWithQuestsAndOptions?>
}