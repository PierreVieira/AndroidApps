package com.example.wordsapp

import android.content.Context
import android.content.Intent
import android.net.Uri

class WordAdapter(letterId: String, context: Context) : ButtonListAdapter(
    context.resources.getStringArray(R.array.words).toList()
        .filter { it.startsWith(letterId, ignoreCase = true) }
        .shuffled()
        .take(5)
        .sorted()
) {

    override fun onBindViewHolder(holder: ButtonViewHolder, position: Int) {
        val item = list[position] as String
        val context = holder.view.context
        holder.button.apply {
            text = item
            setOnClickListener { openBrowser(item, context) }
        }
    }

    private fun openBrowser(item: String, context: Context) {
        val queryUrl = Uri.parse("${DetailActivity.SEARCH_PREFIX}${item}")
        val intent = Intent(Intent.ACTION_VIEW, queryUrl)
        context.startActivity(intent)
    }
}