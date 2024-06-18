package com.example.mytodo

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Paint
import androidx.recyclerview.widget.RecyclerView
import com.example.mytodo.databinding.TaskItemCellBinding
import java.time.format.DateTimeFormatter
import java.util.zip.DataFormatException

class TaskItemViewHolder(
    private val context:Context,
    private val binding: TaskItemCellBinding,
    private val clickListner: TaskItemClickListner
):RecyclerView.ViewHolder(binding.root) {

    @SuppressLint("NewApi")
    private val timeFormat = DateTimeFormatter.ofPattern("HH:mm")

    @SuppressLint("NewApi")
    fun bindTaskItem(taskItem: TaskItem)
    {
        binding.name.text = taskItem.name

        if (taskItem.iscompleted()) {
            binding.name.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            binding.dueTime.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
        }

        binding.completeButton.setImageResource((taskItem.imageResource()))
        binding.completeButton.setColorFilter(taskItem.imageColor(context))

        binding.completeButton.setOnClickListener{
            clickListner.completeTaskItem(taskItem)
        }

        binding.taskCellContainer.setOnClickListener{
            clickListner.editTaskItem(taskItem)
        }

        if (taskItem.dueTime != null)
            binding.dueTime.text = timeFormat.format(taskItem.dueTime)
        else
            binding.dueTime.text = ""
    }
}