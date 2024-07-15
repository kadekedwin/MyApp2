package com.example.myapp2.model.repository

import com.example.myapp2.model.dao.QuestOptionDao
import com.example.myapp2.model.entity.QuestOption
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

class QuestOptionRepository(private val questOptionDao: QuestOptionDao) {
    val allQuestOption: Flow<List<QuestOption>> = questOptionDao.getAll()

    suspend fun insert(questOption: QuestOption): Long {
        return questOptionDao.insert(questOption)
    }

    suspend fun delete(questOption: QuestOption){
        questOptionDao.delete(questOption)
    }
}