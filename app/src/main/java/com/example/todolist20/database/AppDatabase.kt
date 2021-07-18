package com.example.todolist20.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todolist20.dao.TodoDao
import com.example.todolist20.model.Todo

@Database(entities = [Todo::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract fun todoDao(): TodoDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE?: synchronized(this) {
                val instance = Room
                    .databaseBuilder(context, AppDatabase::class.java, "todo_database_2")
                    .build()

                INSTANCE = instance

                instance
            }
        }
    }

}