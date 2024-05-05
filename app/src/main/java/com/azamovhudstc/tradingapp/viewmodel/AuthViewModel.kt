package com.azamovhudstc.tradingapp.viewmodel

import androidx.lifecycle.MutableLiveData
import com.azamovhudstc.auth_firebase.request.LoginRequest
import com.azamovhudstc.auth_firebase.request.RegisterRequest
import com.azamovhudstc.tradingapp.utils.Resource

interface AuthViewModel {
    fun loginRequest(request: LoginRequest)
    fun registerRequest(request: RegisterRequest)
     val loginObserveData:MutableLiveData<Resource<Unit>>
     val registerObserveData:MutableLiveData<Resource<Unit>>
}