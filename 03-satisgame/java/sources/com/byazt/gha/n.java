package com.byazt.gha;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 960, 19})
public class n extends qg {
    public static volatile n n;

    public static n n(Context context) {
        if (n == null) {
            synchronized (n.class) {
                if (n == null) {
                    n = new n(context);
                }
            }
        }
        return n;
    }

    private n(Context context) {
        super(context, "ttopensdk2.db");
    }
}
