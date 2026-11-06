package com.byazt.gxb;

import com.byazt.si.cy;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 790, 5})
public class q<T> implements cy {
    public int cp;
    public boolean fs;
    public int l;
    public String n;
    public T q;
    public String qg;
    public boolean rv;
    public T s;
    public com.byazt.si.fs tj;
    public int w;
    public Map<String, String> x;

    public q n(s sVar, T t) {
        this.s = t;
        this.n = sVar.x();
        this.qg = sVar.qg();
        this.l = sVar.s();
        this.w = sVar.q();
        this.rv = sVar.cy();
        this.tj = sVar.cd();
        this.cp = sVar.um();
        return this;
    }

    public q n(s sVar, T t, Map<String, String> map, boolean z) {
        this.x = map;
        this.fs = z;
        return n(sVar, t);
    }

    @Override // com.byazt.si.cy
    public String n() {
        return this.n;
    }

    @Override // com.byazt.si.cy
    public String qg() {
        return this.qg;
    }

    @Override // com.byazt.si.cy
    public T s() {
        return this.s;
    }

    @Override // com.byazt.si.cy
    public T q() {
        return this.q;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.byazt.si.cy
    public void setResult(Object obj) {
        this.q = this.s;
        this.s = obj;
    }

    @Override // com.byazt.si.cy
    public int l() {
        return this.l;
    }

    @Override // com.byazt.si.cy
    public int w() {
        return this.w;
    }

    @Override // com.byazt.si.cy
    public Map<String, String> x() {
        return this.x;
    }

    @Override // com.byazt.si.cy
    public boolean fs() {
        return this.fs;
    }

    @Override // com.byazt.si.cy
    public boolean rv() {
        return this.rv;
    }

    @Override // com.byazt.si.cy
    public com.byazt.si.fs tj() {
        return this.tj;
    }

    @Override // com.byazt.si.cy
    public int cp() {
        return this.cp;
    }
}
