package com.byazt.co;

import com.byazt.sg.s;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1819, 26})
public class qg extends com.byazt.slh.n {
    public s n;

    public qg(s sVar) {
        this.n = sVar;
    }

    @Override // com.byazt.slh.n
    public String n() {
        s sVar = this.n;
        return sVar != null ? sVar.x() : "";
    }

    @Override // com.byazt.slh.n
    public void qg() {
        s sVar = this.n;
        if (sVar == null || sVar.fs() == null) {
            return;
        }
        this.n.fs().qg();
    }

    @Override // com.byazt.slh.n
    public void n(long j) {
        s sVar = this.n;
        if (sVar == null || sVar.fs() == null) {
            return;
        }
        this.n.fs().n(j);
    }

    @Override // com.byazt.slh.n
    public void qg(long j) {
        s sVar = this.n;
        if (sVar == null || sVar.fs() == null) {
            return;
        }
        this.n.fs().qg(j);
    }

    @Override // com.byazt.slh.n
    public void s() {
        s sVar = this.n;
        if (sVar == null || sVar.fs() == null) {
            return;
        }
        this.n.fs().n();
    }

    @Override // com.byazt.slh.n
    public void s(long j) {
        s sVar = this.n;
        if (sVar == null || sVar.fs() == null) {
            return;
        }
        this.n.fs().s(j);
    }

    @Override // com.byazt.slh.n
    public void q() {
        s sVar = this.n;
        if (sVar == null || sVar.fs() == null) {
            return;
        }
        this.n.fs().qg();
    }

    @Override // com.byazt.slh.n
    public void n(int i, int i2) {
        s sVar = this.n;
        if (sVar == null || sVar.fs() == null) {
            return;
        }
        this.n.fs().n(i, i2);
    }

    @Override // com.byazt.slh.n
    public void n(long j, int i, int i2) {
        s sVar = this.n;
        if (sVar == null || sVar.fs() == null) {
            return;
        }
        this.n.fs().n(j, i, i2);
    }
}
