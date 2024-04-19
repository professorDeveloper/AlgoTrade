package com.azamovhudstc.tradingapp.repository.impl

import com.azamovhudstc.tradingapp.data.fake.MarketItem
import com.azamovhudstc.tradingapp.data.remote.api.MarketApi
import com.azamovhudstc.tradingapp.data.remote.response.MarketResponse
import com.azamovhudstc.tradingapp.repository.MarketRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MarketRepositoryImpl @Inject constructor(private val api: MarketApi) : MarketRepository {
    override fun loadMarket() = flow<Result<MarketResponse>> {
        val response = api.getMarketApi("0975f460-d483-4a67-9a35-df6fa32302ca")
        if (response.isSuccessful) {
            emit(Result.success(response.body()!!))
        } else {
            emit(Result.failure(Exception(response.errorBody()?.string())))
        }

    }.flowOn(Dispatchers.IO)

}