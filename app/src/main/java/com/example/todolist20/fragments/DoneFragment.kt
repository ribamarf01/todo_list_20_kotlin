package com.example.todolist20.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.todolist20.R
import com.example.todolist20.TodoApplication
import com.example.todolist20.adapter.DoneAdapter
import com.example.todolist20.viewmodel.TodoViewModel
import com.example.todolist20.viewmodel.TodoViewModelFactory
import kotlinx.coroutines.launch

class DoneFragment : Fragment() {

    private val viewModel: TodoViewModel by activityViewModels {
        TodoViewModelFactory(
            (activity?.application as TodoApplication).database.todoDao()
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_done, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.todos_recycler_view)

        lifecycleScope.launch {
            recyclerView.adapter = DoneAdapter(viewModel.getDone())
        }
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)

        return view
    }
}