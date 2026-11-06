package com.anythink.core.common.v.b;

/* JADX INFO: loaded from: classes.dex */
public abstract class d implements Runnable {
    public static final int d = 1;
    public static final int e = 2;
    public static final int f = 3;
    protected e h;
    protected boolean g = true;
    protected int i = 1;
    private long a = 0;
    private String b = "anythink_default_thread";

    public abstract void a();

    public final void a(long j) {
        this.a = j;
    }

    public final long b() {
        return this.a;
    }

    private void a(e eVar) {
        this.h = eVar;
    }

    public final void a(String str) {
        this.b = str;
    }

    private String c() {
        return this.b;
    }

    @Override // java.lang.Runnable
    public void run() {
        Thread.currentThread().setName(this.b);
        a();
    }
}
