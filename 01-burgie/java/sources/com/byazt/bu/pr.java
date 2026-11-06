package com.byazt.bu;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 873, 37})
public class pr extends hw {
    public static volatile pr pr;

    public static pr pr(Context context) {
        if (pr == null) {
            synchronized (pr.class) {
                if (pr == null) {
                    pr = new pr(context);
                }
            }
        }
        return pr;
    }

    private pr(Context context) {
        super(context, "ttopensdk2.db");
    }
}
