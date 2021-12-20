package com.klikdokter.android.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.klikdokter.android.interactor.ProductInteractor
import com.klikdokter.android.model.Product

class ProductViewModel : ViewModel() {
    private lateinit var liveData: MutableLiveData<List<Product>>
    private var interactor: ProductInteractor? = null

    fun init() {
        interactor = ProductInteractor().getInstance()
        interactor?.let {
            liveData = it.getProductList()
        }
    }

    fun getProductList(): LiveData<List<Product>> {
        return liveData
    }
}