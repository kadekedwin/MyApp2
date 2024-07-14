package com.example.myapp2.model

import androidx.compose.runtime.compositionLocalOf
import com.example.myapp2.viewmodel.QuizViewModel

val LocalDeviceViewModel = compositionLocalOf<QuizViewModel>{
    error("No QuizViewModel provided")
}