package com.example.inventory.ui.screens.addItem.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.inventory.data.Item

object ItemListDiffCallback : DiffUtil.ItemCallback<Item>() {
    override fun areItemsTheSame(oldItem: Item, newItem: Item) = oldItem === newItem

    override fun areContentsTheSame(oldItem: Item, newItem: Item) = oldItem.name == newItem.name
}