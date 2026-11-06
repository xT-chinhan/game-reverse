package com.byazt.qr;

import com.byazt.dqk.uc;
import com.byazt.nzn.k;
import com.byazt.wye.hn;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2266, 37})
public class pr {
    public static AtomicBoolean hw = new AtomicBoolean(true);
    public static volatile pr pr;

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

    public void pr(boolean z) {
        hw.set(z);
    }

    public boolean hw() {
        AtomicBoolean atomicBoolean = hw;
        if (atomicBoolean == null) {
            return true;
        }
        return atomicBoolean.get();
    }

    public static k pr(k.pr prVar) {
        return new hn(prVar);
    }

    public static k hw(k.pr prVar) {
        return new uc(prVar);
    }
}
