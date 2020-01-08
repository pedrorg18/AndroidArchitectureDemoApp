package com.pedroroig.arquitecturedemoapp.domain.repository

import com.pedroroig.arquitecturedemoapp.domain.model.Role
import com.pedroroig.arquitecturedemoapp.domain.model.UserProfile
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class UserProfileRepository {

    fun getUserProfile(subscriber: SingleObserver<UserProfile>) =
        Single.just(
            UserProfile(
                "Robert",
                "Patrick",
                null,
                listOf(
                    Role("MTL", "Metalic"),
                    Role("LQD", "Liquid"),
                    Role("XTM", "Exterminator")
                )
            )
        )
            .delay(5, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(subscriber)
}