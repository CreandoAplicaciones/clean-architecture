package com.pedroperez.mvvmfrases.data.network

import com.pedroperez.mvvmfrases.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuotesApiClient {
    @GET("/.json/")
    suspend fun getAllQuote():Response<List<QuoteModel>>
}