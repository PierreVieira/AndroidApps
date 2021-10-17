package com.example.inventory.ui.inventoryViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.inventory.data.Item
import com.example.inventory.data.ItemDao
import kotlinx.coroutines.launch

class InventoryViewModel(private val itemDao: ItemDao) : ViewModel() {
    private fun insertItem(item: Item) {
        viewModelScope.launch {
            itemDao.inset(item)
        }
    }

    private fun getNewItemEntry(itemName: String, itemPrice: String, itemCount: String) = Item(
        name = itemName,
        price = itemPrice.toDouble(),
        quantityInStock = itemCount.toInt()
    )

    fun addNewItem(itemName: String, itemPrice: String, itemCount: String) {
        val newItem = getNewItemEntry(itemName, itemPrice, itemCount)
        insertItem(newItem)
    }

    fun isEntryValid(itemName: String, itemPrice: String, itemCount: String) =
        itemName.isNotBlank() && itemPrice.isNotBlank() && itemCount.isNotBlank()
}
