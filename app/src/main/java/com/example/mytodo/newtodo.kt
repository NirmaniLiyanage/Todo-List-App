package com.example.mytodo

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mytodo.databinding.FragmentNewtodoBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class NewTodo(var taskItem: TaskItem?) : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentNewtodoBinding
    private lateinit var taskViewModel: TaskViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentNewtodoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    if (taskItem != null)
    {
        binding.taskTitle.text = "Edit Todo"
        val editable = Editable.Factory.getInstance()
        binding.name.text =editable.newEditable(taskItem!!.name)
        binding.desc.text =editable.newEditable(taskItem!!.desc)
    }
    else
    {
        binding.taskTitle.text = "New Todo"
    }

        // Initialize taskViewModel
        taskViewModel = ViewModelProvider(requireActivity()).get(TaskViewModel::class.java)

        binding.saveButton.setOnClickListener {
            saveAction()
        }
    }

    private fun saveAction() {
        val name = binding.name.text.toString()
        val desc = binding.desc.text.toString()
        if(taskItem == null)
        {
            val newTask = TaskItem(name,desc,null,null)
            taskViewModel.addTaskItem(newTask)
        }
        else
        {
            taskViewModel.updateTaskItem(taskItem!!.id,name,desc,null)
        }
        binding.name.setText("")
        binding.desc.setText("")
        dismiss()
    }
}
