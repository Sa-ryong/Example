package com.saryong.example.presentation.currencydetail

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.saryong.example.R

/**
 * A placeholder fragment containing a simple view.
 */
class CurrencyDetailFragment : Fragment() {
  
  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_currency_detail, container, false)
  }
}
