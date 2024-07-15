package com.example.myapp2.model.repository

import androidx.lifecycle.LiveData
import com.example.myapp2.model.dao.QuizDao
import com.example.myapp2.model.entity.Quiz
import com.example.myapp2.model.entity.QuizWithQuests

class QuizRepository(private val quizDao: QuizDao) {

    suspend fun getAll(): List<Quiz> {
        return quizDao.getAll()
    }

    suspend fun insert(quiz: Quiz): Long {
        return quizDao.insert(quiz)
    }

    suspend fun delete(quiz: Quiz) {
        quizDao.delete(quiz)
    }

    suspend fun getQuizWithQuests(quizId: Int): QuizWithQuests {
        return quizDao.getQuizWithQuests(quizId)
    }
}