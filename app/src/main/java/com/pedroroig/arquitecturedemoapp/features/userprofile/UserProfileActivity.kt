package com.pedroroig.arquitecturedemoapp.features.userprofile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.pedroroig.arquitecturedemoapp.R
import com.pedroroig.arquitecturedemoapp.extensions.hide
import com.pedroroig.arquitecturedemoapp.extensions.show
import kotlinx.android.synthetic.main.activity_user_profile.*

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
        when(viewState) {
            is UserProfileViewState.LoadingState -> renderLoading()
            is UserProfileViewState.ContentState -> renderContent(viewState.content)
            is UserProfileViewState.ErrorState -> renderError(viewState.message)
        }
    }

    private fun renderLoading() {
        progressBar.show()
    }

    private fun renderContent(contentState: UserProfileContentState) {
        progressBar.hide()
        text_error.hide()

        with(contentState) {
            text_userprofile_name.text = title
            // image_userprofile set imageUrl with Glide
            image_userprofile.show()
            text_userprofile_role.text = role
        }
    }

    private fun renderError(message: String) {
        progressBar.hide()
        text_userprofile_name.hide()
        image_userprofile.hide()
        text_userprofile_role.hide()

        text_error.show()
        text_error.text = message
    }

}
