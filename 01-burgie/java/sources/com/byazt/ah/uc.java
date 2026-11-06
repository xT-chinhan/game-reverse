package com.byazt.ah;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1023, 5})
public class uc {
    public static volatile uc pr;
    public final hn hw;

    public static uc pr(Context context) {
        if (pr == null) {
            synchronized (uc.class) {
                if (pr == null) {
                    pr = new uc(context);
                }
            }
        }
        return pr;
    }

    private uc(Context context) {
        this.hw = new hn(context);
    }

    public void pr() {
        this.hw.pr();
    }
}
