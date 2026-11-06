package com.byazt.xev;

import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 75, 48})
public final class lb {
    public static yb pr(Context context) {
        if (com.byazt.kx.pr.lb()) {
            return new ny(new b());
        }
        if (com.byazt.kx.pr.qa() && b.pr()) {
            return new b();
        }
        if (cz.pr()) {
            return new cz(context);
        }
        if (com.byazt.kx.pr.k() && com.byazt.kx.pr.m()) {
            return new aj();
        }
        if (com.byazt.kx.pr.k() && !com.byazt.kx.pr.m()) {
            return new k();
        }
        if (com.byazt.kx.pr.pr(context) || com.byazt.kx.pr.k()) {
            return new aj();
        }
        if (com.byazt.kx.pr.ny()) {
            return new ny();
        }
        if (com.byazt.kx.pr.cz()) {
            return new g();
        }
        if (Build.VERSION.SDK_INT > 28) {
            if (com.byazt.kx.pr.fo()) {
                return new rc();
            }
            if (com.byazt.kx.pr.z()) {
                return new ho();
            }
            if (com.byazt.kx.pr.rc()) {
                return new m();
            }
            if (com.byazt.kx.pr.b()) {
                return new pr();
            }
            uc ucVar = new uc(context);
            if (ucVar.hw(context)) {
                return ucVar;
            }
            return new c();
        }
        if (!com.byazt.kx.pr.g() && aj.pr(context)) {
            return new aj();
        }
        return null;
    }
}
