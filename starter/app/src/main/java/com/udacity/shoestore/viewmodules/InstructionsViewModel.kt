package com.udacity.shoestore.viewmodules

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InstructionsViewModel: ViewModel() {

    private val _navigateToShoeListing = MutableLiveData<Boolean>()
    val navigateToShoeListing: LiveData<Boolean>
        get() = _navigateToShoeListing

    fun doneNavigatingToShoeListing() {
        _navigateToShoeListing.value = false
    }

    fun showListOfShoes(){
        _navigateToShoeListing.value = true
    }
}