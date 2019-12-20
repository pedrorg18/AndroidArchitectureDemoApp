package com.pedroroig.arquitecturedemoapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    val stateLiveData = MutableLiveData<LoginViewState>()

    fun load() {
        stateLiveData.value = initialState()
    }

    fun loginUser() {
        stateLiveData.value = loginSuccessState()
    }

    private fun loginSuccessState() = LoginViewState(
        "Login successful!",
        null,
        false,
        false
    )

    private fun initialState() = LoginViewState(
        null,
        "",
        true,
        true
        )

}