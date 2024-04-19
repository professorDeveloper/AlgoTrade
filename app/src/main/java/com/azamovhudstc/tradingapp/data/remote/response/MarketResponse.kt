package com.azamovhudstc.tradingapp.data.remote.response

data class MarketResponse(
    val `data`: List<Data>,
    val status: Status
)