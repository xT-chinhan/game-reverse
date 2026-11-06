package com.anythink.basead.exoplayer.h.b;

import com.anythink.basead.exoplayer.j.k;
import com.anythink.basead.exoplayer.k.af;
import com.anythink.basead.exoplayer.m;

/* JADX INFO: loaded from: classes.dex */
public final class h extends a {
    private final int k;
    private final long l;
    private final d m;
    private volatile int n;
    private volatile boolean o;
    private volatile boolean p;

    private h(com.anythink.basead.exoplayer.j.h hVar, k kVar, m mVar, int i, Object obj, long j, long j2, long j3, long j4, int i2, long j5, d dVar) {
        super(hVar, kVar, mVar, i, obj, j, j2, j3, j4);
        this.k = i2;
        this.l = j5;
        this.m = dVar;
    }

    @Override // com.anythink.basead.exoplayer.h.b.i
    public final long e() {
        return this.j + ((long) this.k);
    }

    @Override // com.anythink.basead.exoplayer.h.b.i
    public final boolean f() {
        return this.p;
    }

    @Override // com.anythink.basead.exoplayer.h.b.c
    public final long d() {
        return this.n;
    }

    @Override // com.anythink.basead.exoplayer.j.t.c
    public final void a() {
        this.o = true;
    }

    @Override // com.anythink.basead.exoplayer.j.t.c
    public final void b() {
        k kVarA = this.b.a(this.n);
        try {
            com.anythink.basead.exoplayer.e.b bVar = new com.anythink.basead.exoplayer.e.b(this.i, kVarA.e, this.i.a(kVarA));
            if (this.n == 0) {
                b bVarC = c();
                bVarC.a(this.l);
                this.m.a(bVarC, this.a == -9223372036854775807L ? 0L : this.a - this.l);
            }
            try {
                com.anythink.basead.exoplayer.e.e eVar = this.m.a;
                int iA = 0;
                while (iA == 0 && !this.o) {
                    iA = eVar.a(bVar, (com.anythink.basead.exoplayer.e.j) null);
                }
                com.anythink.basead.exoplayer.k.a.b(iA != 1);
                this.n = (int) (bVar.c() - this.b.e);
                af.a(this.i);
                this.p = true;
            } catch (Throwable th) {
                this.n = (int) (bVar.c() - this.b.e);
                throw th;
            }
        } catch (Throwable th2) {
            af.a(this.i);
            throw th2;
        }
    }
}
