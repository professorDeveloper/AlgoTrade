package com.azamovhudstc.tradingapp.ui.activity

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.azamovhudstc.tradingapp.R
import com.azamovhudstc.tradingapp.tools.initActivity
import com.prongbang.localization.LocalizationAppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class MainActivity : LocalizationAppCompatActivity  () {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initActivity(this)
    }
    override fun onConfigurationChanged(newConfig: Configuration) {
        block?.invoke()
        openPrepareLocalize()
        super.onConfigurationChanged(newConfig)
    }

    fun mySetLocate(locale: Locale, _block: (() -> Unit)) {
        block = _block
        setLocale(locale)
    }

    private var block: (() -> Unit)? = null
}