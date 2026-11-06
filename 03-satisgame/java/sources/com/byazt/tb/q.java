package com.byazt.tb;

import com.byazt.si.fs;
import com.byazt.si.x;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 573, 5})
public class q<T> implements x {
    public fs l;
    public Map<String, String> n;
    public String q;
    public int qg;
    public T s;

    public q(int i, T t, String str) {
        this.qg = i;
        this.s = t;
        this.q = str;
    }

    public q(int i, T t, String str, Map<String, String> map) {
        this(i, t, str);
        this.n = map;
    }

    @Override // com.byazt.si.x
    public fs n() {
        return this.l;
    }

    public void n(fs fsVar) {
        this.l = fsVar;
    }

    @Override // com.byazt.si.x
    public int qg() {
        return this.qg;
    }

    @Override // com.byazt.si.x
    public T s() {
        return this.s;
    }

    @Override // com.byazt.si.x
    public String q() {
        return this.q;
    }

    @Override // com.byazt.si.x
    public Map<String, String> l() {
        return this.n;
    }
}
