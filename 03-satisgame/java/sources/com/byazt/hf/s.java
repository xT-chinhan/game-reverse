package com.byazt.hf;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 938, 8})
public final class s {
    public final com.byazt.wa.w fs;
    public final int rv;
    public final com.byazt.wa.w x;
    public static final com.byazt.wa.w n = com.byazt.wa.w.n(":");
    public static final com.byazt.wa.w qg = com.byazt.wa.w.n(":status");
    public static final com.byazt.wa.w s = com.byazt.wa.w.n(":method");
    public static final com.byazt.wa.w q = com.byazt.wa.w.n(":path");
    public static final com.byazt.wa.w l = com.byazt.wa.w.n(":scheme");
    public static final com.byazt.wa.w w = com.byazt.wa.w.n(":authority");

    public s(String str, String str2) {
        this(com.byazt.wa.w.n(str), com.byazt.wa.w.n(str2));
    }

    public s(com.byazt.wa.w wVar, String str) {
        this(wVar, com.byazt.wa.w.n(str));
    }

    public s(com.byazt.wa.w wVar, com.byazt.wa.w wVar2) {
        this.x = wVar;
        this.fs = wVar2;
        this.rv = wVar.x() + 32 + wVar2.x();
    }

    public boolean equals(Object obj) {
        if (obj instanceof s) {
            s sVar = (s) obj;
            if (this.x.equals(sVar.x) && this.fs.equals(sVar.fs)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.x.hashCode() + 527) * 31) + this.fs.hashCode();
    }

    public String toString() {
        return com.byazt.zho.s.n("%s: %s", this.x.n(), this.fs.n());
    }
}
