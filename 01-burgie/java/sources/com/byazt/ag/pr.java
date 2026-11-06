package com.byazt.ag;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2053, 37})
public final class pr {
    public static volatile pr hw;
    public volatile hw pr;

    private pr() {
    }

    public static pr pr() {
        if (hw == null) {
            synchronized (pr.class) {
                if (hw == null) {
                    hw = new pr();
                }
            }
        }
        return hw;
    }

    public hw hw() {
        return this.pr;
    }
}
