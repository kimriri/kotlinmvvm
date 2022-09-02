package com.programmers.myapplication

import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel



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

    fun updateValue(actionType: ActionType, input: String) {
        val inputNumber = input.toIntOrNull() ?: 0
        when (actionType) {
            ActionType.PULS ->
                _currenValue.value = _currenValue.value?.plus(inputNumber)
            ActionType.MINUS ->
                _currenValue.value = _currenValue.value?.minus(inputNumber)
        }
    }
}
