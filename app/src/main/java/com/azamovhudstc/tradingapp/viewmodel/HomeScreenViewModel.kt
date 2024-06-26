package com.azamovhudstc.tradingapp.viewmodel

import androidx.lifecycle.MutableLiveData
import com.azamovhudstc.firebase_data.response.ProfileResponse
import com.azamovhudstc.tradingapp.data.fake.MarketItem
import com.azamovhudstc.tradingapp.data.remote.response.MarketResponse
import com.azamovhudstc.tradingapp.data.remote.response.stock.StockResponse
import com.azamovhudstc.tradingapp.utils.Resource

interface HomeScreenViewModel {
    val getMarketData: MutableLiveData<Resource<MarketResponse>>
    val stockLiveData: MutableLiveData<Resource<StockResponse>>
    val profileLiveData: MutableLiveData<Resource<ProfileResponse>>
    fun getStocks()
    fun loadProfileData()
    fun loadMarketData()
}