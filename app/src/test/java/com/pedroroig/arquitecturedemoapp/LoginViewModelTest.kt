package com.pedroroig.arquitecturedemoapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule

class LoginViewModelTest {

    // used in order for LiveData to work on the test environment
    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Test
    fun load() {
        val vm = LoginViewModel()
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
        val vm = LoginViewModel()
        vm.loginUser()
        assertEquals(
            LoginViewState("Login successful!",
                null,
                false,
                false),
            vm.stateLiveData.value)
    }
}