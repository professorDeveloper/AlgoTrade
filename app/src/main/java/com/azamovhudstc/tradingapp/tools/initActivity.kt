package com.azamovhudstc.tradingapp.tools

import android.app.Activity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat

fun initActivity(a: Activity) {
    val window = a.window
    WindowCompat.setDecorFitsSystemWindows(window, false)

}
fun Double.format(digits: Int) = "%.${digits}f".format(this)
