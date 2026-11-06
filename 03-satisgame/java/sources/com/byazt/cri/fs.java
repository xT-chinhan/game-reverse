package com.byazt.cri;

import com.byazt.pq.ln;
import com.byazt.pq.py;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1393, 101})
public final class fs extends ln {
    public final String n;
    public final long qg;
    public final com.byazt.wa.l s;

    public fs(String str, long j, com.byazt.wa.l lVar) {
        this.n = str;
        this.qg = j;
        this.s = lVar;
    }

    @Override // com.byazt.pq.ln
    public py n() {
        String str = this.n;
        if (str != null) {
            return py.n(str);
        }
        return null;
    }

    @Override // com.byazt.pq.ln
    public long qg() {
        return this.qg;
    }

    @Override // com.byazt.pq.ln
    public com.byazt.wa.l s() {
        return this.s;
    }
}
