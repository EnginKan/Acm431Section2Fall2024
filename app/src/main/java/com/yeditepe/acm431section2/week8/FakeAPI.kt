package com.yeditepe.acm431section2.week8

import retrofit2.http.GET
import retrofit2.http.POST

interface FakeAPI {

    @GET("products")
    suspend fun getAllProducts(): List<Product>

    @POST("products")
    suspend fun insertProduct(product: Product): Unit
}