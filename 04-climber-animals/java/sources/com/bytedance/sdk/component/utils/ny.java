package com.bytedance.sdk.component.utils;

import com.kwad.sdk.api.model.AdnName;
import com.umeng.analytics.pro.ek;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
public class ny {
    private static final int ab;
    private static final byte[] ah;
    private static final byte[] c;
    private static final byte[] d;
    private static final byte[] ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final byte[] f1363ms;
    private static final byte[] xr;

    static {
        byte[] bArr = {-1, -40, -1};
        f1363ms = bArr;
        byte[] bArr2 = {-119, 80, 78, 71, ek.k, 10, 26, 10};
        xr = bArr2;
        byte[] bArr3 = {0, 0, 1, 0};
        ah = bArr3;
        byte[] bArrMs = ms("BM");
        d = bArrMs;
        ka = ms("GIF87a");
        c = ms("GIF89a");
        ab = ((Integer) Collections.max(Arrays.asList(Integer.valueOf(bArr.length), Integer.valueOf(bArr2.length), Integer.valueOf(bArr3.length), Integer.valueOf(bArrMs.length), 6))).intValue();
    }

    public static int ms() {
        return ab;
    }

    public static final String ms(byte[] bArr) {
        if (xr(bArr)) {
            return "jpeg";
        }
        if (ah(bArr)) {
            return "png";
        }
        if (d(bArr)) {
            return "gif";
        }
        if (ka(bArr)) {
            return "bmp";
        }
        return c(bArr) ? "ico" : AdnName.OTHER;
    }

    private static boolean xr(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = f1363ms;
        return length >= bArr2.length && ms(bArr, bArr2);
    }

    private static boolean ah(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = xr;
        return length >= bArr2.length && ms(bArr, bArr2);
    }

    private static boolean d(byte[] bArr) {
        return (bArr.length >= 6 && ms(bArr, ka)) || ms(bArr, c);
    }

    private static boolean ka(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = d;
        return length >= bArr2.length && ms(bArr, bArr2);
    }

    private static boolean c(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = ah;
        return length >= bArr2.length && ms(bArr, bArr2);
    }

    private static boolean ms(byte[] bArr, byte[] bArr2) {
        return ms(bArr, bArr2, 0);
    }

    private static boolean ms(byte[] bArr, byte[] bArr2, int i) {
        if (bArr2.length + i > bArr.length) {
            return false;
        }
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            if (bArr[i + i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private static byte[] ms(String str) {
        try {
            return str.getBytes("ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }
}
