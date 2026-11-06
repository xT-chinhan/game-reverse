package com.bytedance.adsdk.ms.ms.xr;

import android.text.TextUtils;
import java.io.IOException;
import kotlin.UByte;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends ka {
    private static ThreadLocal<byte[]> xr = new ThreadLocal<>();

    protected static byte[] ms() {
        byte[] bArr = xr.get();
        if (bArr != null) {
            return bArr;
        }
        byte[] bArr2 = new byte[4];
        xr.set(bArr2);
        return bArr2;
    }

    public ms(c cVar) {
        super(cVar);
    }

    public int xr() throws IOException {
        byte[] bArrMs = ms();
        ms(bArrMs, 0, 4);
        return ((bArrMs[0] & UByte.MAX_VALUE) << 24) | (bArrMs[3] & UByte.MAX_VALUE) | ((bArrMs[2] & UByte.MAX_VALUE) << 8) | ((bArrMs[1] & UByte.MAX_VALUE) << 16);
    }

    public short a_() throws IOException {
        byte[] bArrMs = ms();
        ms(bArrMs, 0, 2);
        return (short) (((bArrMs[0] & UByte.MAX_VALUE) << 8) | (bArrMs[1] & UByte.MAX_VALUE));
    }

    public boolean ms(String str) throws IOException {
        if (TextUtils.isEmpty(str) || str.length() != 4) {
            return false;
        }
        int iB_ = b_();
        for (int i = 0; i < 4; i++) {
            if (((iB_ >> (i * 8)) & 255) != str.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public int b_() throws IOException {
        byte[] bArrMs = ms();
        ms(bArrMs, 0, 4);
        return ((bArrMs[3] & UByte.MAX_VALUE) << 24) | (bArrMs[0] & UByte.MAX_VALUE) | ((bArrMs[1] & UByte.MAX_VALUE) << 8) | ((bArrMs[2] & UByte.MAX_VALUE) << 16);
    }
}
