package com.yeditepe.acm431section2.week8

import retrofit2.Retrofit

import retrofit2.converter.gson.GsonConverterFactory;

val BASE_URL="https://fakestoreapi.com"
val instance = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

object HtttpClient{
    val myService : FakeAPI by lazy {
        instance.create(FakeAPI::class.java)
    }
}


