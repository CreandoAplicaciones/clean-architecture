package com.pedroperez.mvvmfrases.domain

import com.pedroperez.mvvmfrases.data.QuoteRepository
import com.pedroperez.mvvmfrases.data.model.QuoteModel

class GetQuotesUseCase {

    private  val repository= QuoteRepository()

    suspend operator fun invoke():List<QuoteModel> = repository.getAllQuotes()



}