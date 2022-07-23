package com.example.fetchrewardscodingexercise.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fetchrewardscodingexercise.adapter.viewholders.HeaderViewHolder
import com.example.fetchrewardscodingexercise.adapter.viewholders.RowItemViewHolder
import com.example.fetchrewardscodingexercise.model.ListItem
import com.example.fetchrewardscodingexercise.model.ListItemType


class ItemsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: MutableList<ListItem> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (ListItemType.values()[viewType]) {
            ListItemType.HEADER -> {
                HeaderViewHolder.from(parent)
            }
            ListItemType.ROW -> {
                RowItemViewHolder.from(parent)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {

        return when (items[position]) {
            is ListItem.HeaderItem -> ListItemType.HEADER.ordinal
            is ListItem.RowItem -> ListItemType.ROW.ordinal
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is HeaderViewHolder -> {
                holder.bind((items[position] as ListItem.HeaderItem))
            }
            is RowItemViewHolder -> {
                holder.bind((items[position] as ListItem.RowItem))
            }
        }
    }

    fun setData(account: MutableList<ListItem>) {
        this.items = account
        notifyDataSetChanged()
    }

}