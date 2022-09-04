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


    private val _currenValue = MutableLiveData<Int>()

    companion object {
        const val TAG: String = "LOG"
    }

    val currenValue: LiveData<Int>
        get() = _currenValue
    
    init {
        Log.d(TAG, "MyNumberViewModel")
        defaultCurrentValue()
    }

    fun defaultCurrentValue() {
        return if ( _currenValue.value == null) _currenValue.value = DefaultInternalObject.IntZero else _currenValue.value as Unit
    }

    fun setCurrentValue(): String {
      return  _currenValue.value.toString()
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
