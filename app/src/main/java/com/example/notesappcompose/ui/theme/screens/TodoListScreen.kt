package com.example.notesappcompose.ui.theme.screens

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.notesappcompose.ui.theme.navigation.Screen
import com.example.todoapp.models.TaskModel
import com.example.todoapp.ui.viewmodel.TaskViewModel

@Composable
fun TodoListScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: TaskViewModel ,
    taskList:List<TaskModel>,
    taskId:Int?,
    onTaskIdUpdated: (Int?) -> Unit
) {
    Log.d("oreno","1")
    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = modifier.fillMaxSize()) {
            if (taskList.isEmpty()) {
                Text(
                    text = "No Note To Display",
                    color = Color.White,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top=16.dp),
                    textAlign = TextAlign.Center
                )
            } else {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(1),
                    contentPadding = PaddingValues(top=16.dp)
                ) {
                    items(viewModel.taskList.value) { task ->
                        TaskItem(
                            task = task,
                            navController = navController,
                            taskList = taskList,
                            viewModel = viewModel,
                            taskId = taskId,
                            onTaskIdUpdated=onTaskIdUpdated
                        )

                    }
                }
            }
        }

        FloatingActionButton(
            onClick = {
                navController.navigate(Screen.EditScreen.route)
            },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.BottomEnd),
            containerColor = Color.White
        ) {
            Text(text = "+")
        }
    }
}