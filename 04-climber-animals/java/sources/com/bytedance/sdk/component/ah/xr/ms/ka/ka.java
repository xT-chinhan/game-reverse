package com.bytedance.sdk.component.ah.xr.ms.ka;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class ka {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    static final com.bytedance.sdk.component.ah.ms.c f1095ms = com.bytedance.sdk.component.ah.ms.c.ms("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    private static final String[] d = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
    static final String[] xr = new String[64];
    static final String[] ah = new String[256];

    static {
        int i = 0;
        int i2 = 0;
        while (true) {
            String[] strArr = ah;
            if (i2 >= strArr.length) {
                break;
            }
            strArr[i2] = com.bytedance.sdk.component.ah.xr.ms.ah.ms("%8s", Integer.toBinaryString(i2)).replace(' ', '0');
            i2++;
        }
        String[] strArr2 = xr;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        for (int i3 = 0; i3 <= 0; i3++) {
            int i4 = iArr[i3];
            String[] strArr3 = xr;
            strArr3[i4 | 8] = strArr3[i4] + "|PADDED";
        }
        String[] strArr4 = xr;
        strArr4[4] = "END_HEADERS";
        strArr4[32] = "PRIORITY";
        strArr4[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i5 = 0; i5 < 3; i5++) {
            int i6 = iArr2[i5];
            for (int i7 = 0; i7 <= 0; i7++) {
                int i8 = iArr[i7];
                String[] strArr5 = xr;
                int i9 = i8 | i6;
                strArr5[i9] = strArr5[i8] + '|' + strArr5[i6];
                strArr5[i9 | 8] = strArr5[i8] + '|' + strArr5[i6] + "|PADDED";
            }
        }
        while (true) {
            String[] strArr6 = xr;
            if (i >= strArr6.length) {
                return;
            }
            if (strArr6[i] == null) {
                strArr6[i] = ah[i];
            }
            i++;
        }
    }

    private ka() {
    }

    static IllegalArgumentException ms(String str, Object... objArr) {
        throw new IllegalArgumentException(com.bytedance.sdk.component.ah.xr.ms.ah.ms(str, objArr));
    }

    static IOException xr(String str, Object... objArr) throws IOException {
        throw new IOException(com.bytedance.sdk.component.ah.xr.ms.ah.ms(str, objArr));
    }

    static String ms(boolean z, int i, int i2, byte b, byte b2) {
        String[] strArr = d;
        String strMs = b < strArr.length ? strArr[b] : com.bytedance.sdk.component.ah.xr.ms.ah.ms("0x%02x", Byte.valueOf(b));
        String strMs2 = ms(b, b2);
        Object[] objArr = new Object[5];
        objArr[0] = z ? "<<" : ">>";
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = strMs;
        objArr[4] = strMs2;
        return com.bytedance.sdk.component.ah.xr.ms.ah.ms("%s 0x%08x %5d %-13s %s", objArr);
    }

    static String ms(byte b, byte b2) {
        if (b2 == 0) {
            return "";
        }
        if (b != 2 && b != 3) {
            if (b == 4 || b == 6) {
                return b2 == 1 ? "ACK" : ah[b2];
            }
            if (b != 7 && b != 8) {
                String[] strArr = xr;
                String str = b2 < strArr.length ? strArr[b2] : ah[b2];
                if (b != 5 || (b2 & 4) == 0) {
                    return (b != 0 || (b2 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED");
                }
                return str.replace("HEADERS", "PUSH_PROMISE");
            }
        }
        return ah[b2];
    }
}
