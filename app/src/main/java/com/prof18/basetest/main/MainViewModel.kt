package com.prof18.basetest.main

import com.prof18.basetest.base.BaseViewModel

class MainViewModel: BaseViewModel() {

    fun generateMessage() {
        mutableLiveMessage.value = "Main Activity from ViewModel"
    }

}