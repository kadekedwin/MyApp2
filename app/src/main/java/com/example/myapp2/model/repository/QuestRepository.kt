package com.example.myapp2.model.repository

import com.example.myapp2.model.dao.QuestDao
import com.example.myapp2.model.entity.Quest

class QuestRepository(private val questDao: QuestDao) {
    suspend fun getAll(): List<Quest> {
        return questDao.getAll()
    }

    suspend fun insert(quest: Quest) {
        questDao.insert(quest)
    }

    suspend fun delete(quest: Quest) {
        questDao.delete(quest)
    }
}