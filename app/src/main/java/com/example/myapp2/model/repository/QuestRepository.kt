package com.example.myapp2.model.repository

import com.example.myapp2.model.dao.QuestDao
import com.example.myapp2.model.entity.Quest
import com.example.myapp2.model.entity.QuestWithOptions
import com.example.myapp2.model.entity.QuizWithQuests

class QuestRepository(private val questDao: QuestDao) {
    suspend fun getAll(): List<Quest> {
        return questDao.getAll()
    }

    suspend fun insert(quest: Quest): Long {
        return questDao.insert(quest)
    }

    suspend fun delete(quest: Quest) {
        questDao.delete(quest)
    }

    suspend fun getAllQuestWithOptions(): List<QuestWithOptions> {
        return questDao.getAllQuestWithOptions()
    }

    suspend fun getQuestWithOptions(questId: Long): QuestWithOptions {
        return questDao.getQuestWithOptions(questId)
    }
}