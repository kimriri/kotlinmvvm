package com.programmers.myapplication

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


enum class ActionType {
    PULS,
    MINUS
}

class MyNumberViewModel() : ViewModel() {

    companion object {
        const val TAG: String = "LOG"
    }

    private val _currenValue = MutableLiveData<Int>()

    val currenValue: LiveData<Int>
        get() = _currenValue


    init {
        Log.d(TAG, "MyNumberViewModel")
        _currenValue.value = 0
    }

    fun updateValue(actionType: ActionType, input: Int) {
        when (actionType) {
            ActionType.PULS ->
                _currenValue.value = _currenValue.value?.plus(input)
            ActionType.MINUS ->
                _currenValue.value = _currenValue.value?.minus(input)
        }
    }
}
