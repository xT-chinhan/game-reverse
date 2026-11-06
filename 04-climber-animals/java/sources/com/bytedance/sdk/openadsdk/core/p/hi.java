package com.bytedance.sdk.openadsdk.core.p;

import com.umeng.analytics.pro.ek;

/* JADX INFO: loaded from: classes2.dex */
public class hi {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final char[] f3244ms = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    static String ms(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = f3244ms;
            cArr[i] = cArr2[(b >>> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b & ek.m];
        }
        return new String(cArr);
    }
}
