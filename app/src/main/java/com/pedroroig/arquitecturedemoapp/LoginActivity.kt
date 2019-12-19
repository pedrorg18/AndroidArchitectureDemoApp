package com.pedroroig.arquitecturedemoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.pedroroig.arquitecturedemoapp.extensions.hide
import com.pedroroig.arquitecturedemoapp.extensions.show
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val viewModel = ViewModelProviders.of(this)[LoginViewModel::class.java]

        viewModel.stateLiveData.observe(this, Observer {
            render(it)
        })

        viewModel.load()

    }

    private fun render(viewState: LoginViewState) {
        with(viewState) {
            if(infoMessage != null) text_message.show()
            else text_message.hide()

            if(loginText != null) edit_text_user.show()
            else edit_text_user.hide()

            if(showPasswordField) edit_text_pass.show()
            else edit_text_pass.hide()
        }
    }
}
