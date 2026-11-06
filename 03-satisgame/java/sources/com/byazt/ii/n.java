package com.byazt.ii;

import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.byazt.lh.x;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, AVMDLDataLoader.KeyIsNextDownloadThreshold, 19})
public class n {
    public static int n(x xVar) {
        if (xVar == null) {
            return 0;
        }
        String strF = xVar.f();
        String strM = xVar.m();
        if (TextUtils.isEmpty(strM) || TextUtils.isEmpty(strF) || !strM.equals("creative")) {
            return 0;
        }
        if (strF.equals("shake")) {
            return 2;
        }
        if (strF.equals("twist")) {
            return 3;
        }
        return strF.equals("slide") ? 1 : 0;
    }

    public static boolean n(View view) {
        if (view == null) {
            return false;
        }
        try {
            Object tag = view.getTag(2097610708);
            return tag != null && ((Integer) tag).intValue() == 1;
        } catch (Exception unused) {
        }
    }

    public static boolean qg(View view) {
        if (view == null) {
            return false;
        }
        try {
            Pair pair = (Pair) view.getTag(2097610707);
            if (pair == null) {
                return false;
            }
            return (TextUtils.isEmpty((CharSequence) pair.first) || TextUtils.equals("0", (CharSequence) pair.first)) && ((((Long) pair.second).longValue() > 0L ? 1 : (((Long) pair.second).longValue() == 0L ? 0 : -1)) <= 0);
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }

    public static boolean n(View view, float f, float f2, float f3, float f4) {
        if (view == null) {
            return false;
        }
        try {
            Pair pair = (Pair) view.getTag(2097610707);
            if (pair != null && !TextUtils.isEmpty((CharSequence) pair.first) && ((Long) pair.second).longValue() > 0) {
                String str = (String) pair.first;
                long jLongValue = ((Long) pair.second).longValue();
                if (str.equals("0")) {
                    return ((float) Math.sqrt(Math.pow((double) (f - f3), 2.0d) + Math.pow((double) (f2 - f4), 2.0d))) >= ((float) jLongValue);
                }
                if (str.equals("1")) {
                    float f5 = f2 - f4;
                    return f5 < 0.0f && Math.abs(f5) >= ((float) jLongValue);
                }
                if (str.equals("2")) {
                    float f6 = f - f3;
                    return f6 > 0.0f && Math.abs(f6) >= ((float) jLongValue);
                }
                if (str.equals("3")) {
                    float f7 = f - f3;
                    return f7 < 0.0f && Math.abs(f7) >= ((float) jLongValue);
                }
                if (str.equals("4")) {
                    float f8 = f2 - f4;
                    if (f8 > 0.0f && Math.abs(f8) >= jLongValue) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
