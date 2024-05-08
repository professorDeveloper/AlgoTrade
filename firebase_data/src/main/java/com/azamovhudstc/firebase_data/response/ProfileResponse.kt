package com.azamovhudstc.firebase_data.response

data class ProfileResponse(
    val email: String="",
    val password: String="",
    val name: String="",
    val lastName: String="",
    val profilePic: String="",
    val deviceId: String="",
    val balance :Int =0
)