package com.azamovhudstc.tradingapp.ui.screen.coin

import android.view.animation.LayoutAnimationController
import com.azamovhudstc.tradingapp.base.BaseFragment
import com.azamovhudstc.tradingapp.databinding.CoinScreenBinding
import com.azamovhudstc.tradingapp.local.LocalHome
import com.azamovhudstc.tradingapp.ui.screen.coin.adapter.CoinAdapter
import com.azamovhudstc.tradingapp.utils.setSlideIn
import com.azamovhudstc.tradingapp.utils.slideUp


class CoinScreen : BaseFragment<CoinScreenBinding>(CoinScreenBinding::inflate) {
    private val coinAdapter by lazy { CoinAdapter() }
    override fun onViewCreate() {
        binding.coinTxt.slideUp(700, 1)
        binding.apply {
            linearLayout6.slideUp(700, 1)
            shapeableImageView2.slideUp(700, 1)
            recyclerView.layoutAnimation = LayoutAnimationController(setSlideIn(), 0.25f)
            recyclerView.adapter = coinAdapter
            coinAdapter.submitList(LocalHome.localCoinData())
        }
    }

}