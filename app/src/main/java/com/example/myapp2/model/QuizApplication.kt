package com.example.myapp2.model

import android.app.Application

class QuizApplication : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { QuizRepository(database.quizDao()) }
}