package com.pedroroig.arquitecturedemoapp.features.userprofile

import com.pedroroig.arquitecturedemoapp.domain.model.UserProfile

class UserProfileDomainToViewStateMapper {


    fun map(domainUserProfile: UserProfile) =
        UserProfileViewState(
            title(domainUserProfile),
            generateImageUrl(domainUserProfile),
            role(domainUserProfile)


        )

    fun title(domainUserProfile: UserProfile) =
        with(domainUserProfile) {
            "$firstName $surName${secondSurName?.let { " $it" } ?: ""}"
        }

    fun generateImageUrl(domainUserProfile: UserProfile) =
        with(domainUserProfile) {
            "https:/coolimages/$surName-$firstName"
        }

    fun role(domainUserProfile: UserProfile) =
        domainUserProfile.roleList.joinToString(separator = " ") { it.name }

}
