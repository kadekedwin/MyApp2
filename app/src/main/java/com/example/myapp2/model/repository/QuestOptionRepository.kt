package com.example.myapp2.model.repository

import com.example.myapp2.model.dao.QuestOptionDao
import com.example.myapp2.model.entity.QuestOption

class QuestOptionRepository(private val questOptionDao: QuestOptionDao) {
    suspend fun getAll(): List<QuestOption> {
        return questOptionDao.getAll()
    }

    suspend fun insert(questOption: QuestOption) {
        questOptionDao.insert(questOption)
    }

    suspend fun delete(questOption: QuestOption) {
        questOptionDao.delete(questOption)
    }
}