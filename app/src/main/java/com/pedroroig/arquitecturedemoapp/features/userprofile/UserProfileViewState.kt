package com.pedroroig.arquitecturedemoapp.features.userprofile

data class UserProfileViewState (
    val title: String?,
    val imageUrl: String?,
    val role: String?,
    val error: String? = null
)