package com.azamovhudstc.tradingapp.ui.screen.wallet

import android.animation.ObjectAnimator
import android.content.res.Resources
import android.os.Bundle
import android.util.TypedValue
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LayoutAnimationController
import androidx.annotation.ColorInt
import androidx.core.content.ContextCompat
import androidx.core.math.MathUtils
import com.azamovhudstc.tradingapp.R
import com.azamovhudstc.tradingapp.base.BaseFragment
import com.azamovhudstc.tradingapp.databinding.WalletScreenBinding
import com.azamovhudstc.tradingapp.local.LocalHome
import com.azamovhudstc.tradingapp.ui.screen.home.adapter.TrendAdapter
import com.azamovhudstc.tradingapp.ui.screen.wallet.adapter.DepositeAdapter
import com.azamovhudstc.tradingapp.utils.setSlideIn
import com.azamovhudstc.tradingapp.utils.slideStart
import com.azamovhudstc.tradingapp.utils.slideUp
import com.google.android.material.appbar.AppBarLayout

class WalletScreen : Fragment(R.layout.wallet_screen), AppBarLayout.OnOffsetChangedListener {
    private val depositeAdapter by lazy { DepositeAdapter() }
    private var isCollapsed = false
    private var isCollapsedForAppbar = false
    private val percent = 70
    private var screenWidth = 0f
    private var mMaxScrollSize = 0
    private var _binding: WalletScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = WalletScreenBinding.inflate(
            inflater,
            container,
            false
        )
        screenWidth = resources.displayMetrics.widthPixels.toFloat()

        return _binding?.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        depositeAdapter.submitList(LocalHome.loadDeposite())
        binding.recycleview.layoutAnimation = LayoutAnimationController(setSlideIn(), 0.25f)
        binding.walletappbar.addOnOffsetChangedListener(this@WalletScreen)
        binding.textView3.slideUp(700, 1)
        binding.textView2.slideUp(700, 1)
        binding.sendlayout.slideUp(800, 1)
        binding.buylayout.slideUp(860, 1)
        binding.recievelayout.slideUp(920, 1)

        binding.swaplayout.slideUp(980, 1)
        binding.cardBalance.slideUp(750,1)
        binding.recycleview.adapter=depositeAdapter

    }
    override fun onOffsetChanged(appBar: AppBarLayout?, i: Int) {
        if (mMaxScrollSize == 0) mMaxScrollSize = appBar!!.totalScrollRange
        val percentage = Math.abs(i) * 100 / mMaxScrollSize
        val cap = MathUtils.clamp((percent - percentage) / percent.toFloat(), 0f, 1f)
        val duration:Long =900




        if (percentage >= percent && !isCollapsed) {
            isCollapsed = true
            val typedValue = TypedValue()
            val theme: Resources.Theme = requireContext().theme
            theme.resolveAttribute(
                com.google.android.material.R.attr.colorOnBackground,
                typedValue,
                true
            )
            @ColorInt val selectedcolor: Int = typedValue.data
            requireActivity().window.statusBarColor = selectedcolor
            ObjectAnimator.ofFloat(binding.walletappbar, "translationX", 0f)
                .setDuration(duration).start()

        }
        if (percentage <= percent && isCollapsed) {
            isCollapsed = false
            requireActivity().window.statusBarColor =
                ContextCompat.getColor(requireActivity(), R.color.status)
            binding.textView3.slideUp(700, 1)
            binding.textView2.slideUp(700, 1)
            binding.sendlayout.slideUp(800, 1)
            binding.buylayout.slideUp(860, 1)
            binding.recievelayout.slideUp(920, 1)

            binding.swaplayout.slideUp(980, 1)

        }

    }

}