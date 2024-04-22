package com.azamovhudstc.tradingapp.ui.screen.coin.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.azamovhudstc.tradingapp.ui.screen.coin.page.PremiumScreen
import com.azamovhudstc.tradingapp.ui.screen.coin.page.StandartScreen
import com.azamovhudstc.tradingapp.ui.screen.wallet.pages.DepositScreen
import com.azamovhudstc.tradingapp.ui.screen.wallet.pages.WithDrawScreen

class PagerAdapter(fragmentManager: FragmentActivity) :
    FragmentStateAdapter(fragmentManager) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> PremiumScreen()
            else -> StandartScreen()
        }
    }
}