package com.example.fetchrewardscodingexercise.repo
import com.example.fetchrewardscodingexercise.model.ItemModel
import retrofit2.Response
import retrofit2.http.GET

interface MainActivityApiService {
    @GET("/hiring.json")
    suspend fun getItems():Response<MutableList<ItemModel>>
}