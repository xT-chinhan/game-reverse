package com.bytedance.adsdk.xr.ms;

/* JADX INFO: loaded from: classes2.dex */
public class xr extends RuntimeException {
    public xr(String str, Throwable th) {
        super("Unable to parse expression:".concat(String.valueOf(str)), th);
    }
}
