package com.azamovhudstc.tradingapp.ui.screen.wallet.pages

import android.view.animation.LayoutAnimationController
import com.azamovhudstc.tradingapp.base.BaseFragment
import com.azamovhudstc.tradingapp.databinding.DepositeScreenBinding
import com.azamovhudstc.tradingapp.local.LocalHome
import com.azamovhudstc.tradingapp.ui.screen.wallet.adapter.DepositeAdapter
import com.azamovhudstc.tradingapp.utils.setSlideIn

class DepositScreen : BaseFragment<DepositeScreenBinding>(DepositeScreenBinding::inflate) {
    private val depositeAdapter by lazy { DepositeAdapter() }

    override fun onViewCreate() {
        binding.apply {
            binding.recyclerView.layoutAnimation = LayoutAnimationController(setSlideIn(), 0.25f)
            binding.recyclerView.adapter = depositeAdapter
            depositeAdapter.submitList(LocalHome.loadDeposite())


        }
    }

}