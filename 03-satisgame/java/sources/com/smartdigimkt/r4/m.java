package com.smartdigimkt.r4;

import com.smartdigimkt.sdk.api.SDMAdConst;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class m {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[SDMAdConst.CURRENCY.values().length];
        a = iArr;
        try {
            iArr[SDMAdConst.CURRENCY.RMB.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[SDMAdConst.CURRENCY.RMB_CENT.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[SDMAdConst.CURRENCY.USD.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
