package com.azamovhudstc.tradingapp.di

import android.content.Context
import com.azamovhudstc.tradingapp.data.remote.api.MarketApi
import com.azamovhudstc.tradingapp.data.remote.api.StockApi
import com.chuckerteam.chucker.api.ChuckerInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @[Provides Singleton]
    fun getOkHTTPClient(@ApplicationContext context: Context): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(ChuckerInterceptor(context))
        .readTimeout(60, TimeUnit.SECONDS)
        .connectTimeout(60, TimeUnit.SECONDS)
        .build()


    @[Provides Singleton Named("stock")]
    fun getMakeTradingViewRetrofit2(client: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl("https://stockanalysis.com/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @[Provides Singleton Named("coinMarket")]
    fun getMarketRetrofit2(client: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl("https://pro-api.coinmarketcap.com/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    fun getMarketApi(@Named("coinMarket") retrofit: Retrofit): MarketApi =
        retrofit.create(MarketApi::class.java)

    @Provides
    fun getTradingViewApi(@Named("stock") retrofit: Retrofit): StockApi =
        retrofit.create(StockApi::class.java)


}