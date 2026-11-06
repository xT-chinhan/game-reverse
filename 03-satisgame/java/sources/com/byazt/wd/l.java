package com.byazt.wd;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 584, 18})
public final class l {
    public boolean n;
    public boolean qg;
    public String s;

    private l(boolean z, boolean z2, String str) {
        this.n = z;
        this.qg = z2;
        this.s = str;
    }

    public static l n() {
        return new l(false, false, null);
    }

    public static l n(boolean z, String str) {
        return new l(true, z, str);
    }

    public boolean qg() {
        return this.n;
    }

    public boolean s() {
        return this.qg;
    }

    public String q() {
        return this.s;
    }
}
