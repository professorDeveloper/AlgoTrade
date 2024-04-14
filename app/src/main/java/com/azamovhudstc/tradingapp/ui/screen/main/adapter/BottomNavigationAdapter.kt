package com.azamovhudstc.tradingapp.ui.screen.main.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.azamovhudstc.tradingapp.ui.screen.coin.CoinScreen
import com.azamovhudstc.tradingapp.ui.screen.home.HomeScreen
import com.azamovhudstc.tradingapp.ui.screen.profile.ProfileScreen
import com.azamovhudstc.tradingapp.ui.screen.wallet.WalletScreen

class BottomNavigationAdapter(fragmentManager: FragmentActivity) :
    FragmentStateAdapter(fragmentManager) {

    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HomeScreen()
            1 -> CoinScreen()
            2 -> WalletScreen()
            3 -> ProfileScreen()
            else -> {
                ProfileScreen()
            }
        }
    }
}