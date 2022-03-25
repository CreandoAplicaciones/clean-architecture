package com.pedroperez.mvvmfrases.domain
import com.pedroperez.mvvmfrases.data.model.QuoteModel
import com.pedroperez.mvvmfrases.data.model.QuoteProvider

class GetRandomQuoteUseCase {

    operator fun invoke():QuoteModel?{
        val quotes:List<QuoteModel> = QuoteProvider.quotes
        if(!quotes.isNullOrEmpty()){
            val randomNumber =(0..quotes.size-1).random()
            return quotes[randomNumber]
        }
        return null

    }
}