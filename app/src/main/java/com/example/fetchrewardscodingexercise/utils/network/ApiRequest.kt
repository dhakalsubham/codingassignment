package com.example.fetchrewardscodingexercise.utils.network

import com.example.fetchrewardscodingexercise.repo.MainActivityApiService


object ApiRequest {
    val appApi: MainActivityApiService by lazy {
        ApiRetrofit.retrofit.create(MainActivityApiService::class.java)
    }
}