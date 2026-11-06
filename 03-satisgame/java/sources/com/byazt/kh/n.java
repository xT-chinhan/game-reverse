package com.byazt.kh;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 913, 19})
public class n extends s {
    public static volatile n n;

    public static n n(Context context) {
        if (n == null) {
            synchronized (n.class) {
                if (n == null) {
                    Context applicationContext = context != null ? context.getApplicationContext() : null;
                    if (applicationContext != null) {
                        context = applicationContext;
                    }
                    n = new n(context);
                }
            }
        }
        return n;
    }

    private n(Context context) {
        super(context);
    }
}
