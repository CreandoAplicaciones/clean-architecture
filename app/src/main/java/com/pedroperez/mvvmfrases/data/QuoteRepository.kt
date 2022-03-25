package com.pedroperez.mvvmfrases.data

import com.pedroperez.mvvmfrases.data.model.QuoteModel
import com.pedroperez.mvvmfrases.data.model.QuoteProvider
import com.pedroperez.mvvmfrases.data.network.QuoteService

class QuoteRepository {

    private  val api= QuoteService()

    suspend fun getAllQuotes():List<QuoteModel>{
        val response:List<QuoteModel> = api.getQuotes()
        QuoteProvider.quotes= response
        return response
    }
}