package com.example.fetchrewardscodingexercise.viewmodel

import NetworkResponse
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fetchrewardscodingexercise.model.ItemModel
import com.example.fetchrewardscodingexercise.model.ListItem
import com.example.fetchrewardscodingexercise.repo.MainActivityRepo
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {

    init {
        fetchItems()
    }

    val itemListLiveData = MutableLiveData<MutableList<ListItem>?>()
    fun fetchItems() {
        viewModelScope.launch {
            MainActivityRepo.fetchListItem().let { response ->
                when (response) {
                    is NetworkResponse.Success -> {
                        itemListLiveData.postValue(response.data?.let { itemModelToListItem(it) })
                    }
                    is NetworkResponse.Error -> {
                        itemListLiveData.postValue(null)
                    }
                }
            }
        }
    }
}

private fun itemModelToListItem(allItems: MutableList<ItemModel>): MutableList<ListItem> {
    val sortedDistinctGroup = allItems.distinctBy { itemModel ->
        itemModel.listId
    }.sortedBy { itemModel -> itemModel.listId }
    val list = mutableListOf<ListItem>()
    allItems.removeIf { value -> value.name == " " || value.name.isNullOrEmpty() }
    allItems.sortWith(compareBy({ it.listId }, { it.id }))
    sortedDistinctGroup.forEach { listId ->
        list.add(ListItem.HeaderItem(listId.listId))
        allItems.forEach() {
            if (listId.listId == it.listId) {
                list.add(ListItem.RowItem(it))
            }
        }
    }
    return list
}