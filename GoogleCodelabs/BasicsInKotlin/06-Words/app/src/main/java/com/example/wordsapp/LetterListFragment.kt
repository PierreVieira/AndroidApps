package com.example.wordsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wordsapp.databinding.FragmentLetterListBinding


class LetterListFragment : Fragment() {

    private var _binding: FragmentLetterListBinding? = null
    private val binding get() = _binding!!
    private var isLinearLayoutManager = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLetterListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.recyclerView.apply {
            layoutManager = this@LetterListFragment.getLayoutManager()
            adapter = LetterAdapter()
        }
    }

    private fun getLayoutManager() = if (isLinearLayoutManager) {
        LinearLayoutManager(requireContext())
    } else {
        GridLayoutManager(requireContext(), 4)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.layout_menu, menu)
        val layoutButton = menu.findItem(R.id.action_switch_layout)
        setIcon(layoutButton)
    }

    override fun onOptionsItemSelected(item: MenuItem) =
        if (item.itemId == R.id.action_switch_layout) {
            isLinearLayoutManager = !isLinearLayoutManager
            binding.recyclerView.layoutManager = getLayoutManager()
            setIcon(item)
            true
        } else throw IllegalArgumentException("Untracked menu option")

    private fun setIcon(menuItem: MenuItem?) {
        menuItem?.let {
            it.icon = if (isLinearLayoutManager)
                ContextCompat.getDrawable(requireContext(), R.drawable.ic_grid_layout)
            else ContextCompat.getDrawable(requireContext(), R.drawable.ic_linear_layout)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}