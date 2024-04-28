package com.azamovhudstc.tradingapp.data.remote.response.stock

data class DataX(
    val change: Double,
    val marketCap: Long,
    val n: String,
    val no: Int,
    val price: Double,
    val revenue: Double,
    val s: String
)