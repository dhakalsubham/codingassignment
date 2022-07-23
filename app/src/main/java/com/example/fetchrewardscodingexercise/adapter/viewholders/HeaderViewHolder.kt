package com.example.fetchrewardscodingexercise.adapter.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fetchrewardscodingexercise.databinding.RowHeaderBinding
import com.example.fetchrewardscodingexercise.model.ListItem

class HeaderViewHolder(val binding: RowHeaderBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(skillItem: ListItem.HeaderItem) {
        binding.textViewHeader.text = skillItem.listId.toString()

    }
    companion object {
        fun from(parent: ViewGroup): HeaderViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = RowHeaderBinding.inflate(layoutInflater, parent, false)
            return HeaderViewHolder(binding)
        }
    }
}