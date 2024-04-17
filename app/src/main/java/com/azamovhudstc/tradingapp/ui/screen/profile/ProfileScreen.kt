package com.azamovhudstc.tradingapp.ui.screen.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.azamovhudstc.soplay.utils.Color
import com.azamovhudstc.tradingapp.R
import com.azamovhudstc.tradingapp.base.BaseFragment
import com.azamovhudstc.tradingapp.databinding.ProfileScreenBinding
import com.tradingview.lightweightcharts.api.chart.models.color.toIntColor
import com.tradingview.lightweightcharts.api.interfaces.SeriesApi
import com.tradingview.lightweightcharts.api.options.models.layoutOptions
import com.tradingview.lightweightcharts.api.options.models.localizationOptions
import com.tradingview.lightweightcharts.api.series.models.HistogramData
import com.tradingview.lightweightcharts.api.series.models.Time
import com.tradingview.lightweightcharts.runtime.plugins.DateTimeFormat
import com.tradingview.lightweightcharts.runtime.plugins.PriceFormatter
import com.tradingview.lightweightcharts.runtime.plugins.TimeFormatter

class ProfileScreen : BaseFragment<ProfileScreenBinding>(ProfileScreenBinding::inflate) {
    lateinit var histogramSeries: SeriesApi

    override fun onViewCreate() {
        binding.chartsView.api.addHistogramSeries(
            onSeriesCreated = { series ->
                histogramSeries = series
            }
        )
        binding.chartsView.api.applyOptions {

            localization = localizationOptions {
                locale = "ru-RU"
                priceFormatter = PriceFormatter(template = "{price:#2:#3}$")
                timeFormatter = TimeFormatter(
                    locale = "ru-RU",
                    dateTimeFormat = DateTimeFormat.DATE_TIME
                )
            }

        }
        val data = listOf(
            HistogramData(Time.BusinessDay(2019, 6, 11), 40.01f),
            HistogramData(Time.BusinessDay(2019, 6, 12), 52.38f),
            HistogramData(Time.BusinessDay(2019, 6, 13), 36.30f),
            HistogramData(Time.BusinessDay(2019, 6, 14), 34.48f),
            HistogramData(Time.BusinessDay(2019, 6, 17), 41.50f),
            HistogramData(Time.BusinessDay(2019, 6, 18), 34.82f)
        )
        histogramSeries.setData(data)

    }

}