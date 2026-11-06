package com.anythink.unitybridge;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class MsgTools {
    private static final String TAG = "AT_android_unity3d";
    public static boolean isDebug = true;

    public static void printMsg(String str) {
        if (isDebug) {
            Log.d("AT_android_unity3d", str);
        }
    }

    public static void printMsg(String str, String str2) {
        if (isDebug) {
            Log.d("AT_android_unity3d", str + str2);
        }
    }
}
