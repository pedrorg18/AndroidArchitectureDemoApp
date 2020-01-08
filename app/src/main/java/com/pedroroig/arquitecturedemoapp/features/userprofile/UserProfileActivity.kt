package com.pedroroig.arquitecturedemoapp.features.userprofile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.pedroroig.arquitecturedemoapp.R
import com.pedroroig.arquitecturedemoapp.extensions.hide
import com.pedroroig.arquitecturedemoapp.extensions.setTextHideIfNull
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
        progressBar.show()
    }

    private fun render(viewState: UserProfileViewState) {
        progressBar.hide()
        with(viewState) {
            text_userprofile_name.setTextHideIfNull(title)
            // image_userprofile set imageUrl with Glide
            imageUrl?.let { image_userprofile.show() } ?: image_userprofile.hide()
            text_userprofile_role.setTextHideIfNull(role)
            text_error.setTextHideIfNull(error)
        }
    }

}
