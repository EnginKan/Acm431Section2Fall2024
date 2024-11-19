package com.yeditepe.acm431section2.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.yeditepe.acm431section2.R
import com.yeditepe.acm431section2.ui.screens.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

val data = mutableListOf<Product>()
class ProductViewModel : ViewModel(){
   private val _allProduct = MutableStateFlow(data)
    val allProduct = _allProduct.asStateFlow()
    init{
        populate()
    }
    private fun  populate():Unit{
        for(i in 1..100){

            data.add(Product(i, R.drawable.yeditepe,"Product 1","33.5"))
        }
    }

    fun getProductById(id:Int):Product?{
        return allProduct.value.filter { it.id==id }?.get(0)
    }
}
