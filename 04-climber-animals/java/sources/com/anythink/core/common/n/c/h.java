package com.anythink.core.common.n.c;

/* JADX INFO: loaded from: classes.dex */
public abstract class h implements v {
    private final v a;

    public h(v vVar) {
        if (vVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.a = vVar;
    }

    private v b() {
        return this.a;
    }

    @Override // com.anythink.core.common.n.c.v
    public void a(c cVar, long j) {
        this.a.a(cVar, j);
    }

    @Override // com.anythink.core.common.n.c.v, java.io.Flushable
    public void flush() {
        this.a.flush();
    }

    @Override // com.anythink.core.common.n.c.v
    public final x a() {
        return this.a.a();
    }

    @Override // com.anythink.core.common.n.c.v, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.a.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.a.toString() + ")";
    }
}
