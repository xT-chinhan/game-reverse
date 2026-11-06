package com.anythink.basead.exoplayer.h;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class l implements r, r.a {
    public final s a;
    public final s.a b;
    private final com.anythink.basead.exoplayer.j.b c;
    private r d;
    private r.a e;
    private long f;
    private a g;
    private boolean h;
    private long i = -9223372036854775807L;

    public interface a {
        void a(s.a aVar, IOException iOException);
    }

    public l(s sVar, s.a aVar, com.anythink.basead.exoplayer.j.b bVar) {
        this.b = aVar;
        this.c = bVar;
        this.a = sVar;
    }

    public final void a(a aVar) {
        this.g = aVar;
    }

    public final void d(long j) {
        if (this.f != 0 || j == 0) {
            return;
        }
        this.i = j;
        this.f = j;
    }

    public final void f() {
        r rVarA = this.a.a(this.b, this.c);
        this.d = rVarA;
        if (this.e != null) {
            rVarA.a(this, this.f);
        }
    }

    public final void g() {
        r rVar = this.d;
        if (rVar != null) {
            this.a.a(rVar);
        }
    }

    @Override // com.anythink.basead.exoplayer.h.r
    public final void a(r.a aVar, long j) {
        this.e = aVar;
        this.f = j;
        r rVar = this.d;
        if (rVar != null) {
            rVar.a(this, j);
        }
    }

    @Override // com.anythink.basead.exoplayer.h.r
    public final void a() throws IOException {
        try {
            r rVar = this.d;
            if (rVar != null) {
                rVar.a();
            } else {
                this.a.b();
            }
        } catch (IOException e) {
            a aVar = this.g;
            if (aVar == null) {
                throw e;
            }
            if (this.h) {
                return;
            }
            this.h = true;
            aVar.a(this.b, e);
        }
    }

    @Override // com.anythink.basead.exoplayer.h.r
    public final af b() {
        return this.d.b();
    }

    @Override // com.anythink.basead.exoplayer.h.r
    public final long a(com.anythink.basead.exoplayer.i.f[] fVarArr, boolean[] zArr, y[] yVarArr, boolean[] zArr2, long j) {
        long j2;
        long j3 = this.i;
        if (j3 == -9223372036854775807L || j != 0) {
            j2 = j;
        } else {
            this.i = -9223372036854775807L;
            j2 = j3;
        }
        return this.d.a(fVarArr, zArr, yVarArr, zArr2, j2);
    }

    @Override // com.anythink.basead.exoplayer.h.r
    public final void a(long j, boolean z) {
        this.d.a(j, z);
    }

    @Override // com.anythink.basead.exoplayer.h.r
    public final long c() {
        return this.d.c();
    }

    @Override // com.anythink.basead.exoplayer.h.r, com.anythink.basead.exoplayer.h.z
    public final long d() {
        return this.d.d();
    }

    @Override // com.anythink.basead.exoplayer.h.r
    public final long b(long j) {
        return this.d.b(j);
    }

    @Override // com.anythink.basead.exoplayer.h.r
    public final long a(long j, com.anythink.basead.exoplayer.ac acVar) {
        return this.d.a(j, acVar);
    }

    @Override // com.anythink.basead.exoplayer.h.r, com.anythink.basead.exoplayer.h.z
    public final long e() {
        return this.d.e();
    }

    @Override // com.anythink.basead.exoplayer.h.r, com.anythink.basead.exoplayer.h.z
    public final void a_(long j) {
        this.d.a_(j);
    }

    @Override // com.anythink.basead.exoplayer.h.r, com.anythink.basead.exoplayer.h.z
    public final boolean c(long j) {
        r rVar = this.d;
        return rVar != null && rVar.c(j);
    }

    private void h() {
        this.e.a(this);
    }

    @Override // com.anythink.basead.exoplayer.h.r.a
    public final void a(r rVar) {
        this.e.a((r) this);
    }

    @Override // com.anythink.basead.exoplayer.h.z.a
    public final /* bridge */ /* synthetic */ void a(z zVar) {
        this.e.a(this);
    }
}
