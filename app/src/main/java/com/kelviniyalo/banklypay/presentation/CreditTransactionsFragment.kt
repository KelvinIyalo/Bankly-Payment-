package com.kelviniyalo.banklypay.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kelviniyalo.banklypay.R
import com.kelviniyalo.banklypay.databinding.FragmentCreditTransactionsBinding

class CreditTransactionsFragment : Fragment(R.layout.fragment_credit_transactions) {
    lateinit var binding: FragmentCreditTransactionsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreditTransactionsBinding.inflate(layoutInflater)

        return binding.root
    }


}