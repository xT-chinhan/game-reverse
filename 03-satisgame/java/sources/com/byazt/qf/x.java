package com.byazt.qf;

import android.app.Application;
import android.content.Context;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 817, 21})
public final class x {
    public static boolean n = false;
    public static boolean q = false;
    public static boolean qg = false;
    public static boolean s = false;

    public static synchronized void n(Context context, l lVar, boolean z, boolean z2) {
        n(context, lVar, z, false, z2);
    }

    public static synchronized void n(Context context, l lVar, boolean z, boolean z2, boolean z3) {
        n(context, lVar, z, z, z2, z3);
    }

    public static synchronized void n(final Context context, l lVar, boolean z, boolean z2, boolean z3, final boolean z4) {
        if (n) {
            return;
        }
        if (context == null) {
            throw new IllegalArgumentException("context must be not null.");
        }
        if (lVar == null) {
            throw new IllegalArgumentException("params must be not null.");
        }
        if (!(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        if (com.byazt.yw.n.s(context)) {
            return;
        }
        fs.n(context, lVar);
        com.byazt.pd.l.n(context);
        if (z || z2) {
            com.byazt.nv.n nVarN = com.byazt.nv.n.n();
            if (z) {
                nVarN.n(new com.byazt.nv.s(context));
            }
            qg = true;
        }
        q = z3;
        n = true;
        s = z4;
        com.byazt.qi.x.qg().post(new Runnable() { // from class: com.byazt.qf.x.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.hu.n.n().n(context);
                com.byazt.xh.q.n(context);
                if (z4) {
                    com.byazt.nr.w.n(context).n();
                }
            }
        });
    }

    @Deprecated
    public static void n(String str) {
        if (fs.l().n()) {
            com.byazt.nv.n.n(str);
        }
    }

    public static void n(w wVar) {
        fs.qg().n(wVar);
    }

    public static void n(Map<? extends String, ? extends String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        fs.qg().n(map);
    }

    public static void n(final com.byazt.ib.qg qgVar) {
        com.byazt.qi.x.qg().post(new Runnable() { // from class: com.byazt.qf.x.2
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.ib.n.n(qgVar);
            }
        });
    }

    public static void n() {
        com.byazt.nv.n.qg();
    }
}
