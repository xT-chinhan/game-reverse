package com.mcto.sspsdk.internal;

import com.mcto.sspsdk.QyBannerStyle;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class w2 {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[QyBannerStyle.values().length];
        a = iArr;
        try {
            iArr[QyBannerStyle.QYBANNER_TITLEIN.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            a[QyBannerStyle.QYBANNER_TITLEBELOW.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            a[QyBannerStyle.QYBANNER_TITLEABOVE.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            a[QyBannerStyle.QYBANNER_STRIP.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            a[QyBannerStyle.QYBANNER_TITLEBUTTON.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
    }
}
