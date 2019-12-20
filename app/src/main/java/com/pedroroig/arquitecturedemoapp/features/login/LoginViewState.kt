package com.pedroroig.arquitecturedemoapp.features.login

data class LoginViewState (
    val infoMessage: String?,
    val loginText: String?,
    val showPasswordField: Boolean,
    val showButton: Boolean
)