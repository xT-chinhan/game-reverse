package com.bytedance.sdk.openadsdk.core.component.reward.ka;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.t;

/* JADX INFO: loaded from: classes2.dex */
public final class xr {
    public static float[] ms(Context context, float f, int i) {
        float fMin;
        float fMax;
        float[] fArr = new float[2];
        float fD = ul.d(context, ul.ny(context));
        float fD2 = ul.d(context, ul.ch(context));
        if (i == 2) {
            fMin = Math.max(fD, fD2);
            fMax = Math.min(fD, fD2);
        } else {
            fMin = Math.min(fD, fD2);
            fMax = Math.max(fD, fD2);
        }
        int iD = ul.d(context, ul.hi(context));
        if (ul.xr() || f != 100.0f) {
            if (i != 2) {
                fMax -= iD;
            } else {
                if ("SM-A207F".equals(t.re())) {
                    iD *= 2;
                }
                fMin -= iD;
            }
        }
        fArr[0] = fMin;
        fArr[1] = fMax;
        return fArr;
    }

    public static int[] ms(Context context, float f, float f2, int i) {
        int iMax;
        float[] fArrMs = ms(context, f, i);
        float f3 = fArrMs[0];
        float f4 = fArrMs[1];
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
