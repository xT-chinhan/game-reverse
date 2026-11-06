package com.anythink.core.common.m.c;

import java.util.zip.Deflater;

/* JADX INFO: loaded from: classes.dex */
public final class g implements v {
    private final d a;
    private final Deflater b;
    private boolean c;

    private g(v vVar, Deflater deflater) {
        this(n.a(vVar), deflater);
    }

    g(d dVar, Deflater deflater) {
        if (dVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (deflater == null) {
            throw new IllegalArgumentException("inflater == null");
        }
        this.a = dVar;
        this.b = deflater;
    }

    @Override // com.anythink.core.common.m.c.v
    public final void a(c cVar, long j) {
        y.a(cVar.c, 0L, j);
        while (j > 0) {
            s sVar = cVar.b;
            int iMin = (int) Math.min(j, sVar.e - sVar.d);
            this.b.setInput(sVar.c, sVar.d, iMin);
            a(false);
            long j2 = iMin;
            cVar.c -= j2;
            sVar.d += iMin;
            if (sVar.d == sVar.e) {
                cVar.b = sVar.c();
                t.a(sVar);
            }
            j -= j2;
        }
    }

    private void a(boolean z) {
        s sVarG;
        int iDeflate;
        c cVarC = this.a.c();
        while (true) {
            sVarG = cVarC.g(1);
            if (z) {
                iDeflate = this.b.deflate(sVarG.c, sVarG.e, 8192 - sVarG.e, 2);
            } else {
                iDeflate = this.b.deflate(sVarG.c, sVarG.e, 8192 - sVarG.e);
            }
            if (iDeflate > 0) {
                sVarG.e += iDeflate;
                cVarC.c += (long) iDeflate;
                this.a.A();
            } else if (this.b.needsInput()) {
                break;
            }
        }
        if (sVarG.d == sVarG.e) {
            cVarC.b = sVarG.c();
            t.a(sVarG);
        }
    }

    @Override // com.anythink.core.common.m.c.v, java.io.Flushable
    public final void flush() {
        a(true);
        this.a.flush();
    }

    final void b() {
        this.b.finish();
        a(false);
    }

    @Override // com.anythink.core.common.m.c.v, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        if (this.c) {
            return;
        }
        b();
        th = null;
        try {
            this.b.end();
        } catch (Throwable th) {
            if (th == null) {
                th = th;
            }
        }
        try {
            this.a.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.c = true;
        if (th != null) {
            y.a(th);
        }
    }

    @Override // com.anythink.core.common.m.c.v
    public final x a() {
        return this.a.a();
    }

    public final String toString() {
        return "DeflaterSink(" + this.a + ")";
    }
}
