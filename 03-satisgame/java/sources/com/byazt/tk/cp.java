package com.byazt.tk;

import com.kwad.sdk.api.model.AdnName;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 350, 29})
public class cp {
    public static final byte[] l;
    public static final byte[] n;
    public static final byte[] q;
    public static final byte[] qg;
    public static final byte[] s;
    public static final byte[] w;
    public static final int x;

    static {
        byte[] bArr = {-1, -40, -1};
        n = bArr;
        byte[] bArr2 = {-119, 80, 78, 71, 13, 10, 26, 10};
        qg = bArr2;
        byte[] bArr3 = {0, 0, 1, 0};
        s = bArr3;
        byte[] bArrN = n("BM");
        q = bArrN;
        l = n("GIF87a");
        w = n("GIF89a");
        x = ((Integer) Collections.max(Arrays.asList(Integer.valueOf(bArr.length), Integer.valueOf(bArr2.length), Integer.valueOf(bArr3.length), Integer.valueOf(bArrN.length), 6))).intValue();
    }

    public static int n() {
        return x;
    }

    public static final String n(byte[] bArr) {
        if (qg(bArr)) {
            return "jpeg";
        }
        if (s(bArr)) {
            return "png";
        }
        if (q(bArr)) {
            return "gif";
        }
        if (l(bArr)) {
            return "bmp";
        }
        return w(bArr) ? "ico" : AdnName.OTHER;
    }

    private static boolean qg(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = n;
        return length >= bArr2.length && n(bArr, bArr2);
    }

    private static boolean s(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = qg;
        return length >= bArr2.length && n(bArr, bArr2);
    }

    private static boolean q(byte[] bArr) {
        return (bArr.length >= 6 && n(bArr, l)) || n(bArr, w);
    }

    private static boolean l(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = q;
        return length >= bArr2.length && n(bArr, bArr2);
    }

    private static boolean w(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = s;
        return length >= bArr2.length && n(bArr, bArr2);
    }

    private static boolean n(byte[] bArr, byte[] bArr2) {
        return n(bArr, bArr2, 0);
    }

    private static boolean n(byte[] bArr, byte[] bArr2, int i) {
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

    private static byte[] n(String str) {
        try {
            return str.getBytes("ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }
}
