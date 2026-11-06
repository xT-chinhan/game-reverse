package com.bytedance.pangle.util;

import com.umeng.analytics.pro.ek;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final char[] f698ms = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String ms(String str) {
        return ms(str.getBytes());
    }

    public static String ms(byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(bArr);
                return xr(messageDigest.digest());
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private static String xr(byte[] bArr) {
        int length;
        if (bArr == null || (length = bArr.length) <= 0) {
            return null;
        }
        char[] cArr = new char[length << 1];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = f698ms;
            cArr[i] = cArr2[(b >>> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b & ek.m];
        }
        return new String(cArr);
    }

    public static String ms(File file) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[8192];
            while (true) {
                int i = fileInputStream.read(bArr, 0, 8192);
                if (i > 0) {
                    messageDigest.update(bArr, 0, i);
                } else {
                    fileInputStream.close();
                    return xr(messageDigest.digest());
                }
            }
        } catch (Exception unused) {
            return null;
        }
    }
}
