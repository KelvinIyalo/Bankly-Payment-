package com.kelviniyalo.banklypay.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.kelviniyalo.banklypay.utils.UiState
import com.kelviniyalo.banklypay.adapter.RecyclerViewAdapter
import com.kelviniyalo.banklypay.databinding.FragmentDebitTransactionsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DebitTransactionsFragment : Fragment() {
    lateinit var binding: FragmentDebitTransactionsBinding
    private val viewModel: MyViewModel by viewModels()
    lateinit var recyclerViewAdapter: RecyclerViewAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDebitTransactionsBinding.inflate(layoutInflater)

        setupRV()

        viewModel.getAllTransactions().observe(viewLifecycleOwner, Observer { uiState ->

            when (uiState) {
                is UiState.Loading -> {
                    showLoading(true)
                }

                is UiState.Success -> {
                    showLoading(false)
                    recyclerViewAdapter.differ.submitList(uiState.data.TransactionData)
                }

                is UiState.DisplayError -> {
                    showLoading(false)
                    showMessage(uiState.error)
                }
            }
        })

        return binding.root
    }

    fun setupRV() {
        recyclerViewAdapter = RecyclerViewAdapter()
        binding.debitRecyclerview.apply {
            adapter = recyclerViewAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    private fun showMessage(message: String) {
        Snackbar.make(binding.root, message, Snackbar.LENGTH_SHORT).show()
    }

    private fun showLoading(show: Boolean) {
        val otherVisibility = if (show) View.VISIBLE else View.INVISIBLE
        binding.apply {
            progressBar.visibility = otherVisibility
        }
    }

}