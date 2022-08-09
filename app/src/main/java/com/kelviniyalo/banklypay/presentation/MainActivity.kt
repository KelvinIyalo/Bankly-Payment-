package com.kelviniyalo.banklypay.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.kelviniyalo.banklypay.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var fragmentAdapter: FragmentAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewPager = binding.viewPager
        fragmentAdapter = FragmentAdapter(supportFragmentManager)
        fragmentAdapter.addFragment(AllTransactionsFragment(), "All")
        fragmentAdapter.addFragment(CreditTransactionsFragment(), "Credit")
        fragmentAdapter.addFragment(DebitTransactionsFragment(), "Debit")
        viewPager.adapter = fragmentAdapter
        binding.tabLayout.setupWithViewPager(viewPager)
        binding.filter.setOnClickListener {
            singleChoiceDialog()
        }
    }

    private fun singleChoiceDialog() {
        val list = arrayOf("A - Z", "Amount", "Status")
        val dialog = AlertDialog.Builder(this)
        dialog.apply {

            setTitle("Filter By")
            setSingleChoiceItems(list, -1) { dialogInterface, i ->
                binding.filter.text = list[i]
                dialogInterface.dismiss()
            }
            setNeutralButton("Cancel") { dialogInterface, i ->
                dialogInterface.cancel()
            }

        }

        val mDialog = dialog.create()
        mDialog.show()

    }
}
