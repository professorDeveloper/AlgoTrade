package com.azamovhudstc.auth_firebase.repository

import com.azamovhudstc.auth_firebase.request.LoginRequest
import com.azamovhudstc.auth_firebase.request.RegisterRequest
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    fun registerRequest(registerRequest: RegisterRequest): Flow<Result<String>>
    fun loginRequest(loginRequest: LoginRequest): Flow<Result<String>>
}