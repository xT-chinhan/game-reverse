package com.anythink.core.common.n.b.a.e;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class e {
    static final int b = 16384;
    static final byte c = 0;
    static final byte d = 1;
    static final byte e = 2;
    static final byte f = 3;
    static final byte g = 4;
    static final byte h = 5;
    static final byte i = 6;
    static final byte j = 7;
    static final byte k = 8;
    static final byte l = 9;
    static final byte m = 0;
    static final byte n = 1;
    static final byte o = 1;
    static final byte p = 4;
    static final byte q = 4;
    static final byte r = 8;
    static final byte s = 32;
    static final byte t = 32;
    static final com.anythink.core.common.n.c.f a = com.anythink.core.common.n.c.f.a("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    private static final String[] w = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
    static final String[] u = new String[64];
    static final String[] v = new String[256];

    static {
        int i2 = 0;
        int i3 = 0;
        while (true) {
            String[] strArr = v;
            if (i3 >= strArr.length) {
                break;
            }
            strArr[i3] = com.anythink.core.common.n.b.a.c.a("%8s", Integer.toBinaryString(i3)).replace(' ', '0');
            i3++;
        }
        String[] strArr2 = u;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        for (int i4 = 0; i4 <= 0; i4++) {
            int i5 = iArr[i4];
            String[] strArr3 = u;
            strArr3[i5 | 8] = strArr3[i5] + "|PADDED";
        }
        String[] strArr4 = u;
        strArr4[4] = "END_HEADERS";
        strArr4[32] = "PRIORITY";
        strArr4[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i6 = 0; i6 < 3; i6++) {
            int i7 = iArr2[i6];
            for (int i8 = 0; i8 <= 0; i8++) {
                int i9 = iArr[i8];
                String[] strArr5 = u;
                int i10 = i9 | i7;
                strArr5[i10] = strArr5[i9] + '|' + strArr5[i7];
                strArr5[i10 | 8] = strArr5[i9] + '|' + strArr5[i7] + "|PADDED";
            }
        }
        while (true) {
            String[] strArr6 = u;
            if (i2 >= strArr6.length) {
                return;
            }
            if (strArr6[i2] == null) {
                strArr6[i2] = v[i2];
            }
            i2++;
        }
    }

    private e() {
    }

    static IllegalArgumentException a(String str, Object... objArr) {
        throw new IllegalArgumentException(com.anythink.core.common.n.b.a.c.a(str, objArr));
    }

    static IOException b(String str, Object... objArr) throws IOException {
        throw new IOException(com.anythink.core.common.n.b.a.c.a(str, objArr));
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0067  */
    static String a(boolean z, int i2, int i3, byte b2, byte b3) {
        String strReplace;
        String[] strArr = w;
        String strA = b2 < strArr.length ? strArr[b2] : com.anythink.core.common.n.b.a.c.a("0x%02x", Byte.valueOf(b2));
        if (b3 == 0) {
            strReplace = "";
        } else if (b2 == 2 || b2 == 3) {
            strReplace = v[b3];
        } else if (b2 == 4 || b2 == 6) {
            strReplace = b3 == 1 ? "ACK" : v[b3];
        } else if (b2 == 7 || b2 == 8) {
            strReplace = v[b3];
        } else {
            String[] strArr2 = u;
            String str = b3 < strArr2.length ? strArr2[b3] : v[b3];
            if (b2 == 5 && (b3 & 4) != 0) {
                strReplace = str.replace("HEADERS", "PUSH_PROMISE");
            } else {
                strReplace = (b2 != 0 || (b3 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED");
            }
        }
        Object[] objArr = new Object[5];
        objArr[0] = z ? "<<" : ">>";
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Integer.valueOf(i3);
        objArr[3] = strA;
        objArr[4] = strReplace;
        return com.anythink.core.common.n.b.a.c.a("%s 0x%08x %5d %-13s %s", objArr);
    }

    private static String a(byte b2, byte b3) {
        if (b3 == 0) {
            return "";
        }
        if (b2 != 2 && b2 != 3) {
            if (b2 == 4 || b2 == 6) {
                return b3 == 1 ? "ACK" : v[b3];
            }
            if (b2 != 7 && b2 != 8) {
                String[] strArr = u;
                String str = b3 < strArr.length ? strArr[b3] : v[b3];
                if (b2 != 5 || (b3 & 4) == 0) {
                    return (b2 != 0 || (b3 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED");
                }
                return str.replace("HEADERS", "PUSH_PROMISE");
            }
        }
        return v[b3];
    }
}
