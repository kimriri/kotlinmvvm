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

    /** title text ko
     * @prompt -> 입력한 문자가 Log로 출력 됩니다.
     * @value
     * 0 : (return ->  안녕하세요.)
     * 1 : (return ->  어서오세요.)
     * else : (return ->  안녕히가세요.)
     */
    external fun getLineFromJNI(prompt: String,value : Int): String


    fun setStringFromJNI(): String {
       return stringFromJNI()
    }




}
