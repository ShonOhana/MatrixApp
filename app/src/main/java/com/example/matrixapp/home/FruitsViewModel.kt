package com.example.matrixapp.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.assigment.network.RetrofitController
import com.example.matrixapp.model.FruitList
import com.example.matrixapp.api.FruitApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FruitsViewModel : ViewModel() {

    private val _fruitList = MutableLiveData<FruitList>()

    fun getRecyclerListLiveData(): LiveData<FruitList>{
        return _fruitList
    }

    fun loadFruits(){
        val retrofitInstance = RetrofitController.getRetroInstance().create(FruitApi::class.java)
        val apiCall = retrofitInstance.getFruits()
        apiCall.enqueue(object : Callback<FruitList> {
            override fun onResponse(call: Call<FruitList>, response: Response<FruitList>) {
                if (!response.isSuccessful || response.body() == null || response.code() != 200)
                    return
                _fruitList.postValue(response.body())
            }

            override fun onFailure(call: Call<FruitList>, t: Throwable) {
                t.printStackTrace()
            }

        })
    }
}