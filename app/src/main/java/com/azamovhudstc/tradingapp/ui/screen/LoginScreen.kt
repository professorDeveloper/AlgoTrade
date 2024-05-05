package com.azamovhudstc.tradingapp.ui.screen

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.azamovhudstc.firebase_data.request.LoginRequest
import com.azamovhudstc.tradingapp.R
import com.azamovhudstc.tradingapp.base.BaseFragment
import com.azamovhudstc.tradingapp.databinding.LoginScreenBinding
import com.azamovhudstc.tradingapp.utils.*
import com.azamovhudstc.tradingapp.viewmodel.impl.AuthViewModelImpl
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginScreen : BaseFragment<LoginScreenBinding>(LoginScreenBinding::inflate) {
    private val model by viewModels<AuthViewModelImpl>()
    override fun onViewCreate() {
        binding.apply {

            binding.loginImg.slideUp(1000, 1)
            binding.textView.slideUp(1000, 1)
            binding.loginTxt.slideStart(1000, 1)
            binding.passwordTxt.slideStart(1000, 1)
            binding.forgotPasswordTxt.slideStart(1000, 1)
            binding.linearLayout.animation = setSlideUp()
            binding.materialButton.animation = setSlideUp()
            binding.linearLayout2.animation = setSlideUp()

            binding.registerOpenTxt.setOnClickListener {
                findNavController().navigate(
                    R.id.registerScreen, null,
                    animationTransaction().build()
                )
            }

        }
        checkLoginDataIsCorrect()
        observeData()
    }

    private fun observeData() {
        model.loginObserveData.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Error -> {
                    toast(it.throwable.message)
                    binding.materialButton.isEnabled = true
                }
                Resource.Loading -> {
                    binding.materialButton.isEnabled = false
                }
                is Resource.Success -> {
                    binding.materialButton.isEnabled = true
                    findNavController().navigate(
                        R.id.mainScreen,
                        null,
                        animationTransactionClearStack(R.id.loginScreen).build()
                    )
                    toast("Login successful")
                }
            }
        }
    }

    private fun checkLoginDataIsCorrect() {
        binding.apply {
            materialButton.setOnClickListener {
                val email = loginTxt.text.toString().trim()
                val password = passwordTxt.text.toString().trim()
                if (isEmailValid(email) && isPasswordValid(password)) {
                    model.loginRequest(LoginRequest(email, password))
                } else {
                    toast("Invalid email or password")
                }
            }
        }
    }
}