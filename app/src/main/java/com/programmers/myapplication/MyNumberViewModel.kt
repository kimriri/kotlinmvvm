package com.programmers.myapplication

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyNumberViewModel() : ViewModel() {

    private val _currenValue = MutableLiveData<Int>()
    private val _cStrValue = MutableLiveData<String>()

    companion object {
        const val TAG: String = "LOG"
    }

    val currenValue: LiveData<Int>
        get() = _currenValue

    val cStrValue: LiveData<String>
        get() = _cStrValue
    
    init {
        Log.d(TAG, "MyNumberViewModel")
        defaultCurrentValue()
    }

    // defaultCurrentValue 는 DefaultInternalObject 로 변경할 수 있다.
    private fun defaultCurrentValue() {
        return if ( _currenValue.value == null) _currenValue.value = DefaultInternalObject.IntZero else _currenValue.value as Unit
    }

    // CurrentValue의 값을 String 형태로 return
    fun setCurrentValueStr(): String {
      return  _currenValue.value?.toString() ?: DefaultInternalObject.StrZero
    }


    // CurrentValue의 값을 Int 형태로 return
    fun CurrentValue(): Int {
        return _currenValue.value?.toInt() ?: DefaultInternalObject.IntZero
    }

    // cStrValue의 값을 Int 형태로 return
    fun setcStr(): String{
        return _cStrValue.value?.toString() ?: MainJNI().stringFromJNI()
    }

    // cStrValue의 값을 Int 형태로 return
    fun setcStrchangeUTF(): String{
        return _cStrValue.value?.toString() ?: MainJNI().getLineFromJNI("입력값",1);
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
