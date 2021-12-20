package com.klikdokter.android.interactor

import androidx.lifecycle.MutableLiveData
import com.klikdokter.android.api.AuthApi
import com.klikdokter.android.api.RetrofitService
import com.klikdokter.android.model.Token
import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthInteractor {

    private var authInteractor: AuthInteractor? = null
    private var api: AuthApi? = null

    fun getInstance(): AuthInteractor? {
        if (authInteractor == null) {
            authInteractor = AuthInteractor()
        }
        return authInteractor
    }

    init {
        api = RetrofitService.createService(AuthApi::class.java)
    }

    fun actionLogin(email: String, password: String): MutableLiveData<Pair<Boolean, String>> {
        val result = MutableLiveData<Pair<Boolean, String>>()
        val requestBody = MultipartBody.Builder().setType(MultipartBody.FORM)
            .addFormDataPart("email", email)
            .addFormDataPart("password", password)
            .build()
        api?.actionLogin(requestBody)?.enqueue(object : Callback<Token> {

            override fun onResponse(call: Call<Token>, response: Response<Token>) {
                if (response.isSuccessful) {
                    result.value = Pair(true, response.body().toString())
                } else {
                    result.value = Pair(false, response.errorBody().toString())
                }
            }


            override fun onFailure(call: Call<Token>, t: Throwable) {
                result.value = Pair(false, t.message.toString())
            }
        })
        return result
    }

    fun actionRegister(email: String, password: String): MutableLiveData<Pair<Boolean, String>> {
        val result = MutableLiveData<Pair<Boolean, String>>()
        val requestBody = MultipartBody.Builder().setType(MultipartBody.FORM)
            .addFormDataPart("email", email)
            .addFormDataPart("password", password)
            .build()
        api?.actionRegister(requestBody)?.enqueue(object : Callback<Token> {

            override fun onResponse(call: Call<Token>, response: Response<Token>) {
                if (response.isSuccessful) {
                    result.value = Pair(true, response.body().toString())
                } else {
                    result.value = Pair(false, response.errorBody().toString())
                }
            }


            override fun onFailure(call: Call<Token>, t: Throwable) {
                result.value = Pair(false, t.message.toString())
            }
        })
        return result
    }
}