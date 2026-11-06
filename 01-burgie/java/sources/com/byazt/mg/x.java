package com.byazt.mg;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 860, 121})
public class x extends Exception {
    public final int pr;

    public x(int i, String str) {
        super(str);
        this.pr = i;
    }

    public x(int i, String str, Throwable th) {
        super(str, th);
        this.pr = i;
    }

    public int pr() {
        return this.pr;
    }
}
