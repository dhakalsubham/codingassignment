package com.example.fetchrewardscodingexercise.repo

import NetworkResponse
import com.example.fetchrewardscodingexercise.model.ItemModel
import com.example.fetchrewardscodingexercise.utils.network.ApiRequest
import com.example.fetchrewardscodingexercise.utils.network.getNetworkResponse

object MainActivityRepo {
    suspend fun fetchListItem(): NetworkResponse<MutableList<ItemModel>?> {
        return runCatching {
            ApiRequest.appApi.getItems()
        }.getNetworkResponse()
    }

}