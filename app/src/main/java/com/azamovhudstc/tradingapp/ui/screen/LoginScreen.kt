package com.azamovhudstc.tradingapp.ui.screen

import androidx.navigation.fragment.findNavController
import com.azamovhudstc.tradingapp.R
import com.azamovhudstc.tradingapp.base.BaseFragment
import com.azamovhudstc.tradingapp.databinding.LoginScreenBinding
import com.azamovhudstc.tradingapp.utils.*
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginScreen : BaseFragment<LoginScreenBinding>(LoginScreenBinding::inflate) {
    override fun onViewCreate() {
        binding.apply {

            binding.loginImg.slideUp(1000,1)
            binding.textView.slideUp(1000,1)
            binding.loginTxt.slideStart(1000,1)
            binding.passwordTxt.slideStart(1000,1)
            binding.forgotPasswordTxt.slideStart(1000,1)
            binding.linearLayout.animation = setSlideUp()
            binding.materialButton.animation= setSlideUp()
            binding.linearLayout2.animation= setSlideUp()
            binding.materialButton.setOnClickListener {
                findNavController().navigate(R.id.walletScreen,null, animationTransaction().build())
            }
            binding.registerOpenTxt.setOnClickListener {
                findNavController().navigate(
                    R.id.registerScreen, null,
                    animationTransaction().build()
                )
            }

        }
    }

}