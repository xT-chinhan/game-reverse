package com.byazt.zsl;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 469, 26})
public class qg implements com.byazt.ej.s {
    public int n;
    public int qg;
    public String s;

    public qg(int i, int i2) {
        this.n = i;
        this.qg = i2;
    }

    public qg(int i, int i2, String str) {
        this.n = i;
        this.qg = i2;
        this.s = str;
    }

    @Override // com.byazt.ej.s
    public int n() {
        return this.n;
    }

    @Override // com.byazt.ej.s
    public void n(int i) {
        this.n = i;
    }

    @Override // com.byazt.ej.s
    public int qg() {
        return this.qg;
    }

    @Override // com.byazt.ej.s
    public void qg(int i) {
        this.qg = i;
    }

    @Override // com.byazt.ej.s
    public String s() {
        return this.s;
    }

    @Override // com.byazt.ej.s
    public void n(String str) {
        this.s = str;
    }
}
