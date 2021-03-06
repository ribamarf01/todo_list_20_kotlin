package com.example.todolist20.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.todolist20.R
import com.example.todolist20.TodoApplication
import com.example.todolist20.adapter.TodoAdapter
import com.example.todolist20.model.Todo
import com.example.todolist20.viewmodel.TodoViewModel
import com.example.todolist20.viewmodel.TodoViewModelFactory
import kotlinx.coroutines.launch

class AddTodoFragment : Fragment() {

    private val viewModel: TodoViewModel by activityViewModels {
        TodoViewModelFactory(
            (activity?.application as TodoApplication).database.todoDao()
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_add_todo, container, false)
        val spinner: Spinner = view.findViewById(R.id.category_selector)

        ArrayAdapter.createFromResource(
            requireActivity(),
            R.array.categories,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        val addButton: Button = view.findViewById(R.id.add_button)
        addButton.setOnClickListener {
            val todoText: String = view.findViewById<EditText>(R.id.todo_text_input).text.toString()
            val todoCategory: String = spinner.selectedItem.toString()

            if(todoText != "") {
                val todo = Todo(todo = todoText, category = todoCategory)
                lifecycleScope.launch {
                    viewModel.insertTodo(todo)
                }
                view.findViewById<EditText>(R.id.todo_text_input).text.clear()
            } else Toast.makeText(requireContext(), R.string.error_add , Toast.LENGTH_SHORT).show()
        }

        return view
    }
}