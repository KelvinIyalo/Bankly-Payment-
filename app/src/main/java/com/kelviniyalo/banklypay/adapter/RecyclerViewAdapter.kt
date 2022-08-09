package com.kelviniyalo.banklypay.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.kelviniyalo.banklypay.databinding.PayLayoutBinding
import com.kelviniyalo.banklypay.module.Data
import java.text.SimpleDateFormat

class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            PayLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = differ.currentList[position]
        holder.binding.apply {

            transactionHeading.text = article.transactionTypeName
            transactionAmount.text = article.amount.toString()
            transactionStatus.text = article.statusName
            transactionDate.text = article.transactionDate?.let { dateAndTimeFormatter(it) }


        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    private val diffCallback = object : DiffUtil.ItemCallback<Data>() {
        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.reference == newItem.reference
        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem == newItem
        }

    }
    val differ = AsyncListDiffer(this, diffCallback)


    @SuppressLint("SimpleDateFormat")
    private fun dateAndTimeFormatter(dateAndTime: String): String {
        val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS").parse(dateAndTime)
        return SimpleDateFormat("dd, MMM yyyy HH:mm:ss a").format(format!!)
    }
    inner class ViewHolder(val binding: PayLayoutBinding) : RecyclerView.ViewHolder(binding.root)
}

