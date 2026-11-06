package com.byazt.nj;

import com.byazt.gct.pk;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1070, 5})
public final class q {
    public final long l;
    public final int n;
    public final int q;
    public final int qg;
    public final int s;

    public q(int i, int i2, int i3, int i4, long j) {
        this.n = i;
        this.qg = i2;
        this.s = i3;
        this.q = i4;
        this.l = j;
    }

    public int n() {
        return this.n;
    }

    public int qg() {
        return this.qg;
    }

    public int s() {
        return this.s;
    }

    public int q() {
        return this.q;
    }

    public long l() {
        return this.l;
    }

    public static void n(pk pkVar) {
        if (pkVar != null) {
            pkVar.dh();
        }
    }

    public static void n(List<pk> list) {
        if (list == null) {
            return;
        }
        Iterator<pk> it = list.iterator();
        while (it.hasNext()) {
            n(it.next());
        }
    }
}
