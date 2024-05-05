package com.azamovhudstc.tradingapp.viewmodel

import androidx.lifecycle.LiveData

interface MainViewModel {
    val loginScreenLiveData: LiveData<Unit>
    val homeScreenLiveData: LiveData<Unit>
}
