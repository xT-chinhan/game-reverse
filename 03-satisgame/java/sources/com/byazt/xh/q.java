package com.byazt.xh;

import android.content.Context;
import com.byazt.qf.fs;
import com.byazt.qi.x;
import com.byazt.yw.rv;
import com.byazt.yw.tj;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 768, 5})
public final class q implements Runnable {
    public Context n;

    private q(Context context) {
        this.n = context;
    }

    public static void n(Context context, int i) {
        try {
            if (!fs.n().q().equals(context.getPackageName())) {
                return;
            }
        } catch (Exception unused) {
        }
        x.qg().postDelayed(new q(context), i);
    }

    public static void n(Context context) {
        n(context, 0);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            new com.byazt.qi.s(this.n).n(rv.qg(this.n));
        } catch (Throwable th) {
            try {
                tj.qg(th);
            } finally {
                com.byazt.yd.s.n(x.qg(), this.n).n();
            }
        }
    }
}
