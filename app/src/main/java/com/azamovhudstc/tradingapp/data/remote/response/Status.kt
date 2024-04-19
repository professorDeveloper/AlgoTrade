package com.azamovhudstc.tradingapp.data.remote.response

data class Status(
    val credit_count: Int,
    val elapsed: Int,
    val error_code: Int,
    val error_message: Any,
    val notice: Any,
    val timestamp: String,
    val total_count: Int
)