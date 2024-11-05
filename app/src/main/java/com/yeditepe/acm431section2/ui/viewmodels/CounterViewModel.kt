package com.yeditepe.acm431section2.ui.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CounterViewModel: ViewModel() {

    private var _counter = MutableStateFlow(0)

    val counter = _counter.asStateFlow()

    fun increment(){
        _counter.value+= 1
    }
}