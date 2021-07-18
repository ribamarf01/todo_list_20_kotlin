package com.example.todolist20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.todolist20.fragments.AddTodoFragment
import com.example.todolist20.fragments.DoneFragment
import com.example.todolist20.fragments.ListFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addTodoFragment = AddTodoFragment()
        val doneFragment = DoneFragment()
        val listFragment = ListFragment()

        makeCurrentFragment(listFragment)

        val bottomNav: BottomNavigationView = findViewById(R.id.bottom_nav)

        bottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.new_todo -> makeCurrentFragment(addTodoFragment)
                R.id.undone -> makeCurrentFragment(listFragment)
                R.id.done -> makeCurrentFragment(doneFragment)
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container, fragment)
            commit()
        }
}