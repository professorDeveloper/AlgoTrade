package com.azamovhudstc.tradingapp.viewmodel.impl

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.azamovhudstc.tradingapp.utils.loadData
import com.azamovhudstc.tradingapp.viewmodel.MainViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class MainViewModelImpl @Inject constructor(
    @ApplicationContext applicationContext: Context
) : ViewModel(), MainViewModel {
    override val loginScreenLiveData = MutableLiveData<Unit>()
    override val homeScreenLiveData = MutableLiveData<Unit>()

    init {
        if (loadData<String>("userToken") != null) {
            homeScreenLiveData.value = Unit
        } else {
            loginScreenLiveData.value = Unit
        }

    }
}
