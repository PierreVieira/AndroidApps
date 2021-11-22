package com.example.stateflow

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.example.stateflow.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.collect

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    @SuppressLint("ShowToast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupLoginButton()
        lifecycleScope.launchWhenStarted {
            viewModel.loginUiState.collect {
                when (it) {
                    is MainViewModel.LoginUiState.Empty -> Unit
                    is MainViewModel.LoginUiState.Error -> {
                        Snackbar.make(
                            binding.root,
                            it.message,
                            Snackbar.LENGTH_LONG
                        ).show()
                        binding.progressBar.isVisible = false
                    }
                    is MainViewModel.LoginUiState.Loading -> {
                        binding.progressBar.isVisible = true
                    }
                    is MainViewModel.LoginUiState.Success -> {
                        Snackbar.make(
                            binding.root,
                            "Successfully logged in",
                            Snackbar.LENGTH_LONG
                        ).show()
                        binding.progressBar.isVisible = false
                    }
                }
            }
        }
    }

    private fun setupLoginButton() {
        binding.btnLogin.setOnClickListener {
            viewModel.login(
                binding.etUsername.text.toString(),
                binding.etPassword.text.toString(),
            )
        }
    }
}