package com.tapsdk.tapad.e.o.a;

/* JADX INFO: loaded from: classes3.dex */
public class g extends RuntimeException {
    private int a;

    public g(int i) {
        this(i, "");
    }

    public g(int i, String str) {
        super(str);
        this.a = i;
    }

    public int a() {
        return this.a;
    }
}
