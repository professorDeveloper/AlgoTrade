package com.azamovhudstc.tradingapp.viewmodel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.azamovhudstc.firebase_data.repository.imp.HomeRepositoryImpl
import com.azamovhudstc.firebase_data.response.ProfileResponse
import com.azamovhudstc.tradingapp.data.remote.response.MarketResponse
import com.azamovhudstc.tradingapp.data.remote.response.stock.StockResponse
import com.azamovhudstc.tradingapp.repository.MarketRepository
import com.azamovhudstc.tradingapp.repository.impl.StockRepositoryImpl
import com.azamovhudstc.tradingapp.utils.Resource
import com.azamovhudstc.tradingapp.utils.hasConnection
import com.azamovhudstc.tradingapp.utils.loadData
import com.azamovhudstc.tradingapp.viewmodel.HomeScreenViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModelImpl @Inject constructor(
    private val repository: MarketRepository,
    private val stockRepositoryImpl: StockRepositoryImpl,
    private val homeRepositoryImpl: HomeRepositoryImpl,
) : HomeScreenViewModel,
    ViewModel() {
    override val getMarketData: MutableLiveData<Resource<MarketResponse>> = MutableLiveData()
    override val stockLiveData: MutableLiveData<Resource<StockResponse>> = MutableLiveData()
    override val profileLiveData: MutableLiveData<Resource<ProfileResponse>> = MutableLiveData()

    override fun getStocks() {
        if (hasConnection()) {
            stockLiveData.postValue(Resource.Loading)
            stockRepositoryImpl.getStocks().onEach {
                it.onSuccess {
                    stockLiveData.postValue(Resource.Success(it))
                }
                it.onFailure {

                    stockLiveData.postValue(Resource.Error(it))
                }
            }.launchIn(viewModelScope)
        } else {
            stockLiveData.postValue(
                Resource.Error(Exception("No Internet Connection"))
            )
        }
    }

    override fun loadProfileData() {
        profileLiveData.postValue(Resource.Loading)
        homeRepositoryImpl.loadProfile(loadData<String>("userToken")?:"").onEach {
            it.onFailure {
                profileLiveData.postValue(Resource.Error(it))
            }
            it.onSuccess {
                profileLiveData.postValue(Resource.Success(it))

            }
        }.launchIn(viewModelScope)
    }

    override fun loadMarketData() {
        if (hasConnection()) {

            repository.loadMarket().onEach {
                getMarketData.postValue(Resource.Loading)
                it.onSuccess {
                    getMarketData.postValue(Resource.Success(it))
                }
                it.onFailure {
                    getMarketData.postValue(Resource.Error(it))

                }
            }.launchIn(viewModelScope)
        } else {
            getMarketData.postValue(Resource.Error(Exception("No Internet Connection")))

        }
    }
}