package com.example.inventory.ui.adapters.itemList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.inventory.data.Item
import com.example.inventory.databinding.ItemListItemBinding

class ItemListAdapter(
    private val onItemClicked: (Item) -> Unit
) : ListAdapter<Item, ItemViewHolder>(ItemListDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ItemViewHolder(
            ItemListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val current = getItem(position)
        holder.itemView.setOnClickListener {
            onItemClicked(current)
        }
        holder.bind(current)
    }

}