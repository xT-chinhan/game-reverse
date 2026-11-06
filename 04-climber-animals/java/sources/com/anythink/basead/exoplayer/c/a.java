package com.anythink.basead.exoplayer.c;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    private int a;

    public void a() {
        this.a = 0;
    }

    public final boolean b() {
        return c(Integer.MIN_VALUE);
    }

    public final boolean c() {
        return c(4);
    }

    public final boolean d() {
        return c(1);
    }

    public final void a(int i) {
        this.a = i;
    }

    public final void b(int i) {
        this.a = i | this.a;
    }

    private void d(int i) {
        this.a = (~i) & this.a;
    }

    protected final boolean c(int i) {
        return (this.a & i) == i;
    }
}
