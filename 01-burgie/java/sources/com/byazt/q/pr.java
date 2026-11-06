package com.byazt.q;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2301, 37})
public class pr {
    public static volatile pr pr;
    public int hw;

    private pr() {
    }

    public static pr pr() {
        if (pr == null) {
            synchronized (pr.class) {
                if (pr == null) {
                    pr = new pr();
                }
            }
        }
        return pr;
    }

    public int hw() {
        return this.hw;
    }
}
