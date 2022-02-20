package com.example.counter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.counter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: CounterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        liveDataObserver()
        setupUi()
    }

    private fun setupUi() {
        binding.apply {
            add.setOnClickListener {
                viewModel.add()
            }
        }
    }

    private fun liveDataObserver() {
        viewModel.counter.observe(this) {
            binding.counter.text = it.toString()
        }
    }
}