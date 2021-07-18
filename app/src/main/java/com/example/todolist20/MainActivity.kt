package com.example.todolist20

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.todolist20.fragments.AddTodoFragment
import com.example.todolist20.fragments.DoneFragment
import com.example.todolist20.fragments.ListFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var bottomNav: BottomNavigationView
    lateinit var sideNav: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addTodoFragment = AddTodoFragment()
        val doneFragment = DoneFragment()
        val listFragment = ListFragment()

        makeCurrentFragment(listFragment)

        bottomNav = findViewById(R.id.bottom_nav)
        sideNav = findViewById(R.id.side_nav)

        bottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.new_todo -> makeCurrentFragment(addTodoFragment)
                R.id.undone -> makeCurrentFragment(listFragment)
                R.id.done -> makeCurrentFragment(doneFragment)
            }
            true
        }

        sideNav.setNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.new_todo -> makeCurrentFragment(addTodoFragment)
                R.id.undone -> makeCurrentFragment(listFragment)
                R.id.done -> makeCurrentFragment(doneFragment)
            }
            true
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if(newConfig.orientation === Configuration.ORIENTATION_PORTRAIT) {
            bottomNav.visibility = View.VISIBLE
            sideNav.visibility = View.GONE
        } else if(newConfig.orientation === Configuration.ORIENTATION_LANDSCAPE){
            bottomNav.visibility = View.GONE
            sideNav.visibility = View.VISIBLE
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container, fragment)
            commit()
        }
}