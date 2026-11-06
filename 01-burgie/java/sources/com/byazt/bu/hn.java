package com.byazt.bu;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 873, 20})
public class hn extends hw {
    public static volatile hn pr;

    public static hn pr(Context context) {
        if (pr == null) {
            synchronized (hn.class) {
                if (pr == null) {
                    pr = new hn(context);
                }
            }
        }
        return pr;
    }

    private hn(Context context) {
        super(context, "ttopensdk.db");
    }
}
