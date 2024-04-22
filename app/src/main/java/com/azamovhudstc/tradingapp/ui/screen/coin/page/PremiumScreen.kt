package com.azamovhudstc.tradingapp.ui.screen.coin.page

import android.view.animation.LayoutAnimationController
import com.azamovhudstc.tradingapp.base.BaseFragment
import com.azamovhudstc.tradingapp.databinding.PreiumScreenBinding
import com.azamovhudstc.tradingapp.local.LocalHome
import com.azamovhudstc.tradingapp.ui.screen.coin.adapter.CoinAdapter
import com.azamovhudstc.tradingapp.utils.setSlideIn
import com.azamovhudstc.tradingapp.utils.slideUp


class PremiumScreen : BaseFragment<PreiumScreenBinding>(PreiumScreenBinding::inflate) {
    private val coinAdapter by lazy { CoinAdapter() }
    override fun onViewCreate() {
        binding.apply {
            shapeableImageView2.slideUp(700, 1)
            recyclerView.layoutAnimation = LayoutAnimationController(setSlideIn(), 0.25f)
            recyclerView.adapter = coinAdapter
            coinAdapter.submitList(LocalHome.localCoinData())
        }
    }

}