package com.azamovhudstc.tradingapp.ui.screen.profile

import com.azamovhudstc.tradingapp.base.BaseFragment
import com.azamovhudstc.tradingapp.databinding.ProfileScreenBinding
import com.azamovhudstc.tradingapp.local.LocalHome
import com.azamovhudstc.tradingapp.ui.screen.profile.adapter.ProfileAdapter


class ProfileScreen : BaseFragment<ProfileScreenBinding>(ProfileScreenBinding::inflate) {
    private val profileAdapter by lazy { ProfileAdapter() }
    override fun onViewCreate() {

        binding.apply {
            profileRv.adapter = profileAdapter
            profileAdapter.submitList(LocalHome.loadProfileList())

        }
    }
}
