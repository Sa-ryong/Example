package com.saryong.example.presentation.addcurrency

import android.arch.lifecycle.LiveData
import android.databinding.BindingAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import com.saryong.example.data.local.CurrencySetting
import timber.log.Timber

@BindingAdapter("bind:currencySettingList")
fun setCurrencyList(recyclerView: RecyclerView, itemList: LiveData<List<CurrencySetting>>) {
  itemList.value?.let { newItemList ->
    Timber.d(newItemList.toString())
  
    val adapter = recyclerView.adapter as SimpleCurrencyListAdapter
    val diff = DiffUtil.calculateDiff(
      CurrencySettingDiffCallback(adapter.itemList, newItemList), true
    )
  
    adapter.itemList = newItemList.toList()
  
    diff.dispatchUpdatesTo(adapter)
  }
}