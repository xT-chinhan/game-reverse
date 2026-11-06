package com.mcto.sspsdk.internal;

import android.widget.ImageView;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class wg {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[ImageView.ScaleType.values().length];
        a = iArr;
        try {
            iArr[ImageView.ScaleType.FIT_XY.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            a[ImageView.ScaleType.FIT_START.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 6;
        } catch (NoSuchFieldError e6) {
        }
    }
}
