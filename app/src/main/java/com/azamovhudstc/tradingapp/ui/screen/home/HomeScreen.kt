package com.azamovhudstc.tradingapp.ui.screen.home

import android.animation.ObjectAnimator
import android.content.res.Resources
import android.os.Bundle
import android.util.TypedValue
import android.view.animation.LayoutAnimationController
import androidx.annotation.ColorInt
import androidx.core.content.ContextCompat
import androidx.core.math.MathUtils
import androidx.fragment.app.viewModels
import com.azamovhudstc.tradingapp.R
import com.azamovhudstc.tradingapp.base.BaseFragment
import com.azamovhudstc.tradingapp.data.remote.response.Data
import com.azamovhudstc.tradingapp.data.remote.response.stock.DataX
import com.azamovhudstc.tradingapp.databinding.HomeScreenBinding
import com.azamovhudstc.tradingapp.local.LocalHome
import com.azamovhudstc.tradingapp.ui.screen.home.adapter.DiveAdapter
import com.azamovhudstc.tradingapp.ui.screen.home.adapter.MarketAdapter
import com.azamovhudstc.tradingapp.ui.screen.home.adapter.TrendAdapter
import com.azamovhudstc.tradingapp.utils.*
import com.azamovhudstc.tradingapp.viewmodel.impl.HomeScreenViewModelImpl
import com.bumptech.glide.Glide
import com.google.android.material.appbar.AppBarLayout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeScreen : BaseFragment<HomeScreenBinding>(HomeScreenBinding::inflate),
    AppBarLayout.OnOffsetChangedListener {
    private val adapter by lazy { DiveAdapter() }
    private val trendAdapter by lazy { TrendAdapter() }
    private val marketAdapter by lazy { MarketAdapter() }
    private var isCollapsed = false
    private var isCollapsedForAppbar = false
    private val percent = 70
    private var screenWidth = 0f
    private var mMaxScrollSize = 0
    private val model by viewModels<HomeScreenViewModelImpl>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model.getMarketData.observe(this) {
            when (it) {
                is Resource.Error -> {
                    binding.shimmerRecyclerView.hideShimmerAdapter()
                    println("Error")

                    binding.marketRv.show()
                    logError(it.throwable)
                    binding.shimmerRecyclerView.gone()
                }
                Resource.Loading -> {
                    println("Loading")
                    binding.marketRv.gone()
                    binding.shimmerRecyclerView.visible()
                    binding.shimmerRecyclerView.showShimmerAdapter()

                }
                is Resource.Success -> {
                    println("Success")
                    binding.marketRv.show()
                    binding.shimmerRecyclerView.gone()
                    binding.shimmerRecyclerView.hideShimmerAdapter()
                    binding.marketRv.layoutAnimation =
                        LayoutAnimationController(setSlideIn(), 0.25f)
                    binding.marketRv.adapter = marketAdapter
                    marketAdapter.submitList(it.data.data as ArrayList<Data>)
                }
            }
        }
        model.profileLiveData.observe(this) {
            when (it) {
                is Resource.Error -> {
                    toast(it.throwable.message)

                }
                Resource.Loading -> {
                    binding.profilePic.hide()
                    binding.greetingText.hide()
                    binding.nameTxt.hide()
                    binding.greetingTextShimmer.show()
                    binding.nameTxtShimmer.show()
                    binding.fakePicture.show()
                }
                is Resource.Success -> {
                    logMessage(
                        it.data
                            .toString()
                    )
                    binding.nameTxt.show()
                    binding.nameTxt.text = it.data.name
                    binding.greetingText.show()
                    binding.greetingTextShimmer.hide()
                    binding.nameTxtShimmer.hide()
                    binding.fakePicture.hide()
                    binding.profilePic.show()
                    binding.greetingText.text = requireActivity().getString(R.string.hello)
                    Glide.with(requireContext()).load(it.data.profilePic).into(binding.profilePic)

                }
            }
        }
        model.stockLiveData.observe(this) {
            when (it) {
                is Resource.Error -> {
                    binding.shimmerTrendRv.hideShimmerAdapter()

                    binding.textView5.hide()
                    binding.trendRv.show()
                    binding.shimmerTrendRv.hide()
                    snackString(it.throwable.message)

                }
                Resource.Loading -> {
                    binding.trendRv.hide()
                    binding.textView5.hide()
                    binding.shimmerTrendRv.show()
                    binding.shimmerTrendRv.showShimmerAdapter()
                }
                is Resource.Success -> {
                    binding.textView5.show()
                    binding.shimmerTrendRv.hideShimmerAdapter()
                    binding.trendRv.show()
                    binding.shimmerTrendRv.hide()
                    trendAdapter.submitList(it.data.data.data as ArrayList<DataX>)

                }
            }
        }
    }

    override fun onViewCreate() {
        screenWidth = resources.displayMetrics.widthPixels.toFloat()
        binding.apply {
            model.loadMarketData()
            model.getStocks()
            model.loadProfileData()
            binding.partRv.adapter = adapter
            binding.profilePic.slideUp(1200, 0)
            binding.greetingText.slideUp(1200, 0)
            binding.nameTxt.slideUp(1200, 0)
            binding.notificationCard.slideUp(700, 0)
            binding.textView3.slideStart(700, 0)
            binding.cardView.slideStart(700, 0)
            binding.partRv.layoutAnimation = LayoutAnimationController(setSlideIn(), 0.25f)
            binding.trendRv.layoutAnimation = LayoutAnimationController(setSlideIn(), 0.25f)
            adapter.submitList(LocalHome.localDriveItem())
            binding.trendRv.adapter = trendAdapter
            binding.appBarLayout.addOnOffsetChangedListener(this@HomeScreen)

        }
    }

    override fun onOffsetChanged(appBar: AppBarLayout?, i: Int) {
        if (mMaxScrollSize == 0) mMaxScrollSize = appBar!!.totalScrollRange
        val percentage = Math.abs(i) * 100 / mMaxScrollSize
        val cap = MathUtils.clamp((percent - percentage) / percent.toFloat(), 0f, 1f)
        val duration: Long = 900




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
            ObjectAnimator.ofFloat(binding.appBarLayout, "translationX", 0f)
                .setDuration(duration).start()

        }
        if (percentage <= percent && isCollapsed) {
            isCollapsed = false
            requireActivity().window.statusBarColor =
                ContextCompat.getColor(requireActivity(), R.color.status)
            binding.textView3.slideUp(700, 1)
            binding.textView2.slideUp(700, 1)
            binding.profilePic.slideUp(1200, 0)
            binding.greetingText.slideUp(1200, 0)
            binding.nameTxt.slideUp(1200, 0)
            binding.notificationCard.slideUp(700, 0)
            binding.cardView.slideStart(700, 0)
            binding.cardView.slideUp(860, 1)
            binding.partRv.slideUp(920, 1)
            binding.partRv.layoutAnimation = LayoutAnimationController(setSlideIn(), 0.25f)


        }

    }

    override fun onResume() {
        super.onResume()

    }
}