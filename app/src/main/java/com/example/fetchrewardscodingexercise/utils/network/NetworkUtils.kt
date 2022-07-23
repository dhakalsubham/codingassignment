package com.example.fetchrewardscodingexercise.utils.network

import ErrorResponse
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.HttpException

object NetworkUtils {
    private val converter: Converter<ResponseBody?, ErrorResponse> = ApiRetrofit.retrofit
            .responseBodyConverter(ErrorResponse::class.java, arrayOfNulls<Annotation>(0))

    fun parseVError(response: ResponseBody? = null, throwable: Throwable? = null): ErrorResponse? {
        return try {
            when {
                response != null -> {
                    converter.convert(response)
                }
                throwable != null && throwable is HttpException -> {
                    throwable.response()?.errorBody()?.let {
                        converter.convert(it)
                    }
                }
                else -> {
                    null
                }
            }
        } catch (e: Exception) {
            null
        }
    }
}