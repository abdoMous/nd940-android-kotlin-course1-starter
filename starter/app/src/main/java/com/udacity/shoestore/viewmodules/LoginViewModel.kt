package com.udacity.shoestore.viewmodules

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val _navigateToWelcome = MutableLiveData<Boolean>()
    val navigateToWelcome: LiveData<Boolean>
        get() = _navigateToWelcome

    fun doneNavigatingToWelcome(){
        _navigateToWelcome.value = false
    }

    fun login(){
        _navigateToWelcome.value = true
    }

    fun createNewAccount(){
        _navigateToWelcome.value = true
    }
}