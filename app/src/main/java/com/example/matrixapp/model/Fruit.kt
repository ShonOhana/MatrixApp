package com.example.matrixapp.model

import com.google.gson.annotations.SerializedName

data class FruitList(@SerializedName("fruits") val fruits: List<Fruit>)
data class Fruit(
    val name: String,
    @SerializedName("image")
    val imageUrl: String,
    val description: String,
    val price: Double
)