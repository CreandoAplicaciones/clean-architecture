package com.pedroperez.mvvmfrases.data.network

import com.pedroperez.mvvmfrases.core.RetrofitHelper
import com.pedroperez.mvvmfrases.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class QuoteService {


    val retrofit = RetrofitHelper.getRetrofit()
    suspend fun getQuotes(): List<QuoteModel> {

        return withContext(Dispatchers.IO) {
            val response: Response<List<QuoteModel>> =
                retrofit.create(QuotesApiClient::class.java).getAllQuote()
            response.body() ?: emptyList()
        }

    }

}