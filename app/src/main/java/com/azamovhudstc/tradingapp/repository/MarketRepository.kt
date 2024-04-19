package com.azamovhudstc.tradingapp.repository

import com.azamovhudstc.tradingapp.data.fake.MarketItem
import com.azamovhudstc.tradingapp.data.remote.response.MarketResponse
import kotlinx.coroutines.flow.Flow

interface MarketRepository {
    fun loadMarket(): Flow<Result<MarketResponse>>

}