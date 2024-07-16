package com.example.myapp2.model.repository

import com.example.myapp2.model.dao.QuestDao
import com.example.myapp2.model.entity.Quest
import com.example.myapp2.model.entity.QuestWithOptions
import com.example.myapp2.model.entity.QuizWithQuests
import kotlinx.coroutines.flow.Flow

class QuestRepository(private val questDao: QuestDao) {
    val allQuest: Flow<List<Quest>> = questDao.getAll()

    suspend fun insert(quest: Quest): Long {
        return questDao.insert(quest)
    }

    suspend fun delete(quest: Quest) {
        questDao.delete(quest)
    }
}