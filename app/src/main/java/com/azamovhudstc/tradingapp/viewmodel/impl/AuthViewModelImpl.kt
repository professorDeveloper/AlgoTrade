package com.azamovhudstc.tradingapp.viewmodel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.azamovhudstc.auth_firebase.repository.imp.AuthRepositoryImpl
import com.azamovhudstc.auth_firebase.request.LoginRequest
import com.azamovhudstc.auth_firebase.request.RegisterRequest
import com.azamovhudstc.tradingapp.utils.Resource
import com.azamovhudstc.tradingapp.utils.hasConnection
import com.azamovhudstc.tradingapp.utils.saveData
import com.azamovhudstc.tradingapp.viewmodel.AuthViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class AuthViewModelImpl @Inject constructor(private val repositoryImpl: AuthRepositoryImpl) :
    ViewModel(), AuthViewModel {
    override val loginObserveData: MutableLiveData<Resource<Unit>> = MutableLiveData()
    override val registerObserveData: MutableLiveData<Resource<Unit>> = MutableLiveData()

    override fun loginRequest(request: LoginRequest) {
        if (hasConnection()) {
            registerObserveData.postValue(Resource.Loading)
            repositoryImpl.loginRequest(request).onEach {
                it.onFailure {
                    registerObserveData.postValue(Resource.Error(it))
                }
                it.onSuccess {
                    saveData("userToken", it)
                    registerObserveData.postValue(Resource.Success(Unit))
                }
            }.launchIn(viewModelScope)
        } else {
            registerObserveData.postValue(
                Resource.Error(
                    Exception("No Internet Connection !")
                )
            )
        }
    }

    override fun registerRequest(request: RegisterRequest) {
        if (hasConnection()) {
            registerObserveData.postValue(Resource.Loading)
            repositoryImpl.registerRequest(request).onEach {
                it.onSuccess {
                    saveData("userToken", it)
                    registerObserveData.postValue(
                        Resource.Success(
                            Unit
                        )
                    )
                }
                it.onFailure {
                    registerObserveData.postValue(Resource.Error(it))
                }
            }.launchIn(viewModelScope)
        } else {
            registerObserveData.postValue(Resource.Error(Exception("No Internet Connection !")))
        }
    }


}