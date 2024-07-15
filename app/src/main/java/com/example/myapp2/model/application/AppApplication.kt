package com.example.myapp2.model.application

import android.app.Application
import com.example.myapp2.model.database.AppDatabase
import com.example.myapp2.model.repository.QuestOptionRepository
import com.example.myapp2.model.repository.QuestRepository
import com.example.myapp2.model.repository.QuizRepository

class AppApplication : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val quizRepository by lazy { QuizRepository(database.quizDao()) }
    val questRepository by lazy { QuestRepository(database.questDao()) }
    val questOptionRepository by lazy { QuestOptionRepository(database.questOptionDao()) }
}