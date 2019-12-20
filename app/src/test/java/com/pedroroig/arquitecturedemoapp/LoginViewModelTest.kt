package com.pedroroig.arquitecturedemoapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.pedroroig.arquitecturedemoapp.features.login.LoginViewModel
import com.pedroroig.arquitecturedemoapp.features.login.LoginViewState
import com.pedroroig.arquitecturedemoapp.router.IRouter
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.mockito.Mockito.*

class LoginViewModelTest {

    // used in order for LiveData to work on the test environment
    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Test
    fun load() {
        val mockRouter = mock(IRouter::class.java)
        val vm = LoginViewModel(mockRouter)
        vm.load()
        assertEquals(
            LoginViewState(null,
                "",
                true,
                true),
            vm.stateLiveData.value)
    }

    @Test
    fun loginUser() {
        val mockRouter = mock(IRouter::class.java)
        val vm = LoginViewModel(mockRouter)
        vm.loginUser()
        verify(mockRouter, times(1)).navigateToUserProfile()
    }
}