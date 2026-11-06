package com.byazt.hf;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.byazt.sd.a;
import com.byazt.vkw.g;
import com.byazt.wt.er;
import com.byazt.zs.uc;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 219, 13})
public final class hw {
    private static float pr() {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        if (displayMetrics != null && displayMetrics.density > 0.0f) {
            return displayMetrics.density;
        }
        return 1.0f;
    }

    private static int[] pr(Context context) {
        DisplayMetrics displayMetrics;
        Display defaultDisplay;
        int[] iArr = new int[2];
        try {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager != null && (defaultDisplay = windowManager.getDefaultDisplay()) != null) {
                DisplayMetrics displayMetrics2 = new DisplayMetrics();
                defaultDisplay.getRealMetrics(displayMetrics2);
                iArr[0] = displayMetrics2.widthPixels;
                iArr[1] = displayMetrics2.heightPixels;
            }
        } catch (Throwable th) {
            th.getMessage();
        }
        if ((iArr[0] <= 0 || iArr[1] <= 0) && (displayMetrics = Resources.getSystem().getDisplayMetrics()) != null) {
            iArr[0] = displayMetrics.widthPixels;
            iArr[1] = displayMetrics.heightPixels;
        }
        return iArr;
    }

    public static float[] pr(Context context, float f, int i) {
        float fX;
        float fX2;
        float fPr;
        float fMin;
        float fMax;
        int iX;
        float[] fArr = new float[2];
        boolean zSw = a.hw().sw();
        if (zSw) {
            fPr = pr();
            int[] iArrPr = pr(context);
            fX = iArrPr[1] / fPr;
            fX2 = iArrPr[0] / fPr;
        } else {
            fX = er.x(context, er.aj(context));
            fX2 = er.x(context, er.vk(context));
            fPr = 1.0f;
        }
        if (i == 2) {
            fMin = Math.max(fX, fX2);
            fMax = Math.min(fX, fX2);
        } else {
            fMin = Math.min(fX, fX2);
            fMax = Math.max(fX, fX2);
        }
        if (zSw) {
            iX = (int) ((er.w(context) / fPr) + 0.5f);
        } else {
            iX = er.x(context, er.w(context));
        }
        if (er.hw() || f != 100.0f) {
            if (i != 2) {
                fMax -= iX;
            } else if ("SM-A207F".equals(((g) uc.pr("device_info_new")).hw())) {
                fMin -= iX * 2;
            } else {
                fMin -= iX;
            }
        }
        fArr[0] = fMin;
        fArr[1] = fMax;
        return fArr;
    }

    public static int[] pr(Context context, float f, float f2, int i) {
        int iMax;
        float[] fArrPr = pr(context, f, i);
        float f3 = fArrPr[0];
        float f4 = fArrPr[1];
        int[] iArr = new int[4];
        int iMin = (int) (Math.min(f3, f4) * f2);
        if (i != 2) {
            float f5 = iMin;
            iMax = (int) Math.max((f4 - (((f3 - f5) - f5) / f)) / 2.0f, 0.0f);
        } else {
            float f6 = iMin;
            iMin = (int) Math.max((f3 - (((f4 - f6) - f6) * f)) / 2.0f, 0.0f);
            iMax = iMin;
        }
        iArr[0] = iMin;
        iArr[1] = iMax;
        iArr[2] = iMin;
        iArr[3] = iMax;
        return iArr;
    }
}
