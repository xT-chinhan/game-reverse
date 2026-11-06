package com.byazt.tka;

import android.os.Build;
import android.text.TextUtils;
import java.security.SecureRandom;
import java.util.Random;
import kotlin.UByte;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 689, 26})
public class qg {
    public static final char[] n = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    @com.byazt.cp.n(n = {0, 1, 689, 48})
    static class n {
        public static final Random n = qg.s();
    }

    public static String n(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        return n(bArr, 0, bArr.length);
    }

    public static String n(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        if (i < 0 || i + i2 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        int i3 = i2 * 2;
        char[] cArr = new char[i3];
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = bArr[i5 + i] & UByte.MAX_VALUE;
            int i7 = i4 + 1;
            char[] cArr2 = n;
            cArr[i4] = cArr2[i6 >> 4];
            i4 = i7 + 1;
            cArr[i7] = cArr2[i6 & 15];
        }
        return new String(cArr, 0, i3);
    }

    public static String n(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String strN = n();
        String strN2 = n(strN, 32);
        String strQg = qg();
        String strN3 = (strN2 == null || strQg == null) ? null : com.byazt.tka.n.n(str, strQg, strN2);
        StringBuilder sb = new StringBuilder("3");
        sb.append(strN).append(strQg).append(strN3);
        return sb.toString();
    }

    public static String qg(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 49) {
            return str;
        }
        String strN = n(str.substring(1, 33), 32);
        String strSubstring = str.substring(33, 49);
        return (strSubstring == null || strN == null) ? str : com.byazt.tka.n.qg(str.substring(49), strSubstring, strN);
    }

    public static String n() {
        String strN = n(16);
        if (strN == null || strN.length() != 32) {
            return null;
        }
        return strN;
    }

    public static String n(String str, int i) {
        if (str == null || str.length() != i) {
            return null;
        }
        int i2 = i / 2;
        return str.substring(i2, i) + str.substring(0, i2);
    }

    public static String qg() {
        String strN = n(8);
        if (strN == null || strN.length() != 16) {
            return null;
        }
        return strN;
    }

    public static String n(int i) {
        try {
            byte[] bArr = new byte[i];
            n.n.nextBytes(bArr);
            return n(bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Random s() {
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                return SecureRandom.getInstanceStrong();
            } catch (Throwable unused) {
                return new SecureRandom();
            }
        }
        return new SecureRandom();
    }
}
