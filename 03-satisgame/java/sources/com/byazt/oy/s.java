package com.byazt.oy;

import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2147, 8})
public abstract class s implements qg, Comparable<s>, Runnable {
    public qg.n n = qg.n.NORMAL;
    public String qg = UUID.randomUUID().toString() + "-" + String.valueOf(System.nanoTime());

    public qg.n n() {
        return this.n;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public int compareTo(s sVar) {
        if (n().n() < sVar.n().n()) {
            return 1;
        }
        return n().n() > sVar.n().n() ? -1 : 0;
    }
}
