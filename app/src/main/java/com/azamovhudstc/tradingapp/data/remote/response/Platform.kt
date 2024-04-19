package com.azamovhudstc.tradingapp.data.remote.response

data class Platform(
    val id: Int,
    val name: String,
    val slug: String,
    val symbol: String,
    val token_address: String
)