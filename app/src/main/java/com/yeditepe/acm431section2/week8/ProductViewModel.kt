package com.yeditepe.acm431section2.week8

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

enum class UiState{
    START,
    READY,
    ERROR
}

class ProductViewModel : ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.START)
    private val _allProduct = MutableStateFlow(listOf<Product>())
    val uiState= _uiState.asStateFlow()



    init{
        viewModelScope.launch {
            _allProduct.value = HtttpClient.myService.getAllProducts()
            _uiState.value = UiState.READY

        }
    }



}