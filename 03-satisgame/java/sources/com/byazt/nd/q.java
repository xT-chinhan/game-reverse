package com.byazt.nd;

import android.content.Context;
import com.byazt.tk.k;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 674, 5})
public final class q {
    public static volatile Context cp = null;
    public static volatile boolean fs = false;
    public static volatile com.byazt.lp.qg n = null;
    public static volatile Integer q = null;
    public static volatile com.byazt.lp.s qg = null;
    public static volatile int s = 3;
    public static volatile com.byazt.frl.s tj;
    public static volatile boolean w;
    public static final boolean l = k.s();
    public static volatile boolean x = true;
    public static volatile int rv = 0;

    public static Context getContext() {
        return cp;
    }

    public static void n(boolean z) {
        fs = z;
    }

    public static void n(int i) {
        rv = i;
    }

    public static void n(com.byazt.lp.s sVar, Context context) {
        if (sVar == null || context == null) {
            throw new IllegalArgumentException("DiskLruCache and Context can't be null !!!");
        }
        cp = context.getApplicationContext();
        if (qg != null) {
            return;
        }
        com.byazt.lp.qg qgVar = n;
        if (qgVar != null && qgVar.n.getAbsolutePath().equals(sVar.n.getAbsolutePath())) {
            throw new IllegalArgumentException("DiskLruCache and DiskCache can't use the same dir");
        }
        qg = sVar;
        tj = com.byazt.frl.s.n(context);
        qg.n(new com.byazt.lp.s.n() { // from class: com.byazt.nd.q.1
            @Override // com.byazt.lp.s.n
            public void n(String str) {
                boolean z = q.l;
            }

            @Override // com.byazt.lp.s.n
            public void n(Set<String> set) {
                q.tj.n(set, 0);
                boolean z = q.l;
            }
        });
        s sVarN = s.n();
        sVarN.n(sVar);
        sVarN.n(tj);
    }

    public static com.byazt.lp.s n() {
        return qg;
    }

    public static com.byazt.lp.qg qg() {
        return n;
    }
}
