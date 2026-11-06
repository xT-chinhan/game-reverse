package com.efs.sdk.memleaksdk.monitor;

import com.efs.sdk.memleaksdk.monitor.shark.g;

/* JADX INFO: loaded from: classes2.dex */
public class UMonitorJNI {
    public static final boolean a;

    public static native void exit();

    public static native void init();

    public static native void initStrip();

    public static native void initStripPath(String str, String str2);

    public static native boolean resumeVM(int i);

    public static native int suspendVM();

    static {
        boolean z;
        try {
            System.loadLibrary("umonitor");
            z = true;
        } catch (Throwable th) {
            g.b("UMonitor.JNI", "loadLibrary failed", th);
            z = false;
        }
        a = z;
    }
}
