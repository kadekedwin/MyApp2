package com.example.myapp2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.myapp2.model.entity.Quest
import com.example.myapp2.model.entity.Quiz
import com.example.myapp2.model.entity.QuizWithQuests
import com.example.myapp2.model.repository.QuestOptionRepository
import com.example.myapp2.model.repository.QuestRepository
import com.example.myapp2.model.repository.QuizRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class QuizViewModel(private val quizRepository: QuizRepository, private val questRepository: QuestRepository, private val questOptionRepository: QuestOptionRepository) : ViewModel() {
    private val _allQuiz = MutableStateFlow<List<Quiz>>(emptyList())
    val allQuiz = _allQuiz.asStateFlow()

    init {
        getAllQuiz()
    }

    fun getAllQuiz() {
        viewModelScope.launch {
            _allQuiz.value = quizRepository.getAll()
        }
    }
    fun insertQuiz(quiz: Quiz) {
        viewModelScope.launch {
            quizRepository.insert(quiz)
            getAllQuiz()
        }
    }
    fun deleteQuiz(quiz: Quiz) {
        viewModelScope.launch {
            quizRepository.delete(quiz)
            getAllQuiz()
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