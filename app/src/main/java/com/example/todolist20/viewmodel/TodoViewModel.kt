package com.example.todolist20.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.todolist20.dao.TodoDao
import com.example.todolist20.model.Todo
import java.lang.IllegalArgumentException

class TodoViewModel(private val TodoDao: TodoDao): ViewModel() {
    suspend fun allTodos() = TodoDao.getAll()

    suspend fun insertTodo(todo: Todo) {
        TodoDao.insertTodo(todo)
    }

    suspend fun deleteTodo(todo: Todo) {
        TodoDao.delete(todo)
    }
}

class TodoViewModelFactory(private val todoDao: TodoDao): ViewModelProvider.Factory {
    override fun <T: ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TodoViewModel::class.java)) {
            return TodoViewModel(todoDao) as T
        }
        throw IllegalArgumentException("Unknown view model class")
    }
}