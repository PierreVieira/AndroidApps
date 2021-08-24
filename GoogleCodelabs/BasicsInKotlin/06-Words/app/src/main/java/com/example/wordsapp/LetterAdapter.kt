package com.example.wordsapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class LetterAdapter : ButtonListAdapter(('A').rangeTo('Z').toList()) {

    override fun onBindViewHolder(holder: ButtonViewHolder, position: Int) {
        val item = list[position]
        val context = holder.view.context
        val intent = Intent(context, DetailActivity::class.java)
        holder.button.apply {
            text = item.toString()
            setOnClickListener {
                intent.putExtra(DetailActivity.LETTER_KEY, holder.button.text.toString())
                context.startActivity(intent)
            }
        }
    }
}