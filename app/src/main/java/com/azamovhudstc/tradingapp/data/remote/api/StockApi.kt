package com.azamovhudstc.tradingapp.data.remote.api

import com.azamovhudstc.tradingapp.data.remote.response.stock.StockResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface StockApi {

    @GET("/api/screener/s/f?m=marketCap&s=desc&c=no,s,n,marketCap,price,change,revenue&cn=20&f=marketCap-notzero&p=1&")
    suspend fun getStockData(

    ): Response<StockResponse>
}