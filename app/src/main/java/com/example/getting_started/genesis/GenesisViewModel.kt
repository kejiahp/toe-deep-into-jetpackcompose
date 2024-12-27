package com.example.getting_started.genesis

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * ViewModel storing counter state using the LiveData dependency
 */
class GenesisViewModel : ViewModel() {
    var counter = MutableLiveData<Int>(0);
    val error: MutableLiveData<String?> = MutableLiveData<String?>();

    val incrementClickHandler = {
        counter.value = counter.value?.plus(1)
        if (error.value != null) {
            error.value = null;
        }
        Log.i("GenesisViewModel", "Counter value is ${counter.value}")
    }

    val decrementClickHandler = {
//        counter.value = counter.value?.let { if (it > 0) counter.value?.minus(1) else  0 }
        counter.value = counter.value?.let {
            if (it > 0) {
                counter.value?.minus(1)
            } else {
                if (error.value == null) {
                    error.value = "Counter can not be less than 0"
                }
                0
            }
        }
        Log.i("GenesisViewModel", "Counter value is ${counter.value}")
    }
}