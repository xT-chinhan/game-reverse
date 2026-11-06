package com.byazt.ca;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.analytics.pro.cc;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ANSWER_RECV_TIME, 109})
public class w {
    public static final byte[] c;
    public static final int fw;
    public static final byte[] hn;
    public static final byte[] hw;
    public static final byte[] pr;
    public static final byte[] uc;
    public static final byte[] x;

    static {
        byte[] bArr = {-1, -40, -1};
        pr = bArr;
        byte[] bArr2 = {-119, 80, 78, 71, cc.k, 10, 26, 10};
        hw = bArr2;
        byte[] bArr3 = {0, 0, 1, 0};
        hn = bArr3;
        byte[] bArrPr = pr("BM");
        x = bArrPr;
        c = pr("GIF87a");
        uc = pr("GIF89a");
        fw = ((Integer) Collections.max(Arrays.asList(Integer.valueOf(bArr.length), Integer.valueOf(bArr2.length), Integer.valueOf(bArr3.length), Integer.valueOf(bArrPr.length), 6))).intValue();
    }

    public static int pr() {
        return fw;
    }

    public static final String pr(byte[] bArr) {
        if (hw(bArr)) {
            return "jpeg";
        }
        if (hn(bArr)) {
            return "png";
        }
        if (x(bArr)) {
            return "gif";
        }
        if (c(bArr)) {
            return "bmp";
        }
        if (uc(bArr)) {
            return "ico";
        }
        return "other";
    }

    private static boolean hw(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = pr;
        return length >= bArr2.length && pr(bArr, bArr2);
    }

    private static boolean hn(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = hw;
        return length >= bArr2.length && pr(bArr, bArr2);
    }

    private static boolean x(byte[] bArr) {
        return (bArr.length >= 6 && pr(bArr, c)) || pr(bArr, uc);
    }

    private static boolean c(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = x;
        return length >= bArr2.length && pr(bArr, bArr2);
    }

    private static boolean uc(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = hn;
        return length >= bArr2.length && pr(bArr, bArr2);
    }

    private static boolean pr(byte[] bArr, byte[] bArr2) {
        return pr(bArr, bArr2, 0);
    }

    private static boolean pr(byte[] bArr, byte[] bArr2, int i) {
        if (bArr2.length + i > bArr.length) {
            return false;
        }
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            if (bArr[i + i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private static byte[] pr(String str) {
        try {
            return str.getBytes("ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }
}
