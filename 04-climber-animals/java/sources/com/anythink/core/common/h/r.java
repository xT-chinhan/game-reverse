package com.anythink.core.common.h;

/* JADX INFO: loaded from: classes.dex */
public final class r extends bj {
    public static final int a = 1;
    public static final int b = 2;
    public static final String c = "return_flag";
    public static final String d = "sdk_native_im_w";
    public static final String e = "sdk_native_im_h";
    private String aD;
    private String aE;
    private int aF = 1;
    private int aG;

    public final String d() {
        return this.aE;
    }

    public final void a(String str) {
        this.aE = str;
    }

    public final String e() {
        return this.aD;
    }

    public final void b(String str) {
        this.aD = str;
    }

    public final int f() {
        return this.aF;
    }

    public final void a(int i) {
        this.aF = i;
    }

    @Override // com.anythink.core.common.h.w
    public final int b() {
        return this.aF == 1 ? 2 : 4;
    }

    public final int g() {
        return this.aG;
    }

    public final void b(int i) {
        this.aG = i;
    }
}
