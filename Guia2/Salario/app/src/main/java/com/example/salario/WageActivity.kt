package com.example.salario

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.salario.databinding.ActivityWageBinding

class WageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            name.text = intent.getStringExtra(WageActivity.name)
            baseWage.text = getString(R.string.base_wage, intent.getStringExtra(WageActivity.baseWage))
            isss.text = getString(R.string.isss, intent.getStringExtra(WageActivity.isss))
            afp.text = getString(R.string.afp, intent.getStringExtra(WageActivity.afp))
            rent.text = getString(R.string.rent, intent.getStringExtra(WageActivity.rent))
            netWage.text = getString(R.string.net_wage, intent.getStringExtra(WageActivity.netWage))
        }
    }

    companion object {
        const val name = "name"
        const val baseWage = "baseWage"
        const val isss = "isss"
        const val afp = "afp"
        const val rent = "rent"
        const val netWage = "netWage"
    }

}