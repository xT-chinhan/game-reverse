package com.byazt.sym;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 78, 26})
public final class qg {
    public final long l;
    public final String n;
    public final String q;
    public final String qg;
    public final int s;
    public final boolean w;

    public qg(String str, String str2, int i, String str3, long j, boolean z) {
        this.n = str;
        this.qg = str2;
        this.s = i;
        this.q = str3;
        this.l = j;
        this.w = z;
    }

    public static qg n(String str, String str2, int i, String str3, long j, Throwable th) {
        return new qg(str, str2, i, str3, j, th == null);
    }
}
