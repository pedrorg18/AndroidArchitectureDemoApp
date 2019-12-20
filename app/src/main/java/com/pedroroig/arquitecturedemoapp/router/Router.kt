package com.pedroroig.arquitecturedemoapp.router

import android.content.Context
import android.content.Intent
import com.pedroroig.arquitecturedemoapp.UserProfileActivity

class Router(private val ctx: Context) : IRouter {

    override fun navigateToUserProfile() {
        ctx.startActivity(Intent(ctx, UserProfileActivity::class.java))
    }

}