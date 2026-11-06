package com.byazt.zn;

import com.anythink.core.common.d.i;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1404, 19})
public class n {
    public static String n(byte[] bArr, int i) {
        StringBuilder sb = new StringBuilder(i.E);
        for (int i2 = 0; i2 < bArr.length; i2++) {
            sb.append(String.format("%02X", Byte.valueOf(bArr[i2])));
            if (i2 > 0 && i2 % i == 0 && i2 != bArr.length - 1) {
                sb.append("/.");
            }
        }
        return sb.toString();
    }

    public static byte[] n(String str) {
        String strReplaceAll = str.replaceAll("/", "").replaceAll("\\.", "");
        int length = strReplaceAll.length();
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(strReplaceAll.charAt(i), 16) << 4) + Character.digit(strReplaceAll.charAt(i + 1), 16));
        }
        return bArr;
    }
}
