package com.kwad.sdk.api.loader;

import android.os.Process;

/* JADX INFO: loaded from: classes3.dex */
class VMRuntimeCompat {
    VMRuntimeCompat() {
    }

    static boolean is64Bit() {
        return Process.is64Bit();
    }

    public static String getSDKAbi() {
        return is64Bit() ? "arm64-v8a" : "armeabi-v7a";
    }
}
