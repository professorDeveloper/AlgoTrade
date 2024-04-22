package com.azamovhudstc.tradingapp.ui.screen.wallet.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.azamovhudstc.tradingapp.ui.screen.wallet.pages.DepositScreen
import com.azamovhudstc.tradingapp.ui.screen.wallet.pages.WithDrawScreen

class PagerAdapter(fragmentManager: FragmentActivity) :
    FragmentStateAdapter(fragmentManager) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> DepositScreen()
            else -> WithDrawScreen()
        }
    }
}