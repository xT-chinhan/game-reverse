package com.byazt.hls;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1598, 26})
public class qg {
    public static long n(int i, Context context, com.byazt.vr.qg qgVar) {
        return qg(i, context, qgVar);
    }

    private static long qg(int i, Context context, com.byazt.vr.qg qgVar) {
        if (context == null) {
            return i;
        }
        Runtime runtime = Runtime.getRuntime();
        long jFreeMemory = runtime.freeMemory() / 1048576;
        long jMaxMemory = (runtime.maxMemory() / 1048576) - (runtime.totalMemory() / 1048576);
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
}
