package com.example.affirmations.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.R
import com.example.affirmations.model.Affirmation

class ItemAdapter(private val dataset: List<Affirmation>) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val textView: TextView = view.findViewById(R.id.item_title)
        private val imageView: ImageView = view.findViewById(R.id.image)
        private val resources = view.resources

        fun bindItem(affirmation: Affirmation) {
            textView.text = resources.getString(affirmation.stringResourceId)
            imageView.setImageResource(affirmation.imageResourceId)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.bindItem(item)
    }

    override fun getItemCount() = dataset.size
}