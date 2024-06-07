package com.example.notesappcompose.ui.theme.screens

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.notesappcompose.ui.theme.navigation.Navigation
import com.example.notesappcompose.ui.theme.navigation.Screen
import com.example.todoapp.models.TaskModel
import com.example.todoapp.ui.viewmodel.TaskViewModel

@Composable
fun TaskItem(
    navController: NavController,
    task: TaskModel,
    taskList: List<TaskModel>,
    viewModel: TaskViewModel,
    taskId: Int?,
    onTaskIdUpdated: (Int?) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                onTaskIdUpdated(task.id)
                navController.navigate(Screen.EditScreen.route)
            },
        colors = CardDefaults.cardColors(containerColor = Color(0xFFE0E0E0))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color(0xFF3F51B5), // Change the color here
                            fontSize = 20.sp // Change the font size here
                        )
                    ) {
                        append("Title: ")
                    }
                    withStyle(
                        style = SpanStyle(
                            color = Color.Black,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append(task.title)
                    }
                },
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color(0xFF3F51B5), // Change the color here
                            fontSize = 20.sp // Change the font size here
                        )
                    ) {
                        append("Description: ")
                    }
                    withStyle(
                        style = SpanStyle(
                            color = Color.Black,
                            fontSize = 16.sp
                        )
                    ) {
                        append(task.description)
                    }
                }
            )
        }
    }
}