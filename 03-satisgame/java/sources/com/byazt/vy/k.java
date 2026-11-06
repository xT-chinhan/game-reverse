package com.byazt.vy;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1431, 210})
public class k {
    public static final MessageDigest qg = n();
    public static final Charset n = Charset.forName("UTF-8");
    public static final char[] s = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private k() {
    }

    private static MessageDigest n() {
        try {
            return MessageDigest.getInstance("md5");
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static String n(String str) {
        byte[] bArrDigest;
        MessageDigest messageDigest = qg;
        if (str == null) {
            return "";
        }
        byte[] bytes = str.getBytes(n);
        synchronized (k.class) {
            bArrDigest = messageDigest.digest(bytes);
        }
        return n(bArrDigest);
    }

    public static String n(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        char[] cArr = new char[bArr.length << 1];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = s;
            cArr[i] = cArr2[(b & 240) >> 4];
            i = i2 + 1;
            cArr[i2] = cArr2[b & 15];
        }
        return new String(cArr);
    }
}
