package com.example.getting_started

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * ViewModel storing counter state using the LiveData dependency
 */
class MainActivityViewModel: ViewModel() {
    var counter = MutableLiveData<Int>(0);

    val incrementClickHandler = {
        counter.value = counter.value?.plus(1)
        Log.i("MainActivityViewModel", "Counter value is $counter")
    }

    val decrementClickHandler = {
        counter.value = counter.value?.minus(1)
        Log.i("MainActivityViewModel", "Counter value is $counter")
    }
}