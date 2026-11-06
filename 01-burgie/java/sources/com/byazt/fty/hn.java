package com.byazt.fty;

/* JADX INFO: loaded from: classes.dex */
public enum hn {
    INHERIT(0),
    LTR(1),
    RTL(2);

    public final int x;

    hn(int i) {
        this.x = i;
    }

    public int pr() {
        return this.x;
    }
}
