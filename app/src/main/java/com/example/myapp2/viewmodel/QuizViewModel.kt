package com.example.myapp2.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.myapp2.model.Quiz
import com.example.myapp2.model.QuizRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class QuizViewModel(private val repository: QuizRepository) : ViewModel() {
    val _allQuiz = MutableStateFlow<List<Quiz>>(emptyList())

    val allQuiz = _allQuiz.asStateFlow()

    init {
        getAllQuiz()
    }

    fun getAllQuiz() {
        viewModelScope.launch {
            _allQuiz.value = repository.getAll()
        }
    }

    fun insertQuiz(quiz: Quiz) {
        viewModelScope.launch {
            repository.insert(quiz)
            getAllQuiz()
        }
    }

    fun deleteQuiz(quiz: Quiz) {
        viewModelScope.launch {
            repository.delete(quiz)
            getAllQuiz()
        }
    }

}


class QuizViewModelFactory(private val repository: QuizRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(QuizViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return QuizViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}