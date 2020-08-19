package com.anice.weatherforcast.data.model

import android.R
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import java.io.Serializable


class WeaherForcast : Serializable {
    var city: WeaherForcastCity? = null
    var cnt = 0
    var cod: String? = null
    var message = 0
    lateinit var list: Array<WeaherForcastList>

    companion object {
        private const val serialVersionUID = -4519428055103846995L
    }


}