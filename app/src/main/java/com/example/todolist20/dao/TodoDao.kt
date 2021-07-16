package com.example.todolist20.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.todolist20.model.Todo

@Dao
interface TodoDao {

    @Query("SELECT * FROM todo_items")
    suspend fun getAll() : MutableList<Todo>

    @Insert
    suspend fun insertTodo(todo: Todo)

    @Delete
    suspend fun delete(todo: Todo)
}