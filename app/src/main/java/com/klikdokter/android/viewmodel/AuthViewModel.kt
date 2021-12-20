package com.klikdokter.android.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.klikdokter.android.interactor.AuthInteractor

class AuthViewModel : ViewModel() {
    private lateinit var liveData: MutableLiveData<Pair<Boolean, String>>
    private var interactor: AuthInteractor? = null

    fun init() {
        interactor = AuthInteractor().getInstance()
    }

    fun actionLogin(email: String, password: String): LiveData<Pair<Boolean, String>> {
        interactor?.let {
            liveData = it.actionLogin(email, password)
        }
        return liveData
    }

    fun actionRegister(email: String, password: String): LiveData<Pair<Boolean, String>> {
        interactor?.let {
            liveData = it.actionRegister(email, password)
        }
        return liveData
    }
}