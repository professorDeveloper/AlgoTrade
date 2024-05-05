package com.azamovhudstc.firebase_data.repository

import com.azamovhudstc.firebase_data.response.ProfileResponse
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    fun loadProfile(token: String):Flow <Result<ProfileResponse>>
}