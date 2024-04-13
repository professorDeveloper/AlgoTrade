package com.azamovhudstc.tradingapp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.azamovhudstc.tradingapp.R
import com.azamovhudstc.tradingapp.tools.initActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initActivity(this)
    }
}