package com.example.myapp2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.myapp2.model.entity.Quest
import com.example.myapp2.model.entity.QuestOption
import com.example.myapp2.model.entity.QuestWithOptions
import com.example.myapp2.model.entity.Quiz
import com.example.myapp2.model.entity.QuizWithQuests
import com.example.myapp2.model.repository.QuestOptionRepository
import com.example.myapp2.model.repository.QuestRepository
import com.example.myapp2.model.repository.QuizRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class QuizViewModel(private val quizRepository: QuizRepository, private val questRepository: QuestRepository, private val questOptionRepository: QuestOptionRepository) : ViewModel() {
    private val _allQuiz = MutableStateFlow<List<Quiz>>(emptyList())
    val allQuiz = _allQuiz.asStateFlow()
    private val _allQuizWithQuests = MutableStateFlow<List<QuizWithQuests>>(emptyList())
    val allQuizWithQuests = _allQuizWithQuests.asStateFlow()
    private val _quizWithQuests = MutableStateFlow<QuizWithQuests?>(null)
    val quizWithQuests = _quizWithQuests.asStateFlow()

    private val _allQuest = MutableStateFlow<List<Quest>>(emptyList())
    val allQuest = _allQuest.asStateFlow()
    private val _allQuestWithOptions = MutableStateFlow<List<QuestWithOptions>>(emptyList())
    val allQuestWithOptions = _allQuestWithOptions.asStateFlow()
    private val _questWithOptions = MutableStateFlow<QuestWithOptions?>(null)
    val questWithOptions = _questWithOptions.asStateFlow()

    private val _allQuestOption = MutableStateFlow<List<QuestOption>>(emptyList())
    val allQuestOption = _allQuestOption.asStateFlow()

    init {
        getAllQuiz()
        getAllQuizWithQuest()
        getAllQuest()
        getAllQuestWithOptions()
        getAllQuestOption()
    }

    fun getAllQuiz() {
        viewModelScope.launch {
            _allQuiz.value = quizRepository.getAll()
        }
    }
    fun insertQuiz(quiz: Quiz, onRetreived: (Long) -> Unit) {
        viewModelScope.launch {
            onRetreived(quizRepository.insert(quiz))
            getAllQuiz()
        }
    }
    fun deleteQuiz(quiz: Quiz) {
        viewModelScope.launch {
            quizRepository.delete(quiz)
            getAllQuiz()
        }
    }
    fun getAllQuizWithQuest() {
        viewModelScope.launch {
            _allQuizWithQuests.value = quizRepository.getAllQuizWithQuests()
        }
    }
    fun getQuizWithQuests(quizId: Long) {
        viewModelScope.launch {
            _quizWithQuests.value = quizRepository.getQuizWithQuests(quizId)
        }
    }



    fun getAllQuest() {
        viewModelScope.launch {
            _allQuest.value = questRepository.getAll()
        }
    }
    fun insertQuest(quest: Quest, onRetreived: (Long) -> Unit) {
        viewModelScope.launch {
            onRetreived(questRepository.insert(quest))
            getAllQuest()
        }
    }
    fun deleteQuest(quest: Quest) {
        viewModelScope.launch {
            questRepository.delete(quest)
            getAllQuest()
        }
    }
    fun getAllQuestWithOptions() {
        viewModelScope.launch {
            _allQuestWithOptions.value = questRepository.getAllQuestWithOptions()
        }
    }
    fun getQuestWithOption(questId: Long) {
        viewModelScope.launch {
            _questWithOptions.value = questRepository.getQuestWithOptions(questId)
        }
    }



    fun getAllQuestOption() {
        viewModelScope.launch {
            _allQuestOption.value = questOptionRepository.getAll()
        }
    }
    fun insertQuestOption(questOption: QuestOption, onRetreived: (Long) -> Unit) {
        viewModelScope.launch {
            onRetreived(questOptionRepository.insert(questOption))
            getAllQuestOption()
        }
    }
    fun deleteQuestOption(questOption: QuestOption) {
        viewModelScope.launch {
            questOptionRepository.delete(questOption)
            getAllQuestOption()
        }
    }
}


class QuizViewModelFactory(private val quizRepository: QuizRepository, private val questRepository: QuestRepository, private val questOptionRepository: QuestOptionRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(QuizViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return QuizViewModel(quizRepository, questRepository, questOptionRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}