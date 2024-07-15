package com.example.myapp2.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.myapp2.model.entity.QuestOption
import com.example.myapp2.model.repository.QuestOptionRepository
import com.example.myapp2.model.repository.QuestRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class QuestOptionViewModel(private val questOptionRepository: QuestOptionRepository) : ViewModel() {

    init {
    }

    val allQuestOption: StateFlow<List<QuestOption>> = questOptionRepository.allQuestOption
        .stateIn(scope = viewModelScope, started = SharingStarted.WhileSubscribed(5000), initialValue = emptyList())

    fun insertQuestOption(questOption: QuestOption, onRetreived: (Long) -> Unit) {
        viewModelScope.launch {
            onRetreived(questOptionRepository.insert(questOption))
        }
    }

    fun deleteQuestOption(questOption: QuestOption) {
        viewModelScope.launch {
            questOptionRepository.delete(questOption)
        }
    }
}

class QuestOptionViewModelFactory(private val questOptionRepository: QuestOptionRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(QuestOptionViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return QuestOptionViewModel(questOptionRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
