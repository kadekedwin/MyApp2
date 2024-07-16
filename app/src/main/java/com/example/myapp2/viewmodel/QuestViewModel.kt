package com.example.myapp2.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.myapp2.model.entity.Quest
import com.example.myapp2.model.entity.QuestWithOptions
import com.example.myapp2.model.entity.QuizWithQuests
import com.example.myapp2.model.repository.QuestOptionRepository
import com.example.myapp2.model.repository.QuestRepository
import com.example.myapp2.model.repository.QuizRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class QuestViewModel(private val questRepository: QuestRepository) : ViewModel() {

    val allQuest: StateFlow<List<Quest>> = questRepository.allQuest
        .stateIn(scope = viewModelScope, started = SharingStarted.WhileSubscribed(5000), initialValue = emptyList())

    fun insertQuest(quest: Quest, onRetreived: (Long) -> Unit) {
        viewModelScope.launch {
            onRetreived(questRepository.insert(quest))
        }
    }

    fun deleteQuest(quest: Quest) {
        viewModelScope.launch {
            questRepository.delete(quest)
        }
    }
}

class QuestViewModelFactory(private val questRepository: QuestRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(QuestViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return QuestViewModel(questRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
