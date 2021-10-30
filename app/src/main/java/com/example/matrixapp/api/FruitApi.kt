package com.example.matrixapp.api

import com.example.matrixapp.model.FruitList
import retrofit2.Call
import retrofit2.http.GET

interface FruitApi {
    @GET("getFruits")
    fun getFruits(): Call<FruitList>
}