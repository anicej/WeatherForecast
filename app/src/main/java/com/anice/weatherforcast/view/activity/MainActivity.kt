package com.anice.weatherforcast.view.activity

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.anice.weatherforcast.BR
import com.anice.weatherforcast.R
import com.anice.weatherforcast.databinding.ActivityTodoBinding
import com.anice.weatherforcast.view.activity.base.BaseActivity
import com.anice.weatherforcast.view.activity.todo.TodoViewModel

private const val TAG = "TodoActivity"

class MainActivity : BaseActivity<TodoViewModel , ActivityTodoBinding>() {

    override val layoutRes = R.layout.activity_todo
    override val bindingVariable = BR.viewModel
    override val viewModelClass = TodoViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // register observer
        observeTodoDataFailureEvent()
    }

    private fun observeTodoDataFailureEvent() {
        viewModel.todoDataFailureEvent.observe(this, Observer {
            Toast.makeText(this, "Error: $it", Toast.LENGTH_SHORT).show()
        })
    }
}