package com.example.fetchrewardscodingexercise.model

sealed class ListItem {
    data class RowItem(val itemModel: ItemModel) : ListItem()
    data class HeaderItem(val listId: Int) : ListItem()
}

enum class ListItemType {
    ROW, HEADER
}
