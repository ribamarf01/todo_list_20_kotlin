package com.example.todolist20.model

import androidx.room.Entity

@Entity(tableName = "todo_items")
data class Todo(var todo: String, var category: String)