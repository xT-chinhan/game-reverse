package com.byazt.hf;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 938, 18})
public final class l {
    public static final com.byazt.wa.w n = com.byazt.wa.w.n("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    public static final String[] q = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
    public static final String[] qg = new String[64];
    public static final String[] s = new String[256];

    static {
        int i = 0;
        int i2 = 0;
        while (true) {
            String[] strArr = s;
            if (i2 >= strArr.length) {
                break;
            }
            strArr[i2] = com.byazt.zho.s.n("%8s", Integer.toBinaryString(i2)).replace(' ', '0');
            i2++;
        }
        String[] strArr2 = qg;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        for (int i3 = 0; i3 <= 0; i3++) {
            int i4 = iArr[i3];
            String[] strArr3 = qg;
            strArr3[i4 | 8] = strArr3[i4] + "|PADDED";
        }
        String[] strArr4 = qg;
        strArr4[4] = "END_HEADERS";
        strArr4[32] = "PRIORITY";
        strArr4[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i5 = 0; i5 < 3; i5++) {
            int i6 = iArr2[i5];
            for (int i7 = 0; i7 <= 0; i7++) {
                int i8 = iArr[i7];
                String[] strArr5 = qg;
                int i9 = i8 | i6;
                strArr5[i9] = strArr5[i8] + '|' + strArr5[i6];
                strArr5[i9 | 8] = strArr5[i8] + '|' + strArr5[i6] + "|PADDED";
            }
        }
        while (true) {
            String[] strArr6 = qg;
            if (i >= strArr6.length) {
                return;
            }
            if (strArr6[i] == null) {
                strArr6[i] = s[i];
            }
            i++;
        }
    }

    private l() {
    }

    public static IllegalArgumentException n(String str, Object... objArr) {
        throw new IllegalArgumentException(com.byazt.zho.s.n(str, objArr));
    }

    public static IOException qg(String str, Object... objArr) throws IOException {
        throw new IOException(com.byazt.zho.s.n(str, objArr));
    }

    public static String n(boolean z, int i, int i2, byte b, byte b2) {
        String[] strArr = q;
        String strN = b < strArr.length ? strArr[b] : com.byazt.zho.s.n("0x%02x", Byte.valueOf(b));
        String strN2 = n(b, b2);
        Object[] objArr = new Object[5];
        objArr[0] = z ? "<<" : ">>";
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = strN;
        objArr[4] = strN2;
        return com.byazt.zho.s.n("%s 0x%08x %5d %-13s %s", objArr);
    }

    public static String n(byte b, byte b2) {
        if (b2 == 0) {
            return "";
        }
        if (b != 2 && b != 3) {
            if (b == 4 || b == 6) {
                return b2 == 1 ? "ACK" : s[b2];
            }
            if (b != 7 && b != 8) {
                String[] strArr = qg;
                String str = b2 < strArr.length ? strArr[b2] : s[b2];
                if (b != 5 || (b2 & 4) == 0) {
                    return (b != 0 || (b2 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED");
                }
                return str.replace("HEADERS", "PUSH_PROMISE");
            }
        }
        return s[b2];
    }
}
