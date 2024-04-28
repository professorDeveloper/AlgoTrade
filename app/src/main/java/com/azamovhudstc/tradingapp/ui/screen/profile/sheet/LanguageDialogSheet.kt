package com.azamovhudstc.tradingapp.ui.screen.profile.sheet

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
            uzbekBtn.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    englishBtn.isChecked = false
                    russianBtn.isChecked = false
                    indianBtn.isChecked = false
                }
            }
            englishBtn.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    uzbekBtn.isChecked = false
                    russianBtn.isChecked = false
                    indianBtn.isChecked = false
                }
            }
            russianBtn.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {

                    englishBtn.isChecked = false
                    uzbekBtn.isChecked = false
                    indianBtn.isChecked = false
                }
            }

            indianBtn.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {

                    englishBtn.isChecked = false
                    russianBtn.isChecked = false
                    uzbekBtn.isChecked = false
                }
            }
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}
