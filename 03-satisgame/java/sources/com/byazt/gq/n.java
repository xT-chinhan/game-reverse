package com.byazt.gq;

import android.text.TextUtils;
import java.io.IOException;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1959, 19})
public class n extends l {
    public static ThreadLocal<byte[]> qg = new ThreadLocal<>();

    public static byte[] n() {
        byte[] bArr = qg.get();
        if (bArr != null) {
            return bArr;
        }
        byte[] bArr2 = new byte[4];
        qg.set(bArr2);
        return bArr2;
    }

    public n(w wVar) {
        super(wVar);
    }

    public int qg() throws IOException {
        byte[] bArrN = n();
        n(bArrN, 0, 4);
        return ((bArrN[0] & UByte.MAX_VALUE) << 24) | (bArrN[3] & UByte.MAX_VALUE) | ((bArrN[2] & UByte.MAX_VALUE) << 8) | ((bArrN[1] & UByte.MAX_VALUE) << 16);
    }

    public short a_() throws IOException {
        byte[] bArrN = n();
        n(bArrN, 0, 2);
        return (short) (((bArrN[0] & UByte.MAX_VALUE) << 8) | (bArrN[1] & UByte.MAX_VALUE));
    }

    public boolean n(String str) throws IOException {
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
        byte[] bArrN = n();
        n(bArrN, 0, 4);
        return ((bArrN[3] & UByte.MAX_VALUE) << 24) | (bArrN[0] & UByte.MAX_VALUE) | ((bArrN[1] & UByte.MAX_VALUE) << 8) | ((bArrN[2] & UByte.MAX_VALUE) << 16);
    }
}
