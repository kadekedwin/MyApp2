package com.example.myapp2.view

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myapp2.model.LocalNavController
import com.example.myapp2.ui.theme.MyApp2Theme
import com.example.myapp2.view.home.HomeScreen
import com.example.myapp2.view.quiz.EditQuizView
import com.example.myapp2.view.quiz.AddQuizView
import com.example.myapp2.view.quiz.QuizScreen

@Composable
fun MyAppNavigation(modifier: Modifier = Modifier) {
    val navController = LocalNavController.current
    NavHost(navController = navController, startDestination = "homeScreen") {
        composable(
            "homeScreen",
            enterTransition = { fadeIn() + slideInHorizontally { it } },
            exitTransition = { fadeOut() + slideOutHorizontally { it } }
        ) { HomeScreen(modifier = modifier) }
        composable("quizScreen") { QuizScreen(modifier = modifier) }
        composable("addQuizView") { AddQuizView(modifier = modifier) }
        composable(
            route = "addQuestView/{quizId}",
            arguments = listOf(navArgument("quizId") { type = NavType.LongType })
        ) { backStackEntry ->
            EditQuizView(modifier = modifier, backStackEntry.arguments!!.getLong("quizId"))
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()

    CompositionLocalProvider(LocalNavController provides navController) {
        MyApp2Theme {
            Scaffold(
                modifier = Modifier.background(MaterialTheme.colorScheme.background),
                bottomBar = { BottomBar() }
            ) { innerPadding ->
                    MyAppNavigation(modifier = Modifier.padding(innerPadding))
            }
        }
    }
}