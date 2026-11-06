package com.byazt.cpq;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 405, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public final class c {
    public static final com.byazt.du.uc pr = com.byazt.du.uc.pr("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    public static final String[] x = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
    public static final String[] hw = new String[64];
    public static final String[] hn = new String[256];

    static {
        int i = 0;
        int i2 = 0;
        while (true) {
            String[] strArr = hn;
            if (i2 >= strArr.length) {
                break;
            }
            strArr[i2] = com.byazt.xx.hn.pr("%8s", Integer.toBinaryString(i2)).replace(' ', '0');
            i2++;
        }
        String[] strArr2 = hw;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        for (int i3 = 0; i3 <= 0; i3++) {
            int i4 = iArr[i3];
            String[] strArr3 = hw;
            strArr3[i4 | 8] = strArr3[i4] + "|PADDED";
        }
        String[] strArr4 = hw;
        strArr4[4] = "END_HEADERS";
        strArr4[32] = "PRIORITY";
        strArr4[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i5 = 0; i5 < 3; i5++) {
            int i6 = iArr2[i5];
            for (int i7 = 0; i7 <= 0; i7++) {
                int i8 = iArr[i7];
                String[] strArr5 = hw;
                int i9 = i8 | i6;
                strArr5[i9] = strArr5[i8] + '|' + strArr5[i6];
                strArr5[i9 | 8] = strArr5[i8] + '|' + strArr5[i6] + "|PADDED";
            }
        }
        while (true) {
            String[] strArr6 = hw;
            if (i < strArr6.length) {
                if (strArr6[i] == null) {
                    strArr6[i] = hn[i];
                }
                i++;
            } else {
                return;
            }
        }
    }

    private c() {
    }

    public static IllegalArgumentException pr(String str, Object... objArr) {
        throw new IllegalArgumentException(com.byazt.xx.hn.pr(str, objArr));
    }

    public static IOException hw(String str, Object... objArr) throws IOException {
        throw new IOException(com.byazt.xx.hn.pr(str, objArr));
    }

    public static String pr(boolean z, int i, int i2, byte b, byte b2) {
        String[] strArr = x;
        String strPr = b < strArr.length ? strArr[b] : com.byazt.xx.hn.pr("0x%02x", Byte.valueOf(b));
        String strPr2 = pr(b, b2);
        Object[] objArr = new Object[5];
        objArr[0] = z ? "<<" : ">>";
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = strPr;
        objArr[4] = strPr2;
        return com.byazt.xx.hn.pr("%s 0x%08x %5d %-13s %s", objArr);
    }

    public static String pr(byte b, byte b2) {
        if (b2 == 0) {
            return "";
        }
        switch (b) {
            case 2:
            case 3:
            case 7:
            case 8:
                return hn[b2];
            case 4:
            case 6:
                return b2 == 1 ? "ACK" : hn[b2];
            case 5:
            default:
                String[] strArr = hw;
                String str = b2 < strArr.length ? strArr[b2] : hn[b2];
                if (b == 5 && (b2 & 4) != 0) {
                    return str.replace("HEADERS", "PUSH_PROMISE");
                }
                if (b == 0 && (b2 & 32) != 0) {
                    return str.replace("PRIORITY", "COMPRESSED");
                }
                return str;
        }
    }
}
