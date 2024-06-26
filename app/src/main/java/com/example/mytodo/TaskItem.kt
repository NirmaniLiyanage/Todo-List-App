package com.example.mytodo

import android.content.Context
import androidx.core.content.ContextCompat
import java.time.LocalDate
import java.time.LocalTime
import java.util.UUID

class TaskItem (
    var name: String,
    var desc: String,
    var dueTime: LocalTime?,
    var completeDate: LocalDate?,
    var id: UUID = UUID.randomUUID()
)
{
    fun iscompleted() = completeDate != null
    fun imageResource() : Int = if(iscompleted()) R.drawable.checked_24 else R.drawable.unchecked_24
    fun imageColor(context: Context): Int = if (iscompleted()) purple(context) else black(context)

    private fun purple(context: Context) = ContextCompat.getColor(context,R.color.purple)
    private fun black(context: Context) = ContextCompat.getColor(context,R.color.black)
}
