package com.example.notesappcompose.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.todoapp.models.TaskModel
import com.example.todoapp.ui.viewmodel.TaskViewModel

@Composable
fun MainScreen(
    navController: NavController,
    viewModel: TaskViewModel,
    taskList: List<TaskModel>,
    taskId: Int?,
    onTaskIdUpdated: (Int?) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(20.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Text(
                text = "NOTES TAKING APP",
                color = Color(0xFF3F51B5),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                textAlign = TextAlign.Center
            )

            TodoListScreen(
                navController = navController,
                modifier = Modifier.fillMaxSize(),
                taskList = taskList,
                viewModel = viewModel,
                taskId = taskId,
                onTaskIdUpdated = onTaskIdUpdated
            )
        }
    }
}