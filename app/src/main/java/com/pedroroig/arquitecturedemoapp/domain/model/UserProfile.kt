package com.pedroroig.arquitecturedemoapp.domain.model

data class UserProfile(val firstName: String,
                       val surName: String,
                       val secondSurName: String?,
                       val roleList: List<Role>)


data class Role(val code: String,
                val name: String)