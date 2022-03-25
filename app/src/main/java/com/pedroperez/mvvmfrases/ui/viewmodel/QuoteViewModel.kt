package com.pedroperez.mvvmfrases.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pedroperez.mvvmfrases.data.model.QuoteModel
import com.pedroperez.mvvmfrases.data.model.QuoteProvider
import com.pedroperez.mvvmfrases.domain.GetQuotesUseCase
import com.pedroperez.mvvmfrases.domain.GetRandomQuoteUseCase
import kotlinx.coroutines.launch

class QuoteViewModel : ViewModel() {
    val quoteModel = MutableLiveData<QuoteModel>()
    val isLoding = MutableLiveData<Boolean>()

    var getQuotesUseCase = GetQuotesUseCase()
    var getRandomQuotesUseCase = GetRandomQuoteUseCase()

    fun onCreate() {
        viewModelScope.launch {
            val result: List<QuoteModel> = getQuotesUseCase()

            if (!result.isNullOrEmpty()) {

                quoteModel.postValue(result[0])
            }
        }
    }

    fun randomQuote() {
        isLoding.postValue(true)
val quote =getRandomQuotesUseCase()
        if(quote!=null){
            quoteModel.postValue(quote!!)
        }

        isLoding.postValue(false)

    }


}