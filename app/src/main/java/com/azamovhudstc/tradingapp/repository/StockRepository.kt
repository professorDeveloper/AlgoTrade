package com.azamovhudstc.tradingapp.repository

import com.azamovhudstc.tradingapp.data.remote.response.stock.StockResponse
import com.azamovhudstc.tradingapp.utils.Resource
import kotlinx.coroutines.flow.Flow

interface StockRepository {
    fun getStocks() :Flow<Result<StockResponse>>
}