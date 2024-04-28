package com.azamovhudstc.tradingapp.repository.impl

import com.azamovhudstc.tradingapp.data.remote.api.StockApi
import com.azamovhudstc.tradingapp.data.remote.response.stock.StockResponse
import com.azamovhudstc.tradingapp.repository.StockRepository
import com.azamovhudstc.tradingapp.utils.logMessage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class StockRepositoryImpl @Inject constructor(private val tradingViewApi: StockApi) :
    StockRepository {
    override fun getStocks() = flow<Result<StockResponse>> {

        val response = tradingViewApi.getStockData()

        if (response.isSuccessful) {
            logMessage(response.body().toString())
            emit(Result.success(response.body()!!))
        } else {
            emit(
                Result.failure(
                    Exception(
                        response
                            .errorBody()?.string()
                    )
                )
            )
        }

    }.flowOn(Dispatchers.IO)
}