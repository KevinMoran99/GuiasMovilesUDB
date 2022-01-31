package com.example.operacionesbasicas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.operacionesbasicas.databinding.ActivityMainBinding

enum class Operation {
    ADD, SUBTRACT, MULTIPLY, DIVIDE
}

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUi()
    }

    private fun setupUi() {
        binding.apply {
            add.setOnClickListener {
                operate(Operation.ADD)
            }
            subtract.setOnClickListener {
                operate(Operation.SUBTRACT)
            }
            multiply.setOnClickListener {
                operate(Operation.MULTIPLY)
            }
            divide.setOnClickListener {
                operate(Operation.DIVIDE)
            }
        }
    }

    private fun operate(operation: Operation) {
        val context: MainActivity = this
        binding.apply {
            if (txt1.text.isNullOrEmpty() || txt2.text.isNullOrEmpty()) {
                Toast.makeText(context, getString(R.string.not_valid), Toast.LENGTH_SHORT).show()
                return
            }
            if (operation == Operation.DIVIDE && txt2.text.toString().toDouble() == 0.0) {
                Toast.makeText(context, getString(R.string.not_valid), Toast.LENGTH_SHORT).show()
                return
            }
            val numb1: Double = txt1.text.toString().toDouble()
            val numb2: Double = txt2.text.toString().toDouble()

            val result: Double = when(operation){
                Operation.ADD -> numb1 + numb2
                Operation.SUBTRACT -> numb1 - numb2
                Operation.MULTIPLY -> numb1 * numb2
                Operation.DIVIDE ->numb1 / numb2
            }

            val parsedResult: String = String.format("%.2f", result)
            Toast.makeText(context, getString(R.string.result, parsedResult), Toast.LENGTH_SHORT).show()
        }
    }
}