package com.example.wordsapp

import androidx.navigation.findNavController

class LetterAdapter : ButtonListAdapter(('A').rangeTo('Z').toList()) {

    override fun onBindViewHolder(holder: ButtonViewHolder, position: Int) {
        val item = list[position]
        holder.button.apply {
            text = item.toString()
            setOnClickListener {
                val action = LetterListFragmentDirections
                    .actionLetterListFragmentToWordListFragment(letter = holder.button.text.toString())
                holder.view.findNavController().navigate(action)
            }
        }
    }
}