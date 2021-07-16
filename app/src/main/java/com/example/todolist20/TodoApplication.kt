package com.example.todolist20

import android.app.Application
import com.example.todolist20.database.AppDatabase

class TodoApplication: Application() {

    val database: AppDatabase by lazy {
        AppDatabase.getDatabase(this)
    }

}