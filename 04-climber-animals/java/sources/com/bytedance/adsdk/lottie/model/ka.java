package com.bytedance.adsdk.lottie.model;

import com.bytedance.adsdk.lottie.u;

/* JADX INFO: loaded from: classes2.dex */
public class ka {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final ka f181ms = new ka();
    private final u<String, com.bytedance.adsdk.lottie.c> xr = new u<>(20);

    public static ka ms() {
        return f181ms;
    }

    ka() {
    }

    public com.bytedance.adsdk.lottie.c ms(String str) {
        if (str == null) {
            return null;
        }
        return this.xr.ms(str);
    }

    public void ms(String str, com.bytedance.adsdk.lottie.c cVar) {
        if (str == null) {
            return;
        }
        this.xr.ms(str, cVar);
    }
}
