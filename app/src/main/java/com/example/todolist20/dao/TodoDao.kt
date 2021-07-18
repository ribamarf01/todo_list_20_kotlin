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

    @Query("SELECT * FROM todo_items WHERE done=0")
    suspend fun getOpen(): MutableList<Todo>

    @Query("SELECT * FROM todo_items WHERE done=1")
    suspend fun getDone(): MutableList<Todo>

    @Insert
    suspend fun insertTodo(todo: Todo)

    @Query("UPDATE todo_items SET done=1 WHERE id=:id")
    suspend fun closeTodo(id: Int)
}