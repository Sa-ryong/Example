package com.saryong.example.presentation.common

import android.annotation.SuppressLint
import android.app.ActivityManager
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.support.v4.content.ContextCompat
import dagger.android.support.DaggerAppCompatActivity
import com.saryong.example.R

@SuppressLint("Registered")
open class BaseActivity : DaggerAppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    initTaskDescription()
  }
  
  protected inline fun <reified VM : ViewModel> viewModelProvider(provider: ViewModelProvider.Factory) =
    ViewModelProviders.of(this, provider).get(VM::class.java)

  private fun initTaskDescription() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      setTaskDescription(ActivityManager.TaskDescription(
        null, null, ContextCompat.getColor(this, R.color.recents_background))
      )
    }
  }
}