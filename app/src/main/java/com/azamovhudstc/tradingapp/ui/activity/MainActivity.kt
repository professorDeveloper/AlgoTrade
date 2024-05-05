package com.azamovhudstc.tradingapp.ui.activity

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavGraph
import androidx.navigation.fragment.NavHostFragment
import com.azamovhudstc.tradingapp.R
import com.azamovhudstc.tradingapp.tools.initActivity
import com.azamovhudstc.tradingapp.viewmodel.MainViewModel
import com.azamovhudstc.tradingapp.viewmodel.impl.MainViewModelImpl
import com.prongbang.localization.LocalizationAppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class MainActivity : LocalizationAppCompatActivity() {
    private lateinit var host: NavHostFragment
    private lateinit var graph: NavGraph
    private val viewModel: MainViewModel by viewModels<MainViewModelImpl>()
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initActivity(this)
        host = supportFragmentManager.findFragmentById(R.id.navHost) as NavHostFragment
        graph = host.navController.navInflater.inflate(R.navigation.app_graph)

        viewModel.homeScreenLiveData.observe(this, openHomeScreenObserver)
        viewModel.loginScreenLiveData.observe(this, getStartedScreenObserver)
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

    private val openHomeScreenObserver = androidx.lifecycle.Observer<Unit> {
        graph.setStartDestination(R.id.mainScreen)
        host.navController.graph = graph

    }
    private val getStartedScreenObserver = androidx.lifecycle.Observer<Unit> {
        graph.setStartDestination(R.id.loginScreen)
        host.navController.graph = graph
    }
    private var block: (() -> Unit)? = null
}