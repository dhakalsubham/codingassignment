package com.example.fetchrewardscodingexercise.utils.network

import NetworkResponse
import retrofit2.Response

fun <T> Result<Response<T>>.getNetworkResponse(): NetworkResponse<T?> {
    onFailure {
        return NetworkResponse.Error(NetworkUtils.parseVError(throwable = it))
    }
    getOrNull().let {
        return if (it != null && it.isSuccessful) {
            NetworkResponse.Success(it.body())
        } else {
            NetworkResponse.Error(NetworkUtils.parseVError(response = it?.errorBody()))
        }
    }
}
