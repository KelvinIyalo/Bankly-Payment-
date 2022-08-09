package com.kelviniyalo.banklypay.module

import com.google.gson.annotations.SerializedName

data class Transactions(
    @SerializedName("data")
    val TransactionData: List<Data>
)