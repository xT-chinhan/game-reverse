package com.gopherhole.androidvibrate;

import android.app.Activity;
import android.os.Vibrator;

/* JADX INFO: loaded from: classes3.dex */
public class AndroidVibrate {
    private Activity _unityActivity;
    private Vibrator mVibrator;

    Activity getActivity() {
        if (this._unityActivity == null) {
            try {
                Class<?> cls = Class.forName("com.unity3d.player.UnityPlayer");
                this._unityActivity = (Activity) cls.getDeclaredField("currentActivity").get(cls);
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException unused) {
            }
        }
        return this._unityActivity;
    }

    public boolean Vibrate(int i) {
        Vibrator vibrator = (Vibrator) getActivity().getSystemService("vibrator");
        this.mVibrator = vibrator;
        vibrator.vibrate(new long[]{0, i}, -1);
        return true;
    }
}
