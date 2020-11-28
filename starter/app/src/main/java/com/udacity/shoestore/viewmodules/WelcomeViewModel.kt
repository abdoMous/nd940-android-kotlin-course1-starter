package com.udacity.shoestore.viewmodules

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WelcomeViewModel : ViewModel() {

    private val _navigateToInstructionScreen = MutableLiveData<Boolean>()
    val navigateToInstructionScreen: LiveData<Boolean>
        get() = _navigateToInstructionScreen

    fun doneNavigationToInstructionScreen(){
        _navigateToInstructionScreen.value = false
    }

    fun showInstruction(){
        _navigateToInstructionScreen.value = true
    }
}