package com.bytedance.sdk.component.x.xr.xr;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.x.ms.c;
import com.bytedance.sdk.component.x.ms.ka;
import com.ss.android.download.api.constant.BaseConstants;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    public static long ms(int i, Context context, ka kaVar) {
        return xr(i, context, kaVar);
    }

    private static long xr(int i, Context context, ka kaVar) {
        if (context == null) {
            return i;
        }
        Runtime runtime = Runtime.getRuntime();
        long jFreeMemory = runtime.freeMemory() / BaseConstants.MB_VALUE;
        long jMaxMemory = (runtime.maxMemory() / BaseConstants.MB_VALUE) - (runtime.totalMemory() / BaseConstants.MB_VALUE);
        if (jMaxMemory <= 0) {
            if (jFreeMemory <= 2) {
                return 1L;
            }
            if (jFreeMemory <= 10) {
                return Math.min(i, 10);
            }
            return Math.min((jFreeMemory / 2) * 10, i);
        }
        long j = ((jFreeMemory + jMaxMemory) - 10) / 2;
        if (j <= 2) {
            return 1L;
        }
        if (j <= 10) {
            return Math.min(i, 10);
        }
        return Math.min(j * 10, i);
    }

    public static boolean ms(ka kaVar) {
        c cVarXr = kaVar.xr();
        return (cVarXr == null || TextUtils.isEmpty(cVarXr.ms())) ? false : true;
    }

    public static boolean xr(ka kaVar) {
        c cVarXr = kaVar.xr();
        return (cVarXr == null || TextUtils.isEmpty(cVarXr.xr())) ? false : true;
    }

    public static boolean ah(ka kaVar) {
        c cVarXr = kaVar.xr();
        return (cVarXr == null || TextUtils.isEmpty(cVarXr.d())) ? false : true;
    }

    public static boolean d(ka kaVar) {
        c cVarXr = kaVar.xr();
        return (cVarXr == null || TextUtils.isEmpty(cVarXr.ka())) ? false : true;
    }

    public static boolean ka(ka kaVar) {
        c cVarXr = kaVar.xr();
        return (cVarXr == null || TextUtils.isEmpty(cVarXr.ah())) ? false : true;
    }

    public static boolean c(ka kaVar) {
        c cVarXr = kaVar.xr();
        return (cVarXr == null || TextUtils.isEmpty(cVarXr.c())) ? false : true;
    }
}
