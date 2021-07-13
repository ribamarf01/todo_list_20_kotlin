package com.example.todolist20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.todolist20.database.AppDatabase

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}