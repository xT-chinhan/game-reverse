package com.anythink.unitybridge;

import android.app.Activity;
import com.unity3d.player.UnityPlayer;

/* JADX INFO: loaded from: classes.dex */
public class UnityPluginUtils {
    public static final String TAG = "AT_android_unity3d";

    public static Activity getActivity(String str) {
        return UnityPlayer.currentActivity;
    }

    public static void runOnUiThread(Runnable runnable) {
        try {
            UnityPlayer.currentActivity.runOnUiThread(runnable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
