package com.example.fetchrewardscodingexercise.utils.network
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiRetrofit {
    val retrofit: Retrofit by lazy { retrofit() }
    val baseUrl = "https://fetch-hiring.s3.amazonaws.com/"
    private fun retrofit(): Retrofit {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl)
                .build()
    }
}

