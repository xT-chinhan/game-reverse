package com.bytedance.adsdk.lottie.ah;

import com.anythink.dlopt.common.a.a;

/* JADX INFO: loaded from: classes2.dex */
public enum ah {
    JSON(".json"),
    ZIP(".zip");

    public final String ah;

    ah(String str) {
        this.ah = str;
    }

    public String ms() {
        return a.f + this.ah;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.ah;
    }
}
