package com.anythink.core.common.n.b.a.k;

import com.anythink.core.common.n.c.f;
import com.anythink.core.common.n.c.v;
import com.anythink.core.common.n.c.x;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.io.IOException;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
final class d {
    final boolean a;
    final Random b;
    final com.anythink.core.common.n.c.d c;
    final com.anythink.core.common.n.c.c d;
    boolean e;
    final com.anythink.core.common.n.c.c f = new com.anythink.core.common.n.c.c();
    final a g = new a();
    boolean h;
    private final byte[] i;
    private final com.anythink.core.common.n.c.c.a j;

    d(boolean z, com.anythink.core.common.n.c.d dVar, Random random) {
        if (dVar == null) {
            throw new NullPointerException("sink == null");
        }
        if (random == null) {
            throw new NullPointerException("random == null");
        }
        this.a = z;
        this.c = dVar;
        this.d = dVar.c();
        this.b = random;
        this.i = z ? new byte[4] : null;
        this.j = z ? new com.anythink.core.common.n.c.c.a() : null;
    }

    final void a(f fVar) throws IOException {
        b(9, fVar);
    }

    final void b(f fVar) throws IOException {
        b(10, fVar);
    }

    final void a(int i, f fVar) {
        f fVarT = f.b;
        if (i != 0 || fVar != null) {
            if (i != 0) {
                b.b(i);
            }
            com.anythink.core.common.n.c.c cVar = new com.anythink.core.common.n.c.c();
            cVar.k(i);
            if (fVar != null) {
                cVar.d(fVar);
            }
            fVarT = cVar.t();
        }
        try {
            b(8, fVarT);
        } finally {
            this.e = true;
        }
    }

    private void b(int i, f fVar) throws IOException {
        if (this.e) {
            throw new IOException("closed");
        }
        int iJ = fVar.j();
        if (iJ > 125) {
            throw new IllegalArgumentException("Payload size must be less than or equal to 125");
        }
        this.d.l(i | 128);
        if (this.a) {
            this.d.l(iJ | 128);
            this.b.nextBytes(this.i);
            this.d.d(this.i);
            if (iJ > 0) {
                long jB = this.d.b();
                this.d.d(fVar);
                this.d.a(this.j);
                this.j.a(jB);
                b.a(this.j, this.i);
                this.j.close();
            }
        } else {
            this.d.l(iJ);
            this.d.d(fVar);
        }
        this.c.flush();
    }

    private v a(int i, long j) {
        if (this.h) {
            throw new IllegalStateException("Another message writer is active. Did you call close()?");
        }
        this.h = true;
        this.g.a = i;
        this.g.b = j;
        this.g.c = true;
        this.g.d = false;
        return this.g;
    }

    final void a(int i, long j, boolean z, boolean z2) throws IOException {
        if (this.e) {
            throw new IOException("closed");
        }
        if (!z) {
            i = 0;
        }
        if (z2) {
            i |= 128;
        }
        this.d.l(i);
        int i2 = this.a ? 128 : 0;
        if (j <= 125) {
            this.d.l(((int) j) | i2);
        } else if (j <= 65535) {
            this.d.l(i2 | TTDownloadField.CALL_DOWNLOAD_MODEL_SET_IS_SHOW_TOAST);
            this.d.k((int) j);
        } else {
            this.d.l(i2 | 127);
            this.d.q(j);
        }
        if (this.a) {
            this.b.nextBytes(this.i);
            this.d.d(this.i);
            if (j > 0) {
                long jB = this.d.b();
                this.d.a(this.f, j);
                this.d.a(this.j);
                this.j.a(jB);
                b.a(this.j, this.i);
                this.j.close();
            }
        } else {
            this.d.a(this.f, j);
        }
        this.c.f();
    }

    final class a implements v {
        int a;
        long b;
        boolean c;
        boolean d;

        a() {
        }

        @Override // com.anythink.core.common.n.c.v
        public final void a(com.anythink.core.common.n.c.c cVar, long j) throws IOException {
            if (this.d) {
                throw new IOException("closed");
            }
            d.this.f.a(cVar, j);
            boolean z = this.c && this.b != -1 && d.this.f.b() > this.b - 8192;
            long j2 = d.this.f.j();
            if (j2 <= 0 || z) {
                return;
            }
            d.this.a(this.a, j2, this.c, false);
            this.c = false;
        }

        @Override // com.anythink.core.common.n.c.v, java.io.Flushable
        public final void flush() throws IOException {
            if (this.d) {
                throw new IOException("closed");
            }
            d dVar = d.this;
            dVar.a(this.a, dVar.f.b(), this.c, false);
            this.c = false;
        }

        @Override // com.anythink.core.common.n.c.v
        public final x a() {
            return d.this.c.a();
        }

        @Override // com.anythink.core.common.n.c.v, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            if (this.d) {
                throw new IOException("closed");
            }
            d dVar = d.this;
            dVar.a(this.a, dVar.f.b(), this.c, true);
            this.d = true;
            d.this.h = false;
        }
    }
}
