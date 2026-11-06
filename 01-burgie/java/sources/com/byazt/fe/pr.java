package com.byazt.fe;

import android.text.TextUtils;
import java.io.IOException;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1390, 37})
public class pr extends c {
    public static ThreadLocal<byte[]> hw = new ThreadLocal<>();

    public static byte[] pr() {
        byte[] bArr = hw.get();
        if (bArr == null) {
            byte[] bArr2 = new byte[4];
            hw.set(bArr2);
            return bArr2;
        }
        return bArr;
    }

    public pr(uc ucVar) {
        super(ucVar);
    }

    public int hw() throws IOException {
        byte[] bArrPr = pr();
        pr(bArrPr, 0, 4);
        return ((bArrPr[0] & UByte.MAX_VALUE) << 24) | (bArrPr[3] & UByte.MAX_VALUE) | ((bArrPr[2] & UByte.MAX_VALUE) << 8) | ((bArrPr[1] & UByte.MAX_VALUE) << 16);
    }

    public short a_() throws IOException {
        byte[] bArrPr = pr();
        pr(bArrPr, 0, 2);
        return (short) (((bArrPr[0] & UByte.MAX_VALUE) << 8) | (bArrPr[1] & UByte.MAX_VALUE));
    }

    public boolean pr(String str) throws IOException {
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
        byte[] bArrPr = pr();
        pr(bArrPr, 0, 4);
        return ((bArrPr[3] & UByte.MAX_VALUE) << 24) | (bArrPr[0] & UByte.MAX_VALUE) | ((bArrPr[1] & UByte.MAX_VALUE) << 8) | ((bArrPr[2] & UByte.MAX_VALUE) << 16);
    }
}
