package com.example.myapp2.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapp2.model.dao.QuestDao
import com.example.myapp2.model.dao.QuestOptionDao
import com.example.myapp2.model.entity.Quiz
import com.example.myapp2.model.dao.QuizDao
import com.example.myapp2.model.entity.Quest
import com.example.myapp2.model.entity.QuestOption

@Database(entities = [Quiz::class, Quest::class, QuestOption::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun quizDao(): QuizDao
    abstract fun questDao(): QuestDao
    abstract fun questOptionDao(): QuestOptionDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build()

                INSTANCE = instance
                instance
            }
        }
    }
}