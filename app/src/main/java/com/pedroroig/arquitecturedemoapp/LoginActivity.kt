package com.pedroroig.arquitecturedemoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val viewModel = ViewModelProviders.of(this)[LoginViewModel::class.java]

        viewModel.stateLiveData.observe(this, Observer {
            render(it)
        })

    }

    private fun render(viewState: LoginViewState) {

    }
}
