package com.anice.weatherforcast.view.activity.todo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.anice.weatherforcast.common.liveevent.SingleLiveEvent
import com.anice.weatherforcast.data.model.WeaherForcast
import com.anice.weatherforcast.data.usecase.TodoUseCase
import com.anice.weatherforcast.domain.remote.response.ApiResponse
import com.anice.weatherforcast.domain.remote.response.ErrorResponse
import com.anice.weatherforcast.viewmodel.base.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

public class TodoViewModel @Inject constructor(private val useCase: TodoUseCase) : BaseViewModel() {

    val todoId = MutableLiveData<String>()
    val todoData = MutableLiveData<ApiResponse<WeaherForcast>>()
    val todoDataFailureEvent = SingleLiveEvent<ErrorResponse>()
    val todoDataSuccessEvent = SingleLiveEvent<WeaherForcast>()

    fun getTodoData(todoId : String) {
        // mark api request in progress to true
        apiRequestInProgress.value = true
        todoData.value = null
        // launch coroutines within viewmodel scope
        viewModelScope.launch {
            // get data from network
            val response = useCase.getTodoList(todoId)
            // check network response
            if(response.isSuccessful) {
                Log.e("______",response.data?.list?.get(0)?.main?.temp_max.toString())
//                todoData.value = response.data
//                Log.e("___cc___", todoData.value!!.data?.list?.get(0)?.main?.temp_max.toString())

                todoDataSuccessEvent.value = response.data
//                todoDataSuccessEvent.postValue(response)
                Log.e("rgsrg","ssg"+response.data.toString())


            } else {
                // notify error event
                todoDataFailureEvent.value = response.errorResponse
            }
            // mark api request in progress to false
            apiRequestInProgress.value = false
        }
    }
}