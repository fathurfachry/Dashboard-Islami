package com.fachryff.dashboardislami.menus.zakat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.fachryff.dashboardislami.R
import com.fachryff.dashboardislami.databinding.ActivityMenuZakatBinding
import java.text.NumberFormat
import java.util.*

class MenuZakatActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuZakatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuZakatBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setSupportActionBar(binding.toolbarMenuZakat)
        initView()
    }

    private fun initView() {
        binding.btnZakat.setOnClickListener {
            val formatAmount = NumberFormat.getNumberInstance(Locale("id", "ID"))
                .format(binding.etAmountZakat.getNumericValue())
            binding.tvHartaAmount.text = "Rp $formatAmount"

            if (binding.etAmountZakat.getNumericValue()?.toInt()!! >= 85000000) {
                val zakat = binding.etAmountZakat.getNumericValue()!!.toInt() * (2.5 / 100)
                val formatZakat = NumberFormat.getNumberInstance(Locale("id" , "ID")).format(zakat)
                binding.tvAmountZakat.text = "Rp $formatZakat"
            } else {
                Toast.makeText(
                    this,"Total harta masih belum mencapai nisab (85gr Emas)",
                    Toast.LENGTH_LONG
                ).show()
                binding.tvAmountZakat.text = "Rp 0"
            }

        }
    }
}