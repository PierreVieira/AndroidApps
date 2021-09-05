package com.example.crud.ui.screens.home

import androidx.lifecycle.ViewModel
import com.example.crud.repositories.CityRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: CityRepository) : ViewModel() {

}