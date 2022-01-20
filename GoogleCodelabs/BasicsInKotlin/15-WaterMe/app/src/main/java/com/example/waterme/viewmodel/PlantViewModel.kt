package com.example.waterme.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.work.*
import com.example.waterme.data.DataSource
import com.example.waterme.worker.WaterReminderWorker
import kotlinx.coroutines.delay
import java.util.concurrent.TimeUnit

class PlantViewModel(application: Application) : ViewModel() {

    val plants = DataSource.plants

    companion object {
        private const val WORK_NAME = "schedule_reminder"
    }

    private val workManager = WorkManager.getInstance(application)

    internal fun scheduleReminder(
        duration: Long,
        timeUnit: TimeUnit,
        plantName: String
    ) {
        val dataInstance = createDataInstance(plantName)
        val workRequest = OneTimeWorkRequestBuilder<WaterReminderWorker>()
            .keepResultsForAtLeast(duration, timeUnit)
            .setInputData(dataInstance)
            .build()
        workManager
            .beginUniqueWork(
                WORK_NAME,
                ExistingWorkPolicy.REPLACE,
                workRequest
            )
            .enqueue()
    }

    private fun createDataInstance(plantName: String): Data = Data
        .Builder()
        .putString(WaterReminderWorker.NAME_KEY, plantName)
        .build()
}

class PlantViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(PlantViewModel::class.java)) {
            PlantViewModel(application) as T
        } else {
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}
