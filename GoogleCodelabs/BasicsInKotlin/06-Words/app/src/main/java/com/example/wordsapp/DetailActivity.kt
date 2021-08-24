package com.example.wordsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wordsapp.databinding.ActivityDetailBinding


class DetailActivity : AppCompatActivity() {

    companion object {
        const val LETTER_KEY = "letter"
        const val SEARCH_PREFIX = "https://www.google.com/search?q="
    }

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val letterId = getLetterId()
        setupRecyclerView(letterId)
        title = getString(R.string.detail_prefix) + " " + letterId
    }

    private fun setupRecyclerView(letterId: String) {
        binding.recyclerView.apply {
            val context = this@DetailActivity
            layoutManager = LinearLayoutManager(context)
            adapter = WordAdapter(letterId, context)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }
    }

    private fun getLetterId() : String {
        val letter = intent?.extras?.getString(LETTER_KEY)
        if (letter == null) {
            throw IllegalStateException("Intent in Detail Activity is null")
        } else if (letter.isEmpty()) {
            throw IllegalStateException("Letter in Detail Activity is empty")
        }
        return letter
    }
}