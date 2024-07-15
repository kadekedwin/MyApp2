package com.example.myapp2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.CompositionLocalProvider
import com.example.myapp2.model.LocalQuestOptionViewModel
import com.example.myapp2.model.LocalQuestViewModel
import com.example.myapp2.model.LocalQuizViewModel
import com.example.myapp2.model.application.AppApplication
import com.example.myapp2.view.MyApp
import com.example.myapp2.viewmodel.QuestOptionViewModel
import com.example.myapp2.viewmodel.QuestOptionViewModelFactory
import com.example.myapp2.viewmodel.QuestViewModel
import com.example.myapp2.viewmodel.QuestViewModelFactory
import com.example.myapp2.viewmodel.QuizViewModel
import com.example.myapp2.viewmodel.QuizViewModelFactory

class MainActivity : ComponentActivity() {
    val quizViewModel: QuizViewModel by viewModels {
        QuizViewModelFactory((application as AppApplication).quizRepository)
    }
    val questViewModel: QuestViewModel by viewModels {
        QuestViewModelFactory((application as AppApplication).questRepository)
    }
    val questOptionViewModel: QuestOptionViewModel by viewModels {
        QuestOptionViewModelFactory((application as AppApplication).questOptionRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CompositionLocalProvider(
                LocalQuizViewModel provides quizViewModel,
                LocalQuestViewModel provides questViewModel,
                LocalQuestOptionViewModel provides questOptionViewModel
            ) {
                MyApp()
            }
        }

    }
}