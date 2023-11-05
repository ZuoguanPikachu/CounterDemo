package com.zuoguan.counterdemo.pages.main

import androidx.lifecycle.ViewModel
import com.zuoguan.counterdemo.di.CountRecorderService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class PageBViewModel @Inject constructor(
    countRecorderService: CountRecorderService
) : ViewModel(){
    val previousCount = countRecorderService.getCount()
}