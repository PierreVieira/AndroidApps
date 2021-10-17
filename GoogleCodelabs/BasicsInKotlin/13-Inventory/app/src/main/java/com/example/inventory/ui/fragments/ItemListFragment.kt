package com.example.inventory.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.inventory.InventoryApplication
import com.example.inventory.R
import com.example.inventory.databinding.ItemListFragmentBinding
import com.example.inventory.ui.adapters.itemList.ItemListAdapter
import com.example.inventory.ui.inventoryViewModel.InventoryViewModel
import com.example.inventory.ui.inventoryViewModel.InventoryViewModelFactory

class ItemListFragment : Fragment() {

    private var _binding: ItemListFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel: InventoryViewModel by activityViewModels {
        InventoryViewModelFactory(
            (activity?.application as InventoryApplication).database.itemDao()
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ItemListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupFloatingActionButton()
        setupRecycler()
    }

    private fun setupRecycler() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this.context)
        val adapter = ItemListAdapter {

        }
        binding.recyclerView.adapter = adapter
        setupObserver(adapter)
    }

    private fun setupObserver(adapter: ItemListAdapter) {
        viewModel.allItems.observe(this.viewLifecycleOwner) { items ->
            adapter.submitList(items)
        }
    }

    private fun setupFloatingActionButton() {
        binding.floatingActionButton.setOnClickListener {
            val action = ItemListFragmentDirections.actionItemListFragmentToAddItemFragment(
                getString(R.string.add_fragment_title)
            )
            this.findNavController().navigate(action)
        }
    }
}
