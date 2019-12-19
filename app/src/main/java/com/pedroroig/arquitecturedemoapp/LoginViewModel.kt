package com.pedroroig.arquitecturedemoapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    val stateLiveData = MutableLiveData<LoginViewState>()

}