package com.saryong.example.di.activitymodule

import com.saryong.example.presentation.splash.not.used.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface SplashActivityBuilder {
  @ContributesAndroidInjector(modules = [SplashActivityModule::class])
  fun contributeSplashActivity(): SplashActivity
}