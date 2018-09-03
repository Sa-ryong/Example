package com.saryong.example.presentation.addcurrency

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.saryong.example.R
import com.saryong.example.databinding.ActivityAddCurrencyBinding
import com.saryong.example.presentation.NavigationController
import com.saryong.example.presentation.currencylist.MainViewModel
import com.saryong.example.util.fastLazy
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class AddCurrencyActivity : DaggerAppCompatActivity() {
  @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
  @Inject lateinit var navigationController: NavigationController

  private val binding: ActivityAddCurrencyBinding by fastLazy {
    DataBindingUtil.setContentView<ActivityAddCurrencyBinding>(this, R.layout.activity_add_currency)
  }

  private val viewModel by fastLazy {
    ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
  }


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    supportActionBar?.title = "Select Currency"

    binding.setLifecycleOwner(this)
    binding.viewModel = viewModel
    binding.newCurrenciesRecyclerView.adapter
  }
}