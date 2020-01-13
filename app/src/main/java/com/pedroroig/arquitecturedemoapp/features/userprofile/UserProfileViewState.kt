package com.pedroroig.arquitecturedemoapp.features.userprofile

sealed class UserProfileViewState {
    object LoadingState : UserProfileViewState()
    class ContentState(val content: UserProfileContentState) : UserProfileViewState()
    class ErrorState(val message: String) : UserProfileViewState()
}


data class UserProfileContentState (
    val title: String,
    val imageUrl: String,
    val role: String)