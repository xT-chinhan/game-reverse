package com.anythink.core.common.h;

/* JADX INFO: loaded from: classes.dex */
public final class r extends bl {
    public static final int a = 1;
    public static final int b = 2;
    public static final String c = "return_flag";
    public static final String d = "sdk_native_im_w";
    public static final String e = "sdk_native_im_h";
    private String aD;
    private String aE;
    private int aF = 1;
    private int aG;

    private String Q() {
        return this.aE;
    }

    private void w(String str) {
        this.aE = str;
    }

    private String R() {
        return this.aD;
    }

    private void x(String str) {
        this.aD = str;
    }

    private int S() {
        return this.aF;
    }

    private void d(int i) {
        this.aF = i;
    }

    @Override // com.anythink.core.common.h.w
    public final int a() {
        return this.aF == 1 ? 2 : 4;
    }

    private int T() {
        return this.aG;
    }

    private void e(int i) {
        this.aG = i;
    }
}
