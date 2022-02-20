package com.example.counter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel: ViewModel() {

    val counter: MutableLiveData<Int> = MutableLiveData(0)

    fun add(){
        if (counter.value == 9) {
            counter.postValue(0)
        } else {
            counter.postValue(counter.value?.plus(1))
        }
    }
}