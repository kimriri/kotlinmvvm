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

    const char *str = env->GetStringUTFChars(prompt,NULL);
    int getNumber = value * 0.8;
    if(str == NULL) {
        return NULL;
    }
    __android_log_print(ANDROID_LOG_INFO,"App Debug", "%s(%d) ", str, getNumber);
    env->ReleaseStringUTFChars(prompt,str);

    const char *buf = "안녕하세요.";

    return env->NewStringUTF(buf);

}
