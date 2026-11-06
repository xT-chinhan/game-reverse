package com.anythink.core.common.m.c;

import java.util.zip.CRC32;
import java.util.zip.Deflater;

/* JADX INFO: loaded from: classes.dex */
public final class k implements v {
    private final d a;
    private final Deflater b;
    private final g c;
    private boolean d;
    private final CRC32 e = new CRC32();

    private k(v vVar) {
        if (vVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        Deflater deflater = new Deflater(-1, true);
        this.b = deflater;
        d dVarA = n.a(vVar);
        this.a = dVarA;
        this.c = new g(dVarA, deflater);
        c cVarC = dVarA.c();
        cVarC.k(8075);
        cVarC.l(8);
        cVarC.l(0);
        cVarC.i(0);
        cVarC.l(0);
        cVarC.l(0);
    }

    @Override // com.anythink.core.common.m.c.v
    public final void a(c cVar, long j) {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        }
        if (j == 0) {
            return;
        }
        b(cVar, j);
        this.c.a(cVar, j);
    }

    @Override // com.anythink.core.common.m.c.v, java.io.Flushable
    public final void flush() {
        this.c.flush();
    }

    @Override // com.anythink.core.common.m.c.v
    public final x a() {
        return this.a.a();
    }

    @Override // com.anythink.core.common.m.c.v, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        if (this.d) {
            return;
        }
        this.c.b();
        this.a.h((int) this.e.getValue());
        this.a.h((int) this.b.getBytesRead());
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
        this.d = true;
        if (th != null) {
            y.a(th);
        }
    }

    private Deflater b() {
        return this.b;
    }

    private void c() {
        c cVarC = this.a.c();
        cVarC.k(8075);
        cVarC.l(8);
        cVarC.l(0);
        cVarC.i(0);
        cVarC.l(0);
        cVarC.l(0);
    }

    private void d() {
        this.a.h((int) this.e.getValue());
        this.a.h((int) this.b.getBytesRead());
    }

    private void b(c cVar, long j) {
        s sVar = cVar.b;
        while (j > 0) {
            int iMin = (int) Math.min(j, sVar.e - sVar.d);
            this.e.update(sVar.c, sVar.d, iMin);
            j -= (long) iMin;
            sVar = sVar.h;
        }
    }
}
