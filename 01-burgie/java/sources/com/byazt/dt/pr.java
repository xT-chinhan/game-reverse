package com.byazt.dt;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1167, 37})
public class pr extends hw {
    public static volatile pr pr;

    private pr() {
    }

    public static hw pr() {
        if (pr == null) {
            synchronized (hw.class) {
                if (pr == null) {
                    pr = new pr();
                }
            }
        }
        return pr;
    }

    @Override // com.byazt.dt.hw
    public synchronized int hw() {
        int iHn = com.byazt.mp.c.pr().hn();
        float fX = com.byazt.mp.c.pr().x();
        if (fX <= 0.0f) {
            return iHn;
        }
        return (int) Math.ceil(fX * iHn);
    }

    @Override // com.byazt.dt.hw
    public synchronized long hn() {
        return com.byazt.mp.c.pr().hw();
    }
}
