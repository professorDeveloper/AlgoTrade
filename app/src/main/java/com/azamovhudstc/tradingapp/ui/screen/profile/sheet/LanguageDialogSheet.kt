package com.azamovhudstc.tradingapp.ui.screen.profile.sheet

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import com.azamovhudstc.tradingapp.R
import com.azamovhudstc.tradingapp.databinding.ChangeLanguageBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class LanguageDialogSheet : BottomSheetDialogFragment() {
    private var _binding: ChangeLanguageBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ChangeLanguageBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("CutPasteId")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            topRadio1.setOnCheckedChangeListener { group, checkedId ->
                if (checkedId != -1) {
                    when (checkedId) {
                        R.id.uzbekBtn -> {
                            val radioButton = binding.root.findViewById<RadioButton>(R.id.uzbekBtn)
                            radioButton.isChecked = true
                        }
                        R.id.englishBtn -> {
                            val radioButton =
                                binding.root.findViewById<RadioButton>(R.id.englishBtn)
                            radioButton.isChecked = true

                        }
                    }
                }
            }
            topRadio2.setOnCheckedChangeListener { group, checkedId ->
                if (checkedId != -1) {
                    when (checkedId) {
                        R.id.russianBtn -> {
                            val radioButton = binding.root.findViewById<RadioButton>(R.id.russianBtn)
                            radioButton.isChecked = true
                            topRadio1.clearCheck()


                        }
                        R.id.indianBtn -> {
                            val radioButton = binding.root.findViewById<RadioButton>(R.id.indianBtn)
                            radioButton.isChecked = true
                            topRadio1.clearCheck()

                        }
                    }
                }
            }

        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}
