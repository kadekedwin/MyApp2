package com.example.myapp2.model.repository

import androidx.lifecycle.LiveData
import com.example.myapp2.model.dao.QuizDao
import com.example.myapp2.model.entity.Quiz
import com.example.myapp2.model.entity.QuizWithQuests
import kotlinx.coroutines.flow.Flow

class QuizRepository(private val quizDao: QuizDao) {
    val allQuiz: Flow<List<Quiz>> = quizDao.getAll()

    suspend fun insertQuiz(quiz: Quiz): Long {
        return quizDao.insert(quiz)
    }

    suspend fun deleteQuiz(quiz: Quiz) {
        quizDao.delete(quiz)
    }

    val allQuizWithQuests: Flow<List<QuizWithQuests>> = quizDao.getAllQuizWithQuests()

    fun getQuizWithQuests(quizId: Long): Flow<QuizWithQuests?> {
        return quizDao.getQuizWithQuests(quizId)
    }
}