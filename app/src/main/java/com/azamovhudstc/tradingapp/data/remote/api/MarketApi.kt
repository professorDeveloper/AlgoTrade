package com.azamovhudstc.tradingapp.data.remote.api

import com.azamovhudstc.tradingapp.data.fake.MarketItem
import com.azamovhudstc.tradingapp.data.remote.response.MarketResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface MarketApi {
    @GET("/v1/cryptocurrency/listings/latest")
    suspend fun getMarketApi(@Header("X-CMC_PRO_API_KEY") X_CMC_PRO_API_KEY: String="0975f460-d483-4a67-9a35-df6fa32302ca"): Response<MarketResponse>

}