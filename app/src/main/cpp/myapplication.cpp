#include <jni.h>
#include <string>
#include <android/log.h>

// Write C++ code here.
//
// Do not forget to dynamically load the C++ library into your application.
//
// For instance,
//
// In MainActivity.java:
//    static {
//       System.loadLibrary("myapplication");
//    }
//
// Or, in MainActivity.kt:
//    companion object {
//      init {
//         System.loadLibrary("myapplication")
//      }
//    }



extern "C"
JNIEXPORT jstring JNICALL
/**Show String*/
Java_com_programmers_myapplication_MainJNI_stringFromJNI(JNIEnv *env, jobject thiz) {
    // TODO: implement stringFromJNI()
    std::string hello = "Hello from C++";
    std::string hello2 = "NO VALUE";

    if(hello.empty()) {

        return env->NewStringUTF(hello2.c_str());
    }
    return env->NewStringUTF(hello.c_str());

}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_programmers_myapplication_MainJNI_getLineFromJNI(JNIEnv *env, jobject thiz,jstring prompt,jint value) {
    // TODO: implement getLineFromJNI()
    /**
     * 메모리는 할당하면 반드시 해제 하여야 한다.
     * GetStringUTFChars : 새로운 메모리 할당
     * ReleaseStringUTFChars : 할당된 메모리 해제
     * */

    const char *str = env->GetStringUTFChars(prompt,NULL);
    const int getNumber = value;
    char *buf = "안녕하세요.";
    if(str == NULL) {
        return NULL;
    }
    __android_log_print(ANDROID_LOG_INFO,"App Debug", "%s(%d) ", str, getNumber);
    env->ReleaseStringUTFChars(prompt,str);

    if (getNumber == 0) {
        buf = "안녕하세요.";
    }
    else if (getNumber == 1) {
        buf = "어서오세요.";
    }
    else {
        buf = "안녕히가세요.";
    }
    return env->NewStringUTF(buf);
}
