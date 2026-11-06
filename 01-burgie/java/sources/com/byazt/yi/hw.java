package com.byazt.yi;

import android.os.Build;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.security.SecureRandom;
import java.util.Random;
import kotlin.UByte;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 586, 13})
public class hw {
    public static final char[] pr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    @com.byazt.vzx.pr(pr = {0, 1, 586, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD})
    static class pr {
        public static final Random pr = hw.hn();
    }

    public static String pr(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        return pr(bArr, 0, bArr.length);
    }

    public static String pr(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        if (i < 0 || i + i2 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        int i3 = i2 * 2;
        char[] cArr = new char[i3];
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = bArr[i5 + i] & UByte.MAX_VALUE;
            int i7 = i4 + 1;
            char[] cArr2 = pr;
            cArr[i4] = cArr2[i6 >> 4];
            i4 = i7 + 1;
            cArr[i7] = cArr2[i6 & 15];
        }
        return new String(cArr, 0, i3);
    }

    public static String pr(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String strPr = pr();
        String strPr2 = pr(strPr, 32);
        String strHw = hw();
        String strPr3 = null;
        if (strPr2 != null && strHw != null) {
            strPr3 = com.byazt.yi.pr.pr(str, strHw, strPr2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(3).append(strPr).append(strHw).append(strPr3);
        return sb.toString();
    }

    public static String hw(String str) {
        if (!TextUtils.isEmpty(str) && str.length() >= 49) {
            String strPr = pr(str.substring(1, 33), 32);
            String strSubstring = str.substring(33, 49);
            if (strSubstring != null && strPr != null) {
                return com.byazt.yi.pr.hw(str.substring(49), strSubstring, strPr);
            }
            return str;
        }
        return str;
    }

    public static String pr() {
        String strPr = pr(16);
        if (strPr == null || strPr.length() != 32) {
            return null;
        }
        return strPr;
    }

    public static String pr(String str, int i) {
        if (str == null || str.length() != i) {
            return null;
        }
        int i2 = i / 2;
        return str.substring(i2, i) + str.substring(0, i2);
    }

    public static String hw() {
        String strPr = pr(8);
        if (strPr == null || strPr.length() != 16) {
            return null;
        }
        return strPr;
    }

    public static String pr(int i) {
        try {
            byte[] bArr = new byte[i];
            pr.pr.nextBytes(bArr);
            return pr(bArr);
        } catch (Exception e) {
            return null;
        }
    }

    public static Random hn() {
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                return SecureRandom.getInstanceStrong();
            } catch (Throwable th) {
                return new SecureRandom();
            }
        }
        return new SecureRandom();
    }
}
