package com.azamovhudstc.tradingapp.ui.screen.profile.sheet

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.azamovhudstc.tradingapp.databinding.ChangeLanguageBinding
import com.azamovhudstc.tradingapp.ui.activity.MainActivity
import com.azamovhudstc.tradingapp.utils.loadData
import com.azamovhudstc.tradingapp.utils.saveData
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*

class LanguageDialogSheet : BottomSheetDialogFragment() {
    private var _binding: ChangeLanguageBinding? = null
    private val binding get() = _binding!!

    private var lang = loadData<String>("lang") ?: "uz"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ChangeLanguageBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun setLocate(language: String) {
        val activity = (requireActivity() as MainActivity)
        activity.mySetLocate(Locale.forLanguageTag(language)) {
            lifecycleScope.launch {
                delay(300)
            }
        }
    }

    @SuppressLint("CutPasteId")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {

            binding.saveLanguageBtn.setOnClickListener {
                setLocate(lang)
                saveData("lang", lang)
                dismiss()
            }

            when (lang) {
                "uz" -> {
                    uzbekBtn.isChecked = true
                }
                "eng" -> {
                    englishBtn.isChecked = true

                }
                "ru" -> {
                    russianBtn.isChecked = true
                }
                "in" -> {
                    indianBtn.isChecked = true
                }
            }

            uzbekBtn.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    lang = "uz"
                    englishBtn.isChecked = false
                    russianBtn.isChecked = false
                    indianBtn.isChecked = false
                }
            }
            englishBtn.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    uzbekBtn.isChecked = false
                    lang = "eng"
                    russianBtn.isChecked = false
                    indianBtn.isChecked = false
                }
            }
            russianBtn.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    lang = "ru"

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
                    lang = "in"
                }
            }

        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}
