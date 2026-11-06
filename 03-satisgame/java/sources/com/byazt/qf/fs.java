package com.byazt.qf;

import android.content.Context;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 817, 101})
public final class fs {
    public static volatile String cp = null;
    public static volatile ConcurrentHashMap<Integer, String> fs = null;
    public static com.byazt.qi.n l = null;
    public static Context n = null;
    public static boolean q = false;
    public static long qg = 0;
    public static String s = "default";
    public static volatile int tj;
    public static com.byazt.qi.qg w = new com.byazt.qi.qg();
    public static qg x = new qg();
    public static com.byazt.qi.fs rv = null;

    public static com.byazt.qi.n n() {
        return l;
    }

    public static qg qg() {
        return x;
    }

    public static com.byazt.qi.fs s() {
        if (rv == null) {
            synchronized (fs.class) {
                rv = new com.byazt.qi.fs(n);
            }
        }
        return rv;
    }

    public static void n(Context context, l lVar) {
        qg = System.currentTimeMillis();
        n = context;
        l = new com.byazt.qi.n(n, lVar);
    }

    public static Context q() {
        return n;
    }

    public static com.byazt.qi.qg l() {
        return w;
    }

    public static long w() {
        return qg;
    }

    public static String x() {
        return s;
    }

    public static boolean fs() {
        return q;
    }

    public static ConcurrentHashMap<Integer, String> rv() {
        return fs;
    }

    public static int tj() {
        return tj;
    }

    public static String cp() {
        return cp;
    }
}
