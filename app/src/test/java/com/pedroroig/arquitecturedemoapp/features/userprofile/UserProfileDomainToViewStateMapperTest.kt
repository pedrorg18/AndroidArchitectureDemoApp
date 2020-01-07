package com.pedroroig.arquitecturedemoapp.features.userprofile

import com.pedroroig.arquitecturedemoapp.domain.model.Role
import com.pedroroig.arquitecturedemoapp.domain.model.UserProfile
import org.junit.Test

import org.junit.Assert.*

class UserProfileDomainToViewStateMapperTest {

    private val mapper = UserProfileDomainToViewStateMapper()


    @Test
    fun title() {
        val domainNoSecSurname = generateUserProfileNoSecondSurname()
        val titleNoSecSurname  = mapper.title(domainNoSecSurname)
        assertEquals("Robert Patrick", titleNoSecSurname)

        val domainWithSecSurname = generateUserProfileWithSecondSurname()
        val titleWithSecSurname  = mapper.title(domainWithSecSurname)
        assertEquals("Robert Patrick López", titleWithSecSurname)
    }

    @Test
    fun generateImageUrl() {
        val domainNoSecSurname = generateUserProfileNoSecondSurname()
        val urlNoSecSurname  = mapper.generateImageUrl(domainNoSecSurname)
        assertEquals("https:/coolimages/Patrick-Robert", urlNoSecSurname)
    }

    @Test
    fun role() {
        val domainNoSecSurname = generateUserProfileNoSecondSurname()
        val roleNoSecSurname  = mapper.role(domainNoSecSurname)

        assertEquals("Metalic Liquid Exterminator", roleNoSecSurname)
    }

    private fun generateUserProfileNoSecondSurname() =
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

    private fun generateUserProfileWithSecondSurname() =
        generateUserProfileNoSecondSurname().copy(secondSurName = "López")
}