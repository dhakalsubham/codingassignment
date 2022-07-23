package com.example.fetchrewardscodingexercise.adapter.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fetchrewardscodingexercise.R
import com.example.fetchrewardscodingexercise.databinding.RowItemBinding
import com.example.fetchrewardscodingexercise.model.ListItem


class RowItemViewHolder(private val binding: RowItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: ListItem.RowItem) {
        binding.textViewName.text=itemView.context.getString(R.string.main_activity_name,item.itemModel.name)
        binding.textViewId.text=itemView.context.getString(R.string.main_activity_id,item.itemModel.id.toString())
        binding.textViewListId.text=itemView.context.getString(R.string.main_activity_list_id,item.itemModel.listId.toString())

    }

    companion object {
        fun from(parent: ViewGroup): RowItemViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = RowItemBinding.inflate(layoutInflater, parent, false)
            return RowItemViewHolder(binding)
        }
    }
}