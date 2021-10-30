package com.example.assigment.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitController {

    companion object{
        const val BASE_URL = "https://dev-api.com/fruitsBT/"

        fun getRetroInstance(): Retrofit{
            return Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build()
        }
    }
}