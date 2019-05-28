package com.prof18.basetest.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel: ViewModel() {

    protected val mutableLiveMessage = MutableLiveData<String>()
    val liveMessage: LiveData<String>
        get() = mutableLiveMessage
}