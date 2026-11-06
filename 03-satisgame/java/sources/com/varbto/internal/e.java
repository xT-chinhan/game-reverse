package com.varbto.internal;

import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import kotlin.UByte;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e {
    public static final byte[] a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, com.anythink.core.common.r.a.c.c, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};

    static {
        new HashMap();
    }

    public static String a(String str) {
        byte[] byteArray;
        int i;
        byte b;
        int i2;
        byte b2;
        int i3;
        byte b3;
        int i4;
        byte b4;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
        int i5 = 0;
        while (i5 < length) {
            while (true) {
                i = i5 + 1;
                int i6 = bytes[i5] & UByte.MAX_VALUE;
                b = i6 < 128 ? a[i6] : (byte) -1;
                if (i >= length || b != -1) {
                    break;
                }
                i5 = i;
            }
            if (b == -1) {
                break;
            }
            while (true) {
                i2 = i + 1;
                int i7 = bytes[i] & UByte.MAX_VALUE;
                b2 = i7 < 128 ? a[i7] : (byte) -1;
                if (i2 >= length || b2 != -1) {
                    break;
                }
                i = i2;
            }
            if (b2 == -1) {
                break;
            }
            byteArrayOutputStream.write((b << 2) | ((b2 & 48) >>> 4));
            while (true) {
                i3 = i2 + 1;
                int i8 = bytes[i2] & UByte.MAX_VALUE;
                if (i8 == 61) {
                    byteArray = byteArrayOutputStream.toByteArray();
                } else {
                    b3 = i8 < 128 ? a[i8] : (byte) -1;
                    if (i3 >= length || b3 != -1) {
                        break;
                    }
                    i2 = i3;
                }
                return new String(byteArray);
            }
            if (b3 == -1) {
                break;
            }
            byteArrayOutputStream.write(((b2 & 15) << 4) | ((b3 & 60) >>> 2));
            while (true) {
                i4 = i3 + 1;
                int i9 = bytes[i3] & UByte.MAX_VALUE;
                if (i9 == 61) {
                    byteArray = byteArrayOutputStream.toByteArray();
                } else {
                    b4 = i9 < 128 ? a[i9] : (byte) -1;
                    if (i4 >= length || b4 != -1) {
                        break;
                    }
                    i3 = i4;
                }
                return new String(byteArray);
            }
            if (b4 == -1) {
                break;
            }
            byteArrayOutputStream.write(b4 | ((b3 & 3) << 6));
            i5 = i4;
        }
        byteArray = byteArrayOutputStream.toByteArray();
        return new String(byteArray);
    }
}
