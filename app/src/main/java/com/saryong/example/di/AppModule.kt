package com.saryong.example.di

import android.content.Context
import com.saryong.example.App
import com.saryong.example.data.api.CurrencyLayerApi
import com.saryong.example.data.local.PredefinedConstantDataStorage
import com.saryong.example.data.local.PredefinedConstantStorage
import com.saryong.example.data.repository.*
import com.saryong.example.util.rx.AppSchedulerProvider
import com.saryong.example.util.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal object AppModule {
  @Singleton @Provides @JvmStatic
  fun provideContext(application: App): Context = application

  @Singleton @Provides @JvmStatic
  fun provideSchedulerProvider(): SchedulerProvider = AppSchedulerProvider()

  @Singleton @Provides @JvmStatic
  fun providePredefinedConstantStorage(context: Context): PredefinedConstantStorage =
    PredefinedConstantDataStorage(context)
  
  @Singleton @Provides @JvmStatic
  fun provideCurrencyInfoRepository(
    schedulerProvider: SchedulerProvider
  ) : CurrencyInfoRepository =
    CurrencyInfoDataRepository(schedulerProvider)
  
  @Singleton @Provides @JvmStatic
  fun provideExchangeRateRepository(
    exchangeApi: CurrencyLayerApi,
    schedulerProvider: SchedulerProvider
  ) : ExchangeRateRepository =
    ExchangeRateDataRepository(exchangeApi, schedulerProvider)
}