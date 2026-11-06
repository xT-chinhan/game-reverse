package com.anythink.core.common.h;

/* JADX INFO: loaded from: classes.dex */
public final class be {
    private int a;
    private String b;
    private long c;
    private int d;
    private int e;

    public be() {
    }

    public be(int i, String str) {
        this.a = i;
        this.b = str;
        this.d = 0;
        this.e = 0;
        this.c = -1L;
    }

    public final String a() {
        return this.b;
    }

    private void a(String str) {
        this.b = str;
    }

    public final long b() {
        return this.c;
    }

    public final void a(long j) {
        this.c = j;
    }

    public final int c() {
        return this.d;
    }

    public final void a(int i) {
        this.d = i;
    }

    public final int d() {
        return this.e;
    }

    public final void b(int i) {
        this.e = i;
    }

    public final int e() {
        return this.a;
    }

    private void c(int i) {
        this.a = i;
    }
}
