package com.taptap.sdk.themis.lite;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public class ThemisLite {
    public static Context m_ctx = null;
    public static String version = "1.0.7";
    private static final Object lock = new Object();

    private static native void Z8f7JxQk(String str, boolean z, boolean z2, long j);

    private static native void vQe8bYsT(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public static native String xJ3kLm9Q();

    /* JADX INFO: Access modifiers changed from: private */
    public static native String zXq3tVwP();

    public static void Register(Context ctx) {
        m_ctx = ctx;
    }

    private static void CallbackRunner(final ThemisLiteCallback callback, long timeOut) {
        if (callback == null) {
            return;
        }
        if (timeOut < 100) {
            timeOut = 100;
        }
        Runnable task = new Runnable() { // from class: com.taptap.sdk.themis.lite.ThemisLite.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (ThemisLite.lock) {
                    try {
                        LogUtil.debug(Base64Util.decode("Q2FsbGJhY2tSdW5uZXIgb24gaWY6"));
                        callback.tdidCallback(ThemisLite.xJ3kLm9Q());
                        callback.gidDataCallback(ThemisLite.zXq3tVwP());
                    } catch (Exception e) {
                        LogUtil.debug(Base64Util.decode("Q2FsbGJhY2tSdW5uZXI6") + e.getMessage());
                    }
                }
            }
        };
        Thread subThread = new Thread(task);
        subThread.start();
    }

    public static void WakeUpCallback() {
        Object obj = lock;
        synchronized (obj) {
            obj.notify();
        }
    }

    public static void InitThemis_v3(String appID, ThemisLiteCallback callback, String preGid, long timeOut) {
        if (callback == null) {
            return;
        }
        try {
            LogUtil.info(Base64Util.decode("c3RhcnQgaW5pdCBUaGVtaXNMaXRlIGJ5IEphdmEsIFZlcnNpb246IDEuMC43"));
            System.loadLibrary("themis");
            Z8f7JxQk(appID, true, true, timeOut);
            vQe8bYsT(preGid);
            CallbackRunner(callback, timeOut);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
