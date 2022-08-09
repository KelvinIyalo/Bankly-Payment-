package com.kelviniyalo.banklypay.repository

import android.content.Context
import com.google.gson.Gson
import com.kelviniyalo.banklypay.utils.UiState
import com.kelviniyalo.banklypay.module.Transactions
import java.io.InputStream
import javax.inject.Inject

class Repository @Inject constructor(private val context: Context) {

    private fun loadJson(): String? {
        var input: InputStream? = null
        val jsonString: String

        try {
            input = context.assets.open("json_data.json")
            val size = input.available()
            val buffer = ByteArray(size)
            input.read(buffer)
            jsonString = String(buffer)
            return jsonString
        } catch (ex: Exception) {
            UiState.DisplayError(ex.toString())
            ex.printStackTrace()
        } finally {
            input?.close()
        }
        return null
    }

    fun getTransactions(): Transactions {
        return Gson().fromJson(loadJson(), Transactions::class.java)
    }


}