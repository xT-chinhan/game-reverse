package com.tapsdk.tapad.internal.l.c.a;

/* JADX INFO: loaded from: classes3.dex */
public class f extends RuntimeException {
    private int a;
    private String b;

    public f(int i) {
        this.a = i;
    }

    public f(int i, String str) {
        this.a = i;
        this.b = str;
    }

    public int a() {
        return this.a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.b;
    }
}
