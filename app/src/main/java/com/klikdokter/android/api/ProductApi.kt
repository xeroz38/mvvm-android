package com.klikdokter.android.api

import com.klikdokter.android.model.Product
import retrofit2.Call
import retrofit2.http.GET

interface ProductApi {
    @GET("items")
    fun getProductList(): Call<List<Product>>
}