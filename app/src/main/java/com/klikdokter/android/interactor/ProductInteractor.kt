package com.klikdokter.android.interactor

import androidx.lifecycle.MutableLiveData
import com.klikdokter.android.api.ProductApi
import com.klikdokter.android.api.RetrofitService
import com.klikdokter.android.model.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductInteractor {

    private var productInteractor: ProductInteractor? = null
    private var api: ProductApi? = null

    fun getInstance(): ProductInteractor? {
        if (productInteractor == null) {
            productInteractor = ProductInteractor()
        }
        return productInteractor
    }

    init {
        api = RetrofitService.createService(ProductApi::class.java)
    }

    fun getProductList(): MutableLiveData<List<Product>> {
        val dataResult = MutableLiveData<List<Product>>()
        api?.getProductList()?.enqueue(object : Callback<List<Product>> {

            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                if (response.isSuccessful) {
                    dataResult.value = response.body()
                }
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                dataResult.value = null
            }
        })
        return dataResult
    }
}