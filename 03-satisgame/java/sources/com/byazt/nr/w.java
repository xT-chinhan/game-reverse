package com.byazt.nr;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1357, 13})
public class w {
    public static volatile w n;
    public final s qg;

    public static w n(Context context) {
        if (n == null) {
            synchronized (w.class) {
                if (n == null) {
                    n = new w(context);
                }
            }
        }
        return n;
    }

    private w(Context context) {
        this.qg = new s(context);
    }

    public void n() {
        this.qg.n();
    }
}
