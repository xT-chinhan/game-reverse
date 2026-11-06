package com.byazt.mf;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1054, 19})
public class n implements com.byazt.qk.s {
    public final String l;
    public final boolean n;
    public final byte[] q;
    public final int qg;
    public final String s;
    public final Throwable w;

    public n(boolean z, int i, String str, byte[] bArr, String str2, Throwable th) {
        this.n = z;
        this.qg = i;
        this.s = str;
        this.q = bArr;
        this.l = str2;
        this.w = th;
    }

    @Override // com.byazt.qk.s
    public boolean n() {
        return this.n;
    }

    @Override // com.byazt.qk.s
    public int qg() {
        return this.qg;
    }

    @Override // com.byazt.qk.s
    public String s() {
        return this.s;
    }

    @Override // com.byazt.qk.s
    public boolean q() {
        int i;
        return this.n && (i = this.qg) >= 200 && i < 300;
    }

    @Override // com.byazt.qk.s
    public byte[] l() {
        return this.q;
    }

    @Override // com.byazt.qk.s
    public String w() {
        return this.l;
    }

    @Override // com.byazt.qk.s
    public Throwable x() {
        return this.w;
    }
}
