package com.azamovhudstc.tradingapp.viewmodel

import androidx.lifecycle.MutableLiveData
import com.azamovhudstc.tradingapp.data.fake.MarketItem
import com.azamovhudstc.tradingapp.data.remote.response.MarketResponse
import com.azamovhudstc.tradingapp.utils.Resource

interface MarketViewModel {
    val getMarketData: MutableLiveData<Resource<MarketResponse>>

    fun loadMarketData()
}