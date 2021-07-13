package com.example.todolist20.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.todolist20.model.Todo

@Dao
interface TodoDao {

    @Query("SELECT * FROM todo_items")
    fun getAll() : MutableList<Todo>

    @Insert
    fun insertTodo(todo: Todo)

    @Delete
    fun delete(todo: Todo)
}