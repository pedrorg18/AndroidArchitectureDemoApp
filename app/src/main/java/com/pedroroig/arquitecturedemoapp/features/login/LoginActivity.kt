package com.pedroroig.arquitecturedemoapp.features.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.pedroroig.arquitecturedemoapp.R
import com.pedroroig.arquitecturedemoapp.extensions.hide
import com.pedroroig.arquitecturedemoapp.extensions.show
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val viewModel = LoginViewModel.LoginViewModelFactory(
            this
        ).create(LoginViewModel::class.java)

        viewModel.stateLiveData.observe(this, Observer {
            render(it)
        })

        viewModel.load()

        button_ok.setOnClickListener {
            viewModel.loginUser()
        }

    }

    private fun render(viewState: LoginViewState) {
        with(viewState) {
            if(infoMessage != null) text_message.show()
            else text_message.hide()

            if(loginText != null) edit_text_user.show()
            else edit_text_user.hide()

            if(showPasswordField) edit_text_pass.show()
            else edit_text_pass.hide()

            if(showButton) button_ok.show()
            else button_ok.hide()
        }
    }
}
