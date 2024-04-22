package com.azamovhudstc.tradingapp.ui.screen.coin

import androidx.viewpager2.widget.ViewPager2
import com.azamovhudstc.tradingapp.R
import com.azamovhudstc.tradingapp.base.BaseFragment
import com.azamovhudstc.tradingapp.databinding.CoinScreenBinding
import com.azamovhudstc.tradingapp.ui.screen.coin.adapter.PagerAdapter
import com.azamovhudstc.tradingapp.utils.slideUp


class CoinScreen : BaseFragment<CoinScreenBinding>(CoinScreenBinding::inflate) {
    private val pageAdapter by lazy { PagerAdapter(requireActivity()) }
    private var isSelected = false
    override fun onViewCreate() {
        binding.coinTxt.slideUp(700, 1)
        binding.apply {
            linearLayout6.slideUp(700, 1)
            binding.pagerCoin.adapter = pageAdapter
            if (isSelected) {
                binding.withdrawTxt.setTextColor(requireActivity().getColor(R.color.basic_color))
                binding.pagerCoin.currentItem = 1
                binding.depositTxt.setTextColor(requireActivity().getColor(R.color.textColor))
            } else {
                binding.withdrawTxt.setTextColor(requireActivity().getColor(R.color.textColor))
                binding.pagerCoin.currentItem = 0
                binding.depositTxt.setTextColor(requireActivity().getColor(R.color.basic_color))

            }
            binding.withdrawTxt.setOnClickListener {
                isSelected = false
                binding.withdrawTxt.setTextColor(requireActivity().getColor(R.color.basic_color))
                binding.pagerCoin.currentItem = 1
                binding.depositTxt.setTextColor(requireActivity().getColor(R.color.textColor))

            }

            binding.depositTxt.setOnClickListener {
                isSelected = true
                binding.withdrawTxt.setTextColor(requireActivity().getColor(R.color.textColor))
                binding.pagerCoin.currentItem = 0
                binding.depositTxt.setTextColor(requireActivity().getColor(R.color.basic_color))
            }

            binding.pagerCoin.isUserInputEnabled=false
        }
    }

}