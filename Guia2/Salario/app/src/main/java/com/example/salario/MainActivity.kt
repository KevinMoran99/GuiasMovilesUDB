package com.example.salario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.salario.databinding.ActivityMainBinding

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
            calc.setOnClickListener { calcWage() }
        }
    }

    private fun calcWage() {
        val context: MainActivity = this
        binding.apply {
            if (name.text.isNullOrEmpty() || hours.text.isNullOrEmpty() || hours.text.toString().toDouble() < 0.0) {
                Toast.makeText(context, getString(R.string.not_valid), Toast.LENGTH_SHORT).show()
                return
            }

            val hours = hours.text.toString().toDouble()
            val wage = hours * 8.5
            val isss = wage * 0.02
            val afp = wage * 0.03
            val rent = wage * 0.04
            val netWage = wage - isss - afp - rent

            val intent = Intent(context, WageActivity::class.java)
            val bundle = Bundle()
            bundle.apply {
                this.putString(WageActivity.name, binding.name.text.toString())
                this.putString(WageActivity.baseWage, toDecimalString(wage))
                this.putString(WageActivity.isss, toDecimalString(isss))
                this.putString(WageActivity.afp, toDecimalString(afp))
                this.putString(WageActivity.rent, toDecimalString(rent))
                this.putString(WageActivity.netWage, toDecimalString(netWage))
            }
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }

    private fun toDecimalString(value: Double): String {
        return String.format("%.2f", value)
    }
}