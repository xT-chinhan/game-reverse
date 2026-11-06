package com.byazt.sqs;

import com.byazt.pq.lh;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 707, 5})
public final class q {
    public final Set<lh> n = new LinkedHashSet();

    public synchronized void n(lh lhVar) {
        this.n.add(lhVar);
    }

    public synchronized void qg(lh lhVar) {
        this.n.remove(lhVar);
    }

    public synchronized boolean s(lh lhVar) {
        return this.n.contains(lhVar);
    }
}
