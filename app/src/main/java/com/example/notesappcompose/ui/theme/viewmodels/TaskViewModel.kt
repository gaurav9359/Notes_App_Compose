package com.example.todoapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.todoapp.models.TaskModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.util.concurrent.atomic.AtomicInteger

class TaskViewModel : ViewModel() {
    private val nextId = AtomicInteger(0)
    private val _taskList =
        MutableStateFlow<List<TaskModel>>(listOf(TaskModel(0, "name", "gaurav pathak")))
    var taskList: StateFlow<List<TaskModel>> = _taskList


    public var title: String? = null
    public var description: String? = null
    public var selectedTaskId: Int? = null


    fun addTask(titleToSet: String, descriptionToSet: String, id: Int?) {
        val updatedList = taskList.value.toList().toMutableList()
        if (id == null) {
            updatedList.add(TaskModel(updatedList.size + 1, titleToSet, descriptionToSet))
        } else {
            val index = updatedList.indexOfFirst { it.id == id }
            if (index != -1) {
                updatedList[index] = TaskModel(id, titleToSet, descriptionToSet)
            }
        }
        _taskList.value = updatedList
        clearTaskInputs()
    }

    fun deleteTask(id: Int?) {

        if (id !== null) {
            val updatedList = taskList.value.toList().toMutableList()
            val index = updatedList.indexOfFirst { it.id == id }
            if (index != -1) {
                updatedList.removeAt(index)
            }
            _taskList.value = updatedList
        }
        clearTaskInputs()
    }

    private fun clearTaskInputs() {
        title = ""
        description = ""
        selectedTaskId = null
    }
}
