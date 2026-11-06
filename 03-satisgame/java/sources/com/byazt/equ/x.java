package com.byazt.equ;

import com.anythink.china.a.c;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 777, 21})
public final class x {
    public static w n;
    public static long qg;

    private x() {
    }

    public static w n() {
        synchronized (x.class) {
            w wVar = n;
            if (wVar != null) {
                n = wVar.w;
                wVar.w = null;
                qg -= c.n;
                return wVar;
            }
            return new w();
        }
    }

    public static void n(w wVar) {
        if (wVar.w != null || wVar.x != null) {
            throw new IllegalArgumentException();
        }
        if (wVar.q) {
            return;
        }
        synchronized (x.class) {
            long j = qg;
            if (j + c.n > c.q) {
                return;
            }
            qg = j + c.n;
            wVar.w = n;
            wVar.s = 0;
            wVar.qg = 0;
            n = wVar;
        }
    }
}
