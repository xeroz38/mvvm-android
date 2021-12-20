package com.klikdokter.android.api

import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("register")
    fun actionRegister(@Body body: RequestBody): Call<ResponseBody>

    @POST("auth/login")
    fun actionLogin(@Body body: RequestBody): Call<ResponseBody>
}