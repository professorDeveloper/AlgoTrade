package com.azamovhudstc.tradingapp.di

import com.azamovhudstc.tradingapp.repository.MarketRepository
import com.azamovhudstc.tradingapp.repository.impl.MarketRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun getMarketRepo(imp: MarketRepositoryImpl): MarketRepository



}