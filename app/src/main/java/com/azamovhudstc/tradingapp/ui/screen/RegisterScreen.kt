package com.azamovhudstc.tradingapp.ui.screen

import com.azamovhudstc.tradingapp.base.BaseFragment
import com.azamovhudstc.tradingapp.databinding.RegisterScreenBinding
import com.azamovhudstc.tradingapp.utils.slideStart
import com.azamovhudstc.tradingapp.utils.slideTop
import com.azamovhudstc.tradingapp.utils.slideUp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterScreen  :BaseFragment<RegisterScreenBinding>(RegisterScreenBinding::inflate){
    override fun onViewCreate() {
        binding.loginImg.slideTop(800,0)
        binding.textView.slideTop(800,0)
        binding.nameTxt.slideStart(800,0)
        binding.lastNameTxt .slideStart(800,0)
        binding.passwordTxt.slideStart(800,0)
        binding.rePasswordTxt.slideStart(800,0)
        binding.linearLayout3.slideStart(800,0)
        binding.linearLayout4.slideUp(800,0)
        binding.materialButton.slideUp(800,0)
    }

}