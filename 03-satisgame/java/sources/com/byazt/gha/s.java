package com.byazt.gha;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 960, 8})
public class s extends qg {
    public static volatile s n;

    public static s n(Context context) {
        if (n == null) {
            synchronized (s.class) {
                if (n == null) {
                    n = new s(context);
                }
            }
        }
        return n;
    }

    private s(Context context) {
        super(context, "ttopensdk.db");
    }
}
