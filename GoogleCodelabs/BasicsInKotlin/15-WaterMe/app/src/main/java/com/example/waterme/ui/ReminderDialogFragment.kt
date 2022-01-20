package com.example.waterme.ui

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.example.waterme.R
import com.example.waterme.viewmodel.PlantViewModel
import com.example.waterme.viewmodel.PlantViewModelFactory
import java.util.concurrent.TimeUnit

class ReminderDialogFragment(private val plantName: String) : DialogFragment() {

    private val viewModel: PlantViewModel by viewModels {
        PlantViewModelFactory(requireActivity().application)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
                .setTitle(R.string.water_reminder)
                .setItems(R.array.water_schedule_array) { _, position ->
                    val (duration, timeUnit) = when (position) {
                        0 -> 5 to TimeUnit.SECONDS
                        1 -> 1 to TimeUnit.DAYS
                        2 -> 7 to TimeUnit.DAYS
                        3 -> 30 to TimeUnit.DAYS
                        else -> throw IllegalStateException("Invalid time unit")
                    }
                    viewModel.scheduleReminder(duration.toLong(), timeUnit, plantName)
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}
