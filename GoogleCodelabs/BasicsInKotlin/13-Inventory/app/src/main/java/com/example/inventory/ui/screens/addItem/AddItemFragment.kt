package com.example.inventory.ui.screens.addItem

import android.content.Context.INPUT_METHOD_SERVICE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.inventory.InventoryApplication
import com.example.inventory.data.Item
import com.example.inventory.databinding.FragmentAddItemBinding
import com.example.inventory.ui.inventoryViewModel.InventoryViewModel
import com.example.inventory.ui.inventoryViewModel.InventoryViewModelFactory
import com.example.inventory.ui.screens.ItemDetailFragmentArgs

class AddItemFragment : Fragment() {

    private val navigationArgs: ItemDetailFragmentArgs by navArgs()

    private var _binding: FragmentAddItemBinding? = null
    private val binding get() = _binding!!
    private val viewModel: InventoryViewModel by activityViewModels {
        InventoryViewModelFactory(
            (activity?.application as InventoryApplication).database.itemDao()
        )
    }
    lateinit var item: Item

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupSaveButton()
        val id = navigationArgs.itemId
        if (id > 0) {
            viewModel.retrieveItem(id).observe(viewLifecycleOwner) { selectedItem ->
                bind(selectedItem)
            }
        } else {
            binding.saveButton.setOnClickListener {
                addNewItem()
            }
        }
    }

    private fun bind(item: Item) {
        val price = "%.2f".format(item.price)
        binding.apply {
            itemName.setText(item.name, TextView.BufferType.SPANNABLE)
            itemPrice.setText(price, TextView.BufferType.SPANNABLE)
            itemCount.setText(item.quantityInStock.toString(), TextView.BufferType.SPANNABLE)
            saveButton.setOnClickListener { updateItem() }
        }
    }

    private fun setupSaveButton() {
        binding.saveButton.setOnClickListener {
            addNewItem()
        }
    }

    private fun updateItem() {
        if (isEntryValid()) {
            viewModel.updateItem(
                navigationArgs.itemId,
                binding.itemName.text.toString(),
                binding.itemPrice.text.toString(),
                binding.itemCount.text.toString()
            )
            val action = AddItemFragmentDirections.actionAddItemFragmentToItemListFragment()
            findNavController().navigate(action)
        }
    }

    private fun isEntryValid() = viewModel.isEntryValid(
        binding.itemName.text.toString(),
        binding.itemPrice.text.toString(),
        binding.itemCount.text.toString()
    )

    private fun addNewItem() {
        if (isEntryValid()) {
            viewModel.addNewItem(
                binding.itemName.text.toString(),
                binding.itemPrice.text.toString(),
                binding.itemCount.text.toString(),
            )
            backNavigation()
        }
    }

    private fun backNavigation() {
        val action = AddItemFragmentDirections.actionAddItemFragmentToItemListFragment()
        findNavController().navigate(action)
    }

    private fun hideKeyboard() {
        val inputMethodManager = requireActivity().getSystemService(INPUT_METHOD_SERVICE) as
            InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(requireActivity().currentFocus?.windowToken, 0)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        hideKeyboard()
        _binding = null
    }
}
