package com.pedroroig.arquitecturedemoapp

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pedroroig.arquitecturedemoapp.router.IRouter
import com.pedroroig.arquitecturedemoapp.router.Router

class LoginViewModel(private val router: IRouter) : ViewModel() {

    val stateLiveData = MutableLiveData<LoginViewState>()

    fun load() {
        stateLiveData.value = initialState()
    }

//    fun loginUser() {
//        stateLiveData.value = loginSuccessState()
//    }

    fun loginUser() {
        router.navigateToUserProfile()
    }

//    private fun loginSuccessState() = LoginViewState(
//        "Login successful!",
//        null,
//        false,
//        false
//    )

    private fun initialState() = LoginViewState(
        null,
        "",
        true,
        true
        )

    class LoginViewModelFactory(private val ctx: Context) : ViewModelProvider.NewInstanceFactory() {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>) = LoginViewModel(Router(ctx)) as T
    }

}