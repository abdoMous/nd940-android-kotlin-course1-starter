package com.udacity.shoestore.viewmodules

import android.app.Application
import androidx.lifecycle.*
import com.udacity.shoestore.formatShoe
import com.udacity.shoestore.models.Shoe

class MainViewModel(
        application: Application
) : AndroidViewModel(application) {

    val editedShoe = MutableLiveData<Shoe?>()

    private val _list = MutableLiveData<MutableList<Shoe?>>()
    val list : LiveData<MutableList<Shoe?>>
        get() = _list

    val listFormatted = Transformations.map(_list) { l ->
        l.map { formatShoe(it , application.resources) }
    }

    private val _navigateToShoeDetailScreen = MutableLiveData<Boolean>()
    val navigateToShoeDetailScreen : LiveData<Boolean>
        get() = _navigateToShoeDetailScreen

    private val _eventCancel = MutableLiveData<Boolean>()

    val eventCancel : LiveData<Boolean>
        get() = _eventCancel

    init {
        _list.value = mutableListOf(
                Shoe("Air Jordan",7.5,"Nike","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ac tortor vitae purus faucibus ornare suspendisse sed."),
                Shoe("Samba",7.0,"Adidas","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ac tortor vitae purus faucibus ornare suspendisse sed."),
                Shoe("Fetto",8.5,"Jimmy Choo","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ac tortor vitae purus faucibus ornare suspendisse sed.")
        )
        editedShoe.value = Shoe()
    }

    fun cancel(){
        _eventCancel.value = true
    }

    fun doneCanceling(){
        _eventCancel.value = false
    }

    fun save(){
        val l2 = _list.value
        l2?.add(editedShoe.value)

        editedShoe.value = Shoe()

        _list.value = l2
        _eventSaveShoe.value = true
    }

    private val _eventSaveShoe = MutableLiveData<Boolean?>()
    val eventSaveShoe: LiveData<Boolean?>
        get() = _eventSaveShoe

    fun doneSaving(){
        _eventSaveShoe.value = false
    }

    fun doneNavigateToShoeDetailScreen(){
        _navigateToShoeDetailScreen.value = false
    }

    fun showShoeDetailScreen(){
        _navigateToShoeDetailScreen.value = true
    }
}