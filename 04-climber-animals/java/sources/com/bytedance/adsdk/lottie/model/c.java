package com.bytedance.adsdk.lottie.model;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    private final String ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public final float f179ms;
    public final float xr;

    public c(String str, float f, float f2) {
        this.ah = str;
        this.xr = f2;
        this.f179ms = f;
    }

    public boolean ms(String str) {
        if (this.ah.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.ah.endsWith("\r")) {
            String str2 = this.ah;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
