package com.example.wordsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

abstract class ButtonListAdapter(val list: List<Any>) :
    RecyclerView.Adapter<ButtonListAdapter.ButtonViewHolder>() {
    override fun getItemCount() = list.size

    inner class ButtonViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val button: Button = view.findViewById(R.id.button_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ButtonViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        layout.accessibilityDelegate = Accessibility
        return ButtonViewHolder(layout)
    }
}