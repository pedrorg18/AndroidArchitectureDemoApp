package com.pedroroig.arquitecturedemoapp.features.userprofile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pedroroig.arquitecturedemoapp.domain.model.UserProfile
import com.pedroroig.arquitecturedemoapp.domain.repository.UserProfileRepository
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable

class UserProfileViewModel : ViewModel() {

    private val repo = UserProfileRepository()

    val viewStateLiveData = MutableLiveData<UserProfileViewState>()

    fun load() {
        repo.getUserProfile(object : SingleObserver<UserProfile> {
            override fun onSuccess(t: UserProfile) {
                viewStateLiveData.value = UserProfileDomainToViewStateMapper().map(t)
            }

            override fun onError(e: Throwable) {
                viewStateLiveData.value = errorViewState("There was an error retrieving user data")
            }

            override fun onSubscribe(d: Disposable) {}

        })

    }

    private fun errorViewState(errorMessage: String) =
        UserProfileViewState (null, null, null, errorMessage)

}