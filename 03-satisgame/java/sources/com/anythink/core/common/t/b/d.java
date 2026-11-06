package com.anythink.core.common.t.b;

/* JADX INFO: loaded from: classes.dex */
public final class d {
    private final f a;
    private volatile c b;
    private volatile b c;

    public d(f fVar) {
        this.a = fVar;
    }

    public final a a() {
        if (this.b == null) {
            synchronized (this) {
                if (this.b == null) {
                    this.b = new c();
                }
            }
        }
        return this.b;
    }

    public final a b() {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    this.c = new b(this.a);
                }
            }
        }
        return this.c;
    }
}
