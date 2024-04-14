package com.azamovhudstc.tradingapp.ui.screen.main

import android.view.View
import com.azamovhudstc.tradingapp.R
import com.azamovhudstc.tradingapp.base.BaseFragment
import com.azamovhudstc.tradingapp.databinding.MainScreenBinding
import com.azamovhudstc.tradingapp.ui.screen.main.adapter.BottomNavigationAdapter
import com.azamovhudstc.tradingapp.utils.ZoomOutPageTransformer
import com.azamovhudstc.tradingapp.utils.showWithAnimation
import com.azamovhudstc.tradingapp.utils.visible

class MainScreen : BaseFragment<MainScreenBinding>(MainScreenBinding::inflate) {
    override fun onViewCreate() {
        val mainViewPager = binding.viewPager
        val navbar = binding.navbar
        binding.navbar.visibility = View.VISIBLE
        binding.navbar.showWithAnimation(binding.viewPager)
        binding.viewPager.isUserInputEnabled = false
        binding.viewPager.setPageTransformer(ZoomOutPageTransformer())
        binding.viewPager.adapter = BottomNavigationAdapter(requireActivity())
        navbar.visible()
        navbar.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {

                    navbar.getMenu().getItem(0).setChecked(true);
                    navbar.animate().translationZ(12f).setDuration(200).start()
                    mainViewPager.setCurrentItem(0, false)
                }
                R.id.brows -> {
                    navbar.getMenu().getItem(1).setChecked(true);
                    navbar.animate().translationZ(12f).setDuration(200).start()
                    mainViewPager.setCurrentItem(1, false)
                }
                R.id.list -> {
                    navbar.getMenu().getItem(2).setChecked(true);
                    navbar.animate().translationZ(12f).setDuration(200).start()
                    mainViewPager.setCurrentItem(2, false)
                }
                R.id.account -> {
                    navbar.animate().translationZ(12f).setDuration(200).start()
                    navbar.getMenu().getItem(3).setChecked(true);
                    mainViewPager.setCurrentItem(3, false)

                }
            }
            true
        }
    }


}