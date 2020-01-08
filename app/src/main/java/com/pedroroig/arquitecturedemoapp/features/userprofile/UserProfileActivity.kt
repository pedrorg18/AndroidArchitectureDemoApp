package com.pedroroig.arquitecturedemoapp.features.userprofile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.pedroroig.arquitecturedemoapp.R

class UserProfileActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProviders.of(this)[UserProfileViewModel::class.java] }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        viewModel.viewStateLiveData.observe(this, Observer {
            render(it)
        })
        viewModel.load()
    }

    private fun render(viewState: UserProfileViewState) {

    }

}
