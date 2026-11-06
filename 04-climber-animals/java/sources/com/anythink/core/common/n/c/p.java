package com.anythink.core.common.n.c;

/* JADX INFO: loaded from: classes.dex */
final class p implements w {
    private final e a;
    private final c b;
    private s c;
    private int d;
    private boolean e;
    private long f;

    p(e eVar) {
        this.a = eVar;
        c cVarC = eVar.c();
        this.b = cVarC;
        s sVar = cVarC.b;
        this.c = sVar;
        this.d = sVar != null ? sVar.d : -1;
    }

    @Override // com.anythink.core.common.n.c.w
    public final long a_(c cVar, long j) {
        if (this.e) {
            throw new IllegalStateException("closed");
        }
        s sVar = this.c;
        if (sVar != null && (sVar != this.b.b || this.d != this.b.b.d)) {
            throw new IllegalStateException("Peek source is invalid because upstream source was used");
        }
        this.a.b(this.f + j);
        if (this.c == null && this.b.b != null) {
            this.c = this.b.b;
            this.d = this.b.b.d;
        }
        long jMin = Math.min(j, this.b.c - this.f);
        if (jMin <= 0) {
            return -1L;
        }
        this.b.a(cVar, this.f, jMin);
        this.f += jMin;
        return jMin;
    }

    @Override // com.anythink.core.common.n.c.w
    public final x a() {
        return this.a.a();
    }

    @Override // com.anythink.core.common.n.c.w, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.e = true;
    }
}
