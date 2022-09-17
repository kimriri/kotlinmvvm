package com.programmers.myapplication

class MainJNI {


    companion object {
        init {
            System.loadLibrary("myapplication")
        }
        const val TAG: String = "LOG"
    }
    external fun stringFromJNI(): String

    fun setStringFromJNI(): String {
       return stringFromJNI()
    }


}
