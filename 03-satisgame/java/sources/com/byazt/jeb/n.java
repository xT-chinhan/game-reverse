package com.byazt.jeb;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1621, 19})
public class n implements com.byazt.zad.n {
    public final String fs;
    public final boolean l;
    public final boolean n;
    public final String q;
    public final int qg;
    public boolean rv;
    public final String s;
    public final Throwable w;
    public final String x;

    public n(boolean z, int i, String str, boolean z2, String str2) {
        this(z, i, str, z2, str2, null, "", "");
    }

    public n(boolean z, int i, String str, boolean z2, String str2, Throwable th) {
        this(z, i, str, z2, str2, th, "", "");
    }

    public n(boolean z, int i, String str, boolean z2, String str2, Throwable th, String str3, String str4) {
        this.n = z;
        this.qg = i;
        this.s = str;
        this.l = z2;
        this.q = str2;
        this.w = th;
        this.x = str3 == null ? "" : str3;
        this.fs = str4 == null ? "" : str4;
    }

    @Override // com.byazt.zad.n
    public boolean w() {
        return this.rv;
    }

    public void n(boolean z) {
        this.rv = z;
    }

    @Override // com.byazt.zad.n
    public boolean n() {
        return this.n;
    }

    @Override // com.byazt.zad.n
    public int qg() {
        return this.qg;
    }

    @Override // com.byazt.zad.n
    public String s() {
        return this.s;
    }

    @Override // com.byazt.zad.n
    public String q() {
        return this.q;
    }

    @Override // com.byazt.zad.n
    public boolean l() {
        return this.l;
    }
}
