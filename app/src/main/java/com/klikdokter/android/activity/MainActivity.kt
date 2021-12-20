package com.klikdokter.android.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.klikdokter.android.adapter.ProductAdapter
import com.klikdokter.android.databinding.ActivityMainBinding
import com.klikdokter.android.model.Product
import com.klikdokter.android.viewmodel.ProductViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val resultList = mutableListOf<Product>()
    private var productViewModel: ProductViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        productViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)
        productViewModel?.init()

        getProductList()
    }

    private fun getProductList() {
        productViewModel?.getProductList()?.observe(this, {
            if (it != null) {
                resultList.addAll(it)
                binding.rvProduct.adapter = ProductAdapter(this, resultList)
            }
        })
    }
}