package com.byazt.ddg;

import com.byazt.hcw.w;
import com.byazt.rft.s;
import com.byazt.tbt.d;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 2206, 19})
public class n {
    public static volatile n n;
    public static AtomicBoolean qg = new AtomicBoolean(true);

    private n() {
    }

    public static n n() {
        if (n == null) {
            synchronized (n.class) {
                if (n == null) {
                    n = new n();
                }
            }
        }
        return n;
    }

    public void n(boolean z) {
        qg.set(z);
    }

    public boolean qg() {
        AtomicBoolean atomicBoolean = qg;
        if (atomicBoolean == null) {
            return true;
        }
        return atomicBoolean.get();
    }

    public static d n(d.n nVar) {
        return new s(nVar);
    }

    public static d qg(d.n nVar) {
        return new w(nVar);
    }
}
