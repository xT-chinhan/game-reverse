package com.byazt.tzz;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 444, 19})
public class n {
    public static volatile com.byazt.lcx.n n;

    public static com.byazt.lcx.n n(Context context, com.byazt.vr.qg qgVar) {
        if (n == null) {
            synchronized (com.byazt.lcx.n.class) {
                if (n == null) {
                    n = new qg(context, new q(context, qgVar), qgVar);
                }
            }
        }
        return n;
    }
}
