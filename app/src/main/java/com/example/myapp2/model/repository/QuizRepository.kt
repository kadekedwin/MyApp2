package com.example.myapp2.model.repository

import androidx.lifecycle.LiveData
import com.example.myapp2.model.dao.QuizDao
import com.example.myapp2.model.entity.Quiz
import com.example.myapp2.model.entity.QuizWithQuests
import com.example.myapp2.model.entity.QuizWithQuestsAndOptions
import kotlinx.coroutines.flow.Flow

class QuizRepository(private val quizDao: QuizDao) {
    val allQuiz: Flow<List<Quiz>> = quizDao.getAll()

    suspend fun insertQuiz(quiz: Quiz): Long {
        return quizDao.insert(quiz)
    }

    suspend fun deleteQuiz(quiz: Quiz) {
        quizDao.delete(quiz)
    }

    val allQuizWithQuestsAndOptions: Flow<List<QuizWithQuestsAndOptions>> = quizDao.getAllQuizWithQuestsAndOptions()

    fun getQuizWithQuestsAndOptions(quizId: Long): Flow<QuizWithQuestsAndOptions?> {
        return quizDao.getQuizWithQuestsAndOptions(quizId)
    }
}