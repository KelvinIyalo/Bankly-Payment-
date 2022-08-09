package com.kelviniyalo.banklypay.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kelviniyalo.banklypay.databinding.FragmentAllTransactionsBinding

class AllTransactionsFragment : Fragment() {
    lateinit var binding: FragmentAllTransactionsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAllTransactionsBinding.inflate(layoutInflater)
        return binding.root
    }

}