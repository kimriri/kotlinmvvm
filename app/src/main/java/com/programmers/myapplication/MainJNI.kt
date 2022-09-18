package com.programmers.myapplication

class MainJNI {


    companion object {
        init {
            System.loadLibrary("myapplication")

        }
        const val TAG: String = "LOG"
    }
    /** title text en */
    external fun stringFromJNI(): String

    /** title text ko */
    external fun getLineFromJNI(prompt: String,value : Int): String


    fun setStringFromJNI(): String {
       return stringFromJNI()
    }




}
