package com.byazt.iaw;

import com.byazt.jv.y;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 507, 121})
public final class x {
    public final Set<y> pr = new LinkedHashSet();

    public synchronized void pr(y yVar) {
        this.pr.add(yVar);
    }

    public synchronized void hw(y yVar) {
        this.pr.remove(yVar);
    }

    public synchronized boolean hn(y yVar) {
        return this.pr.contains(yVar);
    }
}
