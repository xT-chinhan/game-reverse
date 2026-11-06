package com.byazt.equ;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 777, 13})
public final class w {
    public boolean l;
    public final byte[] n;
    public boolean q;
    public int qg;
    public int s;
    public w w;
    public w x;

    public w() {
        this.n = new byte[8192];
        this.l = true;
        this.q = false;
    }

    public w(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.n = bArr;
        this.qg = i;
        this.s = i2;
        this.q = z;
        this.l = z2;
    }

    public final w n() {
        this.q = true;
        return new w(this.n, this.qg, this.s, true, false);
    }

    public final w qg() {
        w wVar = this.w;
        w wVar2 = wVar != this ? wVar : null;
        w wVar3 = this.x;
        if (wVar3 != null) {
            wVar3.w = wVar;
        }
        w wVar4 = this.w;
        if (wVar4 != null) {
            wVar4.x = wVar3;
        }
        this.w = null;
        this.x = null;
        return wVar2;
    }

    public final w n(w wVar) {
        wVar.x = this;
        wVar.w = this.w;
        this.w.x = wVar;
        this.w = wVar;
        return wVar;
    }
}
