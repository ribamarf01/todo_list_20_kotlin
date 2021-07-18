package com.example.todolist20.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo_items")
data class Todo(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo val todo: String,
    @ColumnInfo val category: String,
    @ColumnInfo val done: Boolean = false
    )