package com.azamovhudstc.tradingapp.ui.screen.profile

import com.azamovhudstc.tradingapp.R
import com.azamovhudstc.tradingapp.base.BaseFragment
import com.azamovhudstc.tradingapp.databinding.ProfileScreenBinding
import com.azamovhudstc.tradingapp.local.LocalHome
import com.azamovhudstc.tradingapp.ui.screen.profile.adapter.ProfileAdapter
import com.azamovhudstc.tradingapp.ui.screen.profile.sheet.LanguageDialogSheet


class ProfileScreen : BaseFragment<ProfileScreenBinding>(ProfileScreenBinding::inflate) {
    private val profileAdapter by lazy { ProfileAdapter() }
    override fun onViewCreate() {

        binding.apply {
            profileRv.adapter = profileAdapter
            profileAdapter.submitList(LocalHome.loadProfileList())
            profileAdapter.setItemClickListener {
                when (it.itemTitle) {
                    "Pul o’tkazish manzili" -> {

                    }

                    "Tilni tanlash" -> {
                        LanguageDialogSheet().show(parentFragmentManager, "dialog")

                        }
                    }
                }
            }
            binding.cardView2.setOnClickListener {
                binding.helpCard.setCardBackgroundColor(requireActivity().getColor(R.color.basic_color_400))
                binding.cardView3.setCardBackgroundColor(requireActivity().getColor(R.color.basic_color_400))
                binding.cardView2.setCardBackgroundColor(requireActivity().getColor(R.color.color_white))
            }
            binding.helpCard.setOnClickListener {
                binding.helpCard.setCardBackgroundColor(requireActivity().getColor(R.color.color_white))
                binding.cardView2.setCardBackgroundColor(requireActivity().getColor(R.color.basic_color_400))
                binding.cardView3.setCardBackgroundColor(requireActivity().getColor(R.color.basic_color_400))
            }
            binding.cardView3.setOnClickListener {
                binding.helpCard.setCardBackgroundColor(requireActivity().getColor(R.color.basic_color_400))
                binding.cardView2.setCardBackgroundColor(requireActivity().getColor(R.color.basic_color_400))
                binding.cardView3.setCardBackgroundColor(requireActivity().getColor(R.color.color_white))
            }
        }
    }

