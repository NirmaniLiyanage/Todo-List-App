package com.example.mytodo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mytodo.databinding.TaskItemCellBinding

class TaskItemAdapter(
    private val taskItem: List<TaskItem>,
    mainActivity: MainActivity
):RecyclerView.Adapter<TaskItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskItemViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = TaskItemCellBinding.inflate(from,parent,false)
        return TaskItemViewHolder(parent.context,binding,TaskItemClickListner())
    }

    override fun onBindViewHolder(holder: TaskItemViewHolder, position: Int) {
        holder.bindTaskItem(taskItem[position])
    }

    override fun getItemCount(): Int = taskItem.size
}