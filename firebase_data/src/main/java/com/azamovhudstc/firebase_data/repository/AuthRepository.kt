package com.azamovhudstc.firebase_data.repository

import com.azamovhudstc.firebase_data.request.LoginRequest
import com.azamovhudstc.firebase_data.request.RegisterRequest
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    fun registerRequest(registerRequest: RegisterRequest): Flow<Result<String>>
    fun loginRequest(loginRequest: LoginRequest): Flow<Result<String>>
}