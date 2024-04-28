package com.azamovhudstc.tradingapp.ui.screen.profile.sheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.azamovhudstc.tradingapp.databinding.ChangeLanguageBinding
import com.azamovhudstc.tradingapp.databinding.ChooseLocationBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ChooseLocationDialogSheet : BottomSheetDialogFragment() {
    private var _binding: ChooseLocationBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ChooseLocationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}