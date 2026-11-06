package com.byazt.hb;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import androidx.core.view.ViewCompat;
import com.byazt.tk.k;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 583, 19})
public class n {

    /* JADX INFO: renamed from: com.byazt.hb.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 583, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    public static class C0188n {
        public GradientDrawable.Orientation n;
        public int[] qg;
        public float[] s;
    }

    public static int n(String str) {
        return n(str, ViewCompat.MEASURED_STATE_MASK);
    }

    public static int n(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        if (str.equals("transparent")) {
            return 0;
        }
        if (str.charAt(0) == '#' && str.length() == 4) {
            StringBuilder sb = new StringBuilder("#");
            char[] charArray = str.toCharArray();
            for (int i2 = 1; i2 < charArray.length; i2++) {
                sb.append(charArray[i2]).append(charArray[i2]);
            }
            return Color.parseColor(sb.toString());
        }
        if (str.charAt(0) == '#' && str.length() == 7) {
            return Color.parseColor(str);
        }
        if (str.charAt(0) == '#' && str.length() == 9) {
            return Color.parseColor(str);
        }
        if (!str.startsWith("rgba")) {
            return ViewCompat.MEASURED_STATE_MASK;
        }
        String[] strArrSplit = str.substring(str.indexOf("(") + 1, str.indexOf(")")).split(",");
        if (strArrSplit == null || strArrSplit.length != 4) {
            return i;
        }
        return (((int) ((Float.parseFloat(strArrSplit[3]) * 255.0f) + 0.5f)) << 24) | (((int) Float.parseFloat(strArrSplit[0])) << 16) | (((int) Float.parseFloat(strArrSplit[1])) << 8) | ((int) Float.parseFloat(strArrSplit[2])) | 0;
    }

    public static C0188n qg(String str) {
        int iIndexOf;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String strSubstring = str.substring(str.indexOf("(") + 1, str.lastIndexOf(")"));
            if (TextUtils.isEmpty(strSubstring)) {
                return null;
            }
            int iN = n(strSubstring, '%');
            int iIndexOf2 = strSubstring.indexOf(",");
            String strSubstring2 = strSubstring.substring(0, iIndexOf2);
            C0188n c0188n = new C0188n();
            c0188n.n = q(strSubstring2);
            String strSubstring3 = strSubstring.substring(iIndexOf2 + 1);
            int[] iArr = new int[iN];
            float[] fArr = new float[iN];
            for (int i = 0; i < iN; i++) {
                int iIndexOf3 = strSubstring3.indexOf("%");
                String strTrim = strSubstring3.substring(0, iIndexOf3 + 1).trim();
                if (strTrim.contains("rgba")) {
                    iIndexOf = strTrim.indexOf(")");
                } else {
                    iIndexOf = strTrim.indexOf(" ");
                }
                int i2 = iIndexOf + 1;
                iArr[i] = n(strTrim.substring(0, i2).trim());
                fArr[i] = s.n(strTrim.substring(i2, strTrim.indexOf("%")).trim(), 0.0f) / 100.0f;
                int i3 = iIndexOf3 + 2;
                if (strSubstring3.length() <= i3) {
                    break;
                }
                strSubstring3 = strSubstring3.substring(i3);
            }
            if (iN < 2) {
                return null;
            }
            c0188n.qg = iArr;
            c0188n.s = fArr;
            return c0188n;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int n(String str, char c) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) == c) {
                i++;
            }
        }
        return i;
    }

    public static boolean s(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("linear-gradient");
    }

    public static GradientDrawable.Orientation q(String str) {
        int i;
        try {
            if (str.contains("deg")) {
                i = Integer.parseInt(str.substring(0, str.length() - 3).trim());
            } else {
                i = Integer.parseInt(str);
            }
            if (i == 90) {
                return GradientDrawable.Orientation.LEFT_RIGHT;
            }
            if (i == 180) {
                return GradientDrawable.Orientation.TOP_BOTTOM;
            }
            if (i == 270) {
                return GradientDrawable.Orientation.RIGHT_LEFT;
            }
            if (i == 135) {
                return GradientDrawable.Orientation.TL_BR;
            }
            if (i == 45) {
                return GradientDrawable.Orientation.BL_TR;
            }
            return GradientDrawable.Orientation.BOTTOM_TOP;
        } catch (Exception unused) {
            return GradientDrawable.Orientation.LEFT_RIGHT;
        }
    }

    public static int n(int i, int i2) {
        if (i2 < 0 || i2 > 255) {
            k.qg("ColorUtils", "alpha must be between 0 and 255. ");
            i2 = 255;
        }
        return (i & ViewCompat.MEASURED_SIZE_MASK) | (i2 << 24);
    }
}
