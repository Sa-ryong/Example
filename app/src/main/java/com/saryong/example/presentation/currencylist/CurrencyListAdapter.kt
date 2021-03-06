package com.saryong.example.presentation.currencylist

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.saryong.example.presentation.currencylist.CurrencyListAdapter.ViewHolder
import com.saryong.example.databinding.ItemCurrencyBinding
import com.saryong.example.presentation.currencylist.item.CurrencyItem

class CurrencyListAdapter(private val eventListener: CurrencyListEventListener) : RecyclerView.Adapter<ViewHolder>() {
  var itemList = listOf<CurrencyItem>()

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val binding = ItemCurrencyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return ViewHolder(binding)
  }

  override fun getItemCount(): Int = itemList.size

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.binding.currency = itemList[position]
    holder.binding.eventListener = eventListener
  }

  class ViewHolder(val binding: ItemCurrencyBinding) : RecyclerView.ViewHolder(binding.root)

}
