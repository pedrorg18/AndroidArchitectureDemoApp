package com.pedroroig.arquitecturedemoapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    val stateLiveData = MutableLiveData<LoginViewState>()

    fun load() {
        stateLiveData.value = initialState()
    }

    private fun initialState() = LoginViewState(
        null,
        "",
        true,
        true
        )

}