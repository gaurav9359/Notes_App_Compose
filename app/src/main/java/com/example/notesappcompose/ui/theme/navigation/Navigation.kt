package com.example.notesappcompose.ui.theme.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.notesappcompose.ui.theme.screens.MainScreen
import com.example.notesappcompose.ui.theme.screens.CreateTaskScreen
import com.example.todoapp.ui.viewmodel.TaskViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val viewModel = TaskViewModel()
    val taskList = viewModel.taskList.value
    var taskId: Int? = null

    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(Screen.MainScreen.route) {
            MainScreen(
                navController = navController,
                taskList = taskList,
                viewModel = viewModel,
                taskId = taskId
            ) { updatedTaskId ->
                taskId = updatedTaskId
            }
        }
        composable(
            route = Screen.EditScreen.route
        ) {
            CreateTaskScreen(
                navController = navController,
                taskList = taskList,
                viewModel = viewModel,
                taskId = taskId
            ) { updatedTaskId ->
                taskId = updatedTaskId
            }

        }
    }
}

