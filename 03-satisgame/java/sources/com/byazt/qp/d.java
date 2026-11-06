package com.byazt.qp;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 525, 113})
public class d {
    public volatile int cp;
    public volatile Function d;
    public final int[] fs;
    public volatile int k;
    public final boolean l;
    public final Class<Object> n;
    public volatile Map<com.byazt.vf.n, Object> oa;
    public final int q;
    public final Class<Object> qg;
    public final boolean rv;
    public final int s;
    public volatile Object sz;
    public final int tj;
    public final String w;
    public final boolean x;

    public d(Class cls, Class cls2, boolean z, int i, int i2, String str, boolean z2, int[] iArr, boolean z3, int i3) {
        this.tj = i3;
        this.n = cls;
        this.qg = cls2;
        this.s = i;
        this.l = z;
        this.q = i2;
        this.w = str;
        this.x = z2;
        if (i < 0) {
            this.k = i;
        }
        if (z2) {
            this.oa = new ConcurrentHashMap();
        }
        this.fs = iArr;
        this.rv = z3;
    }

    public int n() {
        return this.cp;
    }

    public void n(int i) {
        this.cp = i;
    }

    public Function qg() {
        return this.d;
    }

    public void n(Function function) {
        this.d = function;
    }

    public synchronized Object n(com.byazt.vf.n nVar) {
        if (this.x && nVar != null && this.oa != null) {
            return this.oa.get(nVar);
        }
        return this.sz;
    }

    public Map<com.byazt.vf.n, Object> s() {
        return this.oa;
    }

    public Object q() {
        return this.sz;
    }

    public synchronized void n(Object obj, com.byazt.vf.n nVar) {
        if (this.x && nVar != null && this.oa != null) {
            this.oa.put(nVar, obj);
            return;
        }
        this.sz = obj;
    }

    public int l() {
        return this.k;
    }

    public void qg(int i) {
        this.k = i;
    }

    public boolean s(int i) {
        int i2 = this.q;
        return i2 <= 0 || i >= i2;
    }

    public boolean q(int i) {
        return i >= this.s && i >= this.k;
    }

    public boolean w() {
        return this.k > this.cp && this.k > this.s;
    }

    public String toString() {
        return "ServiceModel{version=" + this.s + ", minVersion=" + this.q + ", exposed=" + this.l + ", key='" + this.w + "'}";
    }
}
