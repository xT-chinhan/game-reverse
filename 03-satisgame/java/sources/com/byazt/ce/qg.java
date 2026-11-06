package com.byazt.ce;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.byazt.nf.rv;
import com.byazt.vf.oa;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1259, 26})
public final class qg {
    private static float n() {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        if (displayMetrics == null || displayMetrics.density <= 0.0f) {
            return 1.0f;
        }
        return displayMetrics.density;
    }

    private static int[] n(Context context) {
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

    public static float[] n(Context context, float f, int i) {
        float fQ;
        float fQ2;
        float fN;
        float fMin;
        float fMax;
        int iQ;
        float[] fArr = new float[2];
        boolean zGy = rv.qg().gy();
        if (zGy) {
            fN = n();
            int[] iArrN = n(context);
            fQ = iArrN[1] / fN;
            fQ2 = iArrN[0] / fN;
        } else {
            fQ = com.byazt.okk.s.q(context, com.byazt.okk.s.rv(context));
            fQ2 = com.byazt.okk.s.q(context, com.byazt.okk.s.tj(context));
            fN = 1.0f;
        }
        if (i == 2) {
            fMin = Math.max(fQ, fQ2);
            fMax = Math.min(fQ, fQ2);
        } else {
            fMin = Math.min(fQ, fQ2);
            fMax = Math.max(fQ, fQ2);
        }
        if (zGy) {
            iQ = (int) ((com.byazt.okk.s.cp(context) / fN) + 0.5f);
        } else {
            iQ = com.byazt.okk.s.q(context, com.byazt.okk.s.cp(context));
        }
        if (com.byazt.okk.s.qg() || f != 100.0f) {
            if (i != 2) {
                fMax -= iQ;
            } else {
                if ("SM-A207F".equals(((oa) com.byazt.qp.q.n("device_info_new")).qg())) {
                    iQ *= 2;
                }
                fMin -= iQ;
            }
        }
        fArr[0] = fMin;
        fArr[1] = fMax;
        return fArr;
    }

    public static int[] n(Context context, float f, float f2, int i) {
        int iMax;
        float[] fArrN = n(context, f, i);
        float f3 = fArrN[0];
        float f4 = fArrN[1];
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
