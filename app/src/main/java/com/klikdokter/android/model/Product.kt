package com.klikdokter.android.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Product {

    @SerializedName("sku")
    @Expose
    val sku: String? = null

    @SerializedName("product_name")
    @Expose
    val name: String? = null

    @SerializedName("id")
    @Expose
    val id: Int? = null
}