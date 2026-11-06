package com.anythink.core.common.n.c;

/* JADX INFO: loaded from: classes.dex */
public abstract class i implements w {
    private final w a;

    public i(w wVar) {
        if (wVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.a = wVar;
    }

    public final w b() {
        return this.a;
    }

    @Override // com.anythink.core.common.n.c.w
    public long a_(c cVar, long j) {
        return this.a.a_(cVar, j);
    }

    @Override // com.anythink.core.common.n.c.w
    public final x a() {
        return this.a.a();
    }

    @Override // com.anythink.core.common.n.c.w, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.a.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.a.toString() + ")";
    }
}
