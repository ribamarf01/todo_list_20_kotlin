package com.example.todolist20.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.todolist20.R
import com.example.todolist20.database.AppDatabase
import com.example.todolist20.model.Todo

class TodoAdapter(private val context: Context, private var todoList: MutableList<Todo>):
    RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    class TodoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val todoTitle: TextView = itemView.findViewById(R.id.todo_title)
        val todoCategory: TextView = itemView.findViewById(R.id.todo_category)
        val removeButton: Button = itemView.findViewById(R.id.remove_button)
    }


    /*val db = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "todo-list"
    ).build()*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoAdapter.TodoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.todo_item, parent, false)

        return TodoViewHolder(view);
    }

    override fun onBindViewHolder(holder: TodoAdapter.TodoViewHolder, position: Int) {
        holder.todoTitle.text = todoList[position].todo
        holder.todoCategory.text = todoList[position].category
        holder.removeButton.setOnClickListener {
            removeTodo(todoList[position])
        }
    }

    override fun getItemCount() = todoList.size

    fun addTodo(todo: Todo) {
        todoList.add(todo)
        //db.todoDao().insertTodo(todo)
        //notifyItemInserted(todoList.size - 1)
        notifyDataSetChanged()
    }

    private fun removeTodo(todo: Todo) {
        if(todoList.remove(todo)) {
            //db.todoDao().delete(todo)
            notifyDataSetChanged()
        }
    }

}