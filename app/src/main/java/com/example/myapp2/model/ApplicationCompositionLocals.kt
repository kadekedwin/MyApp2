package com.example.myapp2.model

import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavHostController
import com.example.myapp2.viewmodel.QuestOptionViewModel
import com.example.myapp2.viewmodel.QuestViewModel
import com.example.myapp2.viewmodel.QuizViewModel

val LocalQuizViewModel = compositionLocalOf<QuizViewModel>{
    error("No QuizViewModel provided")
}
val LocalQuestViewModel = compositionLocalOf<QuestViewModel>{
    error("No QuestViewModel provided")
}
val LocalQuestOptionViewModel = compositionLocalOf<QuestOptionViewModel>{
    error("No QuestOptionViewModel provided")
}

val LocalNavController = compositionLocalOf<NavHostController>{
    error("No NavController provoded")
}

