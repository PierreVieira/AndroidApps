package com.example.wordsapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wordsapp.databinding.ActivityMainBinding

/**
 * Main Activity and entry point for the app. Displays a RecyclerView of letters.
 */
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var isLinearLayoutManager = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.recyclerView.apply {
            layoutManager = this@MainActivity.getLayoutManager()
            adapter = LetterAdapter()
        }
    }

    private fun getLayoutManager() =
        if (isLinearLayoutManager) LinearLayoutManager(this) else GridLayoutManager(this, 4)

    private fun setIcon(menuItem: MenuItem?) {
        menuItem?.let {
            it.icon = if (isLinearLayoutManager)
                ContextCompat.getDrawable(this, R.drawable.ic_grid_layout)
            else ContextCompat.getDrawable(this, R.drawable.ic_linear_layout)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.layout_menu, menu)
        val layoutButton = menu?.findItem(R.id.action_switch_layout)
        setIcon(layoutButton)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == R.id.action_switch_layout) {
            isLinearLayoutManager = !isLinearLayoutManager
            binding.recyclerView.layoutManager = getLayoutManager()
            setIcon(item)
            true
        } else throw IllegalArgumentException("Not tracked menu option")
    }
}
