package com.example.fetchrewardscodingexercise.adapter.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fetchrewardscodingexercise.databinding.RowItemBinding
import com.example.fetchrewardscodingexercise.model.ListItem


class RowItemViewHolder(val binding: RowItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(skillItem: ListItem.RowItem) {
        binding.textViewName.text=skillItem.itemModel.name

    }

    companion object {
        fun from(parent: ViewGroup): RowItemViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = RowItemBinding.inflate(layoutInflater, parent, false)
            return RowItemViewHolder(binding)
        }
    }
}