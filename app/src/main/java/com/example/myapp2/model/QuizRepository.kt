package com.example.myapp2.model

class QuizRepository(private val quizDao: QuizDao) {

    suspend fun getAll(): List<Quiz> {
        return quizDao.getAll()
    }

    suspend fun insert(quiz: Quiz) {
        quizDao.insert(quiz)
    }

    suspend fun delete(quiz: Quiz) {
        quizDao.delete(quiz)
    }
}