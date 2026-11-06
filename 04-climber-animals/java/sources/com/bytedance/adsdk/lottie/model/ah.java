package com.bytedance.adsdk.lottie.model;

import android.graphics.Typeface;

/* JADX INFO: loaded from: classes2.dex */
public class ah {
    private final String ah;
    private final float d;
    private Typeface ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final String f178ms;
    private final String xr;

    public ah(String str, String str2, String str3, float f) {
        this.f178ms = str;
        this.xr = str2;
        this.ah = str3;
        this.d = f;
    }

    public String ms() {
        return this.f178ms;
    }

    public String xr() {
        return this.xr;
    }

    public String ah() {
        return this.ah;
    }

    public Typeface d() {
        return this.ka;
    }

    public void ms(Typeface typeface) {
        this.ka = typeface;
    }
}
