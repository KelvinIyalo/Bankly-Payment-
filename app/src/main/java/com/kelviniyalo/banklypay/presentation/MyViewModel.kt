package com.kelviniyalo.banklypay.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.kelviniyalo.banklypay.utils.UiState
import com.kelviniyalo.banklypay.module.Transactions
import com.kelviniyalo.banklypay.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(private val repository: Repository):ViewModel() {

    val list:MutableLiveData<Transactions> = MutableLiveData()

    init {
        getAllTransactions()
    }
   internal fun getAllTransactions() = liveData  {
       emit(UiState.Loading)
       list.postValue(repository.getTransactions())
      emit(UiState.Success(repository.getTransactions()))
    }
}