package com.azamovhudstc.tradingapp.ui.screen

import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.azamovhudstc.firebase_data.request.RegisterRequest
import com.azamovhudstc.tradingapp.R
import com.azamovhudstc.tradingapp.base.BaseFragment
import com.azamovhudstc.tradingapp.databinding.RegisterScreenBinding
import com.azamovhudstc.tradingapp.utils.*
import com.azamovhudstc.tradingapp.viewmodel.impl.AuthViewModelImpl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterScreen : BaseFragment<RegisterScreenBinding>(RegisterScreenBinding::inflate) {
    private val model by viewModels<AuthViewModelImpl>()
    override fun onViewCreate() {
        binding.loginImg.slideTop(800, 0)
        binding.textView.slideTop(800, 0)

        binding.materialButton.slideUp(800, 0)
        checkIsReadyRegister()
        observeData()

    }

    private fun observeData() {
        model.registerObserveData.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Error -> {
                    toast(it.throwable.message)
                    binding.materialButton.finished()
                }
                Resource.Loading -> {
                    binding.materialButton.loading()

                }
                is Resource.Success -> {
                    binding.materialButton.finished()
                    toast("User Added Successfully")
                    findNavController().navigate(
                        R.id
                            .mainScreen,
                        null,
                        animationTransactionClearStack(R.id.registerScreen).build()
                    )
                }
            }
        }
    }

    private fun checkIsReadyRegister() {
        binding.apply {
            nameTxt.addTextChangedListener(textWatcher)
            emailTxt.addTextChangedListener(textWatcher)
            passwordTxt.addTextChangedListener(textWatcher)
            rePasswordTxt.addTextChangedListener(textWatcher)

            materialButton.isEnabled = false


            binding.materialButton.setOnClickListener {


                model.registerRequest(
                    RegisterRequest(
                        name = nameTxt.text.toString(),
                        lastName = lastNameTxt.text.toString(),
                        password = passwordTxt.text.toString(),
                        email = emailTxt.text.toString()
                    )
                )
            }
        }
    }

    private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            // Check if the user data is valid and enable/disable the registration button accordingly
            binding.materialButton.isEnabled = isUserDataValid(
                binding.nameTxt.text.toString().trim(),
                binding.emailTxt.text.toString().trim(),
                binding.rePasswordTxt.text.toString().trim(),
                binding.passwordTxt.text.toString().trim()
            )
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            // Not used, but required by TextWatcher interface
        }
    }


}