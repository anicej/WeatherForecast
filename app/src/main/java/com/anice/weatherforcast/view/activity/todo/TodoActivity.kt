package com.anice.weatherforcast.view.activity.todo

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.anice.weatherforcast.BR
import com.anice.weatherforcast.R
import com.anice.weatherforcast.data.model.DailyTempModel
import com.anice.weatherforcast.databinding.ActivityTodoBinding
import com.anice.weatherforcast.view.activity.base.BaseActivity
import com.anice.weatherforcast.view.adapter.DailyWeatherAdapter
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_todo.*
import java.util.*
import kotlin.collections.ArrayList


private const val TAG = "TodoActivity"

class TodoActivity : BaseActivity<TodoViewModel, ActivityTodoBinding>() {

    override val layoutRes = R.layout.activity_todo
    override val bindingVariable = BR.viewModel
    override val viewModelClass = TodoViewModel::class.java
    lateinit var adapter: DailyWeatherAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        // register observe
        val c: Calendar = Calendar.getInstance()
        val timeOfDay: Int = c.get(Calendar.HOUR_OF_DAY)

        if (timeOfDay >= 4 && timeOfDay < 12) {
            clMain.background = getgradientDrawable("#32D0FC", "#005CE0")
        } else if (timeOfDay >= 12 && timeOfDay < 16) {
            clMain.background = getgradientDrawable("#FC9F32", "#D33A3A")
        } else if (timeOfDay >= 16 && timeOfDay < 21) {
            clMain.background = getgradientDrawable("#1C7891", "#162A2F")
        } else if ((timeOfDay >= 21 && timeOfDay < 24) || (timeOfDay >= 0 && timeOfDay < 4)) {
            clMain.background = getgradientDrawable("#35416C", "#151515")
        }


        rvDailyForecast.layoutManager = LinearLayoutManager(this)



        observeTodoDataFailureEvent()
        observeTodoDataSuccessEvent()
//
//        viewModel.todoData.observe(this, Observer<ApiResponse<WeaherForcast>> {
//            lateinit var models: List<DailyTempModel>
//
//            for (i in 1..it.data!!.list.size) {
//                models[i].minTemp= it.data.list[i].main!!.temp_min.toString()
//                println(i)
//            }
//
//        }


//        )
    }

    private fun getgradientDrawable(colorStart: String, colorEnd: String): GradientDrawable? {

        return GradientDrawable(
            GradientDrawable.Orientation.TOP_BOTTOM,
            intArrayOf(
                Color.parseColor(colorStart),
                Color.parseColor(colorEnd)
            )
        )


    }

    private fun observeTodoDataFailureEvent() {

        viewModel.todoDataFailureEvent.observe(this, Observer {
            Toast.makeText(this, "Error: $it", Toast.LENGTH_SHORT).show()
        })
    }

    private fun observeTodoDataSuccessEvent() {

        viewModel.todoDataSuccessEvent.observe(this, Observer {
            Toast.makeText(this, "Error: $it", Toast.LENGTH_SHORT).show()
            val models = ArrayList<DailyTempModel>()
            Log.e("))(", it!!.list.size.toString())
            for (i in 0..it.list.size - 1) {
                Log.e("__" + it.list[i].main!!.temp_max, "__" + it.list[i].main!!.temp_min + ")))")
                var day = DailyTempModel(0, "0", "0", "0")
                day.minTemp = (it.list[i].main!!.temp_min - 273).toString()
                day.maxTemp = (it.list[i].main!!.temp_max - 273).toString()

//                when (it.list[i].weather[0].icon) {
//                    1 -> print("x == 1")
//                    2 -> print("x == 2")
//                    else -> { // Note the block
//                        print("x is neither 1 nor 2")
//                    }
//                }
                models.add(day)
                println(i)
            }
            adapter = DailyWeatherAdapter(models, this)
            rvDailyForecast.adapter = adapter


        })
    }
}