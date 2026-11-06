package com.mcto.sspsdk.jni;

/* JADX INFO: loaded from: classes2.dex */
public abstract class SimulatorDetectorJni {
    static {
        try {
            System.loadLibrary("qysdk_simd");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static native boolean isSimulator();

    public static native int ticket();
}
