package com.example.inventory.ui.screens.addItem.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.inventory.data.Item
import com.example.inventory.data.getFormattedPrice
import com.example.inventory.databinding.ItemListItemBinding

class ItemViewHolder(private val binding: ItemListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Item) {
        binding.apply {
            itemName.text = item.name
            itemPrice.text = item.getFormattedPrice()
            itemQuantity.text = item.quantityInStock.toString()
        }
    }
}