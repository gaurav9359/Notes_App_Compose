package com.example.notesappcompose.ui.theme.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todoapp.ui.viewmodel.TaskViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.notesappcompose.ui.theme.navigation.Screen
import com.example.todoapp.models.TaskModel

@Composable
fun CreateTaskScreen(
    navController: NavController,
    viewModel: TaskViewModel,
    taskList: List<TaskModel>,
    taskId:Int?,
    updateTaskId:(Int?)->Unit
) {

    val taskWithGivenId:TaskModel?=viewModel.taskList.value.find {it.id==taskId}

    var title by remember {
        mutableStateOf(taskWithGivenId?.title?:"")
    }
    var description by remember{
        mutableStateOf(taskWithGivenId?.description?:"")
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Text(
            text = if (taskId == null) "Create New Task" else "Edit Task",
            color = Color(0xFF3F51B5),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            textAlign = TextAlign.Center
        )

        OutlinedTextField(
            value =title,
            onValueChange = {title = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 28.dp),
            placeholder = { Text(text = "Title") },

        )

        OutlinedTextField(
            value = description,
            onValueChange = {newdes-> description=newdes },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .height(200.dp),
            placeholder = { Text(text = "Description") },

        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(

                onClick = {
                    title=""
                    description=""
                    updateTaskId(null)
                    navController.navigate(Screen.MainScreen.route)
                },
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 10.dp)
            ) {
                Text(text = "Cancel")
            }

            Button(
                onClick = {
                    if(title.isNotEmpty() && description.isNotEmpty() ){
                        viewModel.addTask(title, description,taskId)
                        title=""
                        description=""
                        updateTaskId(null)
                        navController.navigate(Screen.MainScreen.route)
                    }
                },
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 10.dp),
                enabled = title.isNotEmpty() && description.isNotEmpty()
            ) {
                Text(text = "Save")
            }


        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            if (taskId != null) {
                Button(
                    onClick = {
                        title = ""
                        description = ""
                        updateTaskId(null)
                        viewModel.deleteTask(taskId)
                        navController.navigate(Screen.MainScreen.route)
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "Delete")
                }
            }


        }


    }
}
