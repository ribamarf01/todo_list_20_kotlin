package com.example.todolist20.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist20.R
import com.example.todolist20.model.Todo

class DoneAdapter(private var todoList: MutableList<Todo>): RecyclerView.Adapter<DoneAdapter.DoneViewHolder>() {

    class DoneViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val todoTitle: TextView = itemView.findViewById(R.id.todo_title)
        val todoCategory: TextView = itemView.findViewById(R.id.todo_category)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoneAdapter.DoneViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.done_item, parent, false)

        return DoneAdapter.DoneViewHolder(view)
    }

    override fun onBindViewHolder(holder: DoneAdapter.DoneViewHolder, position: Int) {
        holder.todoTitle.text = todoList[position].todo
        holder.todoCategory.text = todoList[position].category
    }

    override fun getItemCount(): Int = todoList.size

}