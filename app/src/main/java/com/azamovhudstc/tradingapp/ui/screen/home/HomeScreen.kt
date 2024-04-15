package com.azamovhudstc.tradingapp.ui.screen.home

import android.view.animation.LayoutAnimationController
import com.azamovhudstc.tradingapp.base.BaseFragment
import com.azamovhudstc.tradingapp.databinding.HomeScreenBinding
import com.azamovhudstc.tradingapp.local.LocalHome
import com.azamovhudstc.tradingapp.ui.screen.home.adapter.DiveAdapter
import com.azamovhudstc.tradingapp.ui.screen.home.adapter.MarketAdapter
import com.azamovhudstc.tradingapp.ui.screen.home.adapter.TrendAdapter
import com.azamovhudstc.tradingapp.utils.setSlideIn
import com.azamovhudstc.tradingapp.utils.slideStart
import com.azamovhudstc.tradingapp.utils.slideUp

class HomeScreen : BaseFragment<HomeScreenBinding>(HomeScreenBinding::inflate) {
    private val adapter by lazy { DiveAdapter() }
    private val trendAdapter by lazy { TrendAdapter() }
    private val marketAdapter by lazy { MarketAdapter() }
    override fun onViewCreate() {
        binding.apply {
            binding.partRv.adapter = adapter
            binding.profilePic.slideUp(1200, 0)
            binding.greetingText.slideUp(1200, 0)
            binding.nameTxt.slideUp(1200, 0)
            binding.notificationCard.slideUp(700, 0)
            binding.textView3.slideStart(700, 0)
            binding.cardView.slideStart(700, 0)
            binding.partRv.layoutAnimation = LayoutAnimationController(setSlideIn(), 0.25f)
            binding.trendRv.layoutAnimation = LayoutAnimationController(setSlideIn(), 0.25f)
            binding.marketRv.layoutAnimation = LayoutAnimationController(setSlideIn(), 0.25f)
            adapter.submitList(LocalHome.localDriveItem())
            binding.trendRv.adapter = trendAdapter
            binding.marketRv.adapter = marketAdapter
            marketAdapter.submitList(LocalHome.loadMarketList())
            trendAdapter.submitList(LocalHome.loadTrendList())
//            binding.root.setOnRefreshListener {
//                lifecycleScope.launch {
//                    delay(2000)
//                    binding.partRv.adapter = adapter
//                    binding.profilePic.slideUp(1200, 0)
//                    binding.greetingText.slideUp(1200, 0)
//                    binding.nameTxt.slideUp(1200, 0)
//                    binding.notificationCard.slideUp(700, 0)
//                    binding.textView3.slideStart(700, 0)
//                    binding.cardView.slideStart(700,0)
//                    binding.partRv.layoutAnimation = LayoutAnimationController(setSlideIn(), 0.25f)
//                    binding.trendRv.layoutAnimation = LayoutAnimationController(setSlideIn(), 0.25f)
//                    adapter.submitList(LocalHome.localDriveItem())
//                    binding.trendRv.adapter = trendAdapter
//                    trendAdapter.submitList(LocalHome.loadTrendList())
//                    binding.root.isRefreshing = false
//                }
//            }
        }
    }
}