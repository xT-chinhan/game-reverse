package com.anythink.basead.exoplayer;

import android.util.Log;
import com.anythink.basead.exoplayer.h.af;

/* JADX INFO: loaded from: classes.dex */
final class q {
    private static final String l = "MediaPeriodHolder";
    public final com.anythink.basead.exoplayer.h.r a;
    public final Object b;
    public final com.anythink.basead.exoplayer.h.y[] c;
    public final boolean[] d;
    public long e;
    public boolean f;
    public boolean g;
    public r h;
    public q i;
    public af j;
    public com.anythink.basead.exoplayer.i.i k;
    private final z[] m;
    private final com.anythink.basead.exoplayer.i.h n;
    private final com.anythink.basead.exoplayer.h.s o;
    private com.anythink.basead.exoplayer.i.i p;

    public q(z[] zVarArr, long j, com.anythink.basead.exoplayer.i.h hVar, com.anythink.basead.exoplayer.j.b bVar, com.anythink.basead.exoplayer.h.s sVar, Object obj, r rVar) {
        this.m = zVarArr;
        this.e = j - rVar.b;
        this.n = hVar;
        this.o = sVar;
        this.b = com.anythink.basead.exoplayer.k.a.a(obj);
        this.h = rVar;
        this.c = new com.anythink.basead.exoplayer.h.y[zVarArr.length];
        this.d = new boolean[zVarArr.length];
        com.anythink.basead.exoplayer.h.r rVarA = sVar.a(rVar.a, bVar);
        this.a = rVar.c != Long.MIN_VALUE ? new com.anythink.basead.exoplayer.h.d(rVarA, true, 0L, rVar.c) : rVarA;
    }

    private long d() {
        return this.e;
    }

    public final boolean a() {
        if (this.f) {
            return !this.g || this.a.d() == Long.MIN_VALUE;
        }
        return false;
    }

    private long e() {
        return this.h.e;
    }

    public final long a(boolean z) {
        if (!this.f) {
            return this.h.b;
        }
        long jD = this.a.d();
        return (jD == Long.MIN_VALUE && z) ? this.h.e : jD;
    }

    public final long b() {
        if (this.f) {
            return this.a.e();
        }
        return 0L;
    }

    private void b(float f) {
        this.f = true;
        this.j = this.a.b();
        a(f);
        long jB = b(this.h.b);
        this.e += this.h.b - jB;
        r rVar = this.h;
        this.h = new r(rVar.a, jB, rVar.c, rVar.d, rVar.e, rVar.f, rVar.g);
    }

    private void e(long j) {
        if (this.f) {
            this.a.a_(j - this.e);
        }
    }

    public final boolean a(float f) {
        com.anythink.basead.exoplayer.i.i iVarA = this.n.a(this.m, this.j);
        if (iVarA.a(this.p)) {
            return false;
        }
        this.k = iVarA;
        for (com.anythink.basead.exoplayer.i.f fVar : iVarA.c.a()) {
            if (fVar != null) {
                fVar.a(f);
            }
        }
        return true;
    }

    public final long b(long j) {
        return a(j, false, new boolean[this.m.length]);
    }

    public final long a(long j, boolean z, boolean[] zArr) {
        int i = 0;
        while (true) {
            boolean z2 = true;
            if (i >= this.k.a) {
                break;
            }
            boolean[] zArr2 = this.d;
            if (z || !this.k.a(this.p, i)) {
                z2 = false;
            }
            zArr2[i] = z2;
            i++;
        }
        a(this.c);
        a(this.k);
        com.anythink.basead.exoplayer.i.g gVar = this.k.c;
        long jA = this.a.a(gVar.a(), this.d, this.c, zArr, j);
        b(this.c);
        this.g = false;
        int i2 = 0;
        while (true) {
            com.anythink.basead.exoplayer.h.y[] yVarArr = this.c;
            if (i2 >= yVarArr.length) {
                return jA;
            }
            if (yVarArr[i2] != null) {
                com.anythink.basead.exoplayer.k.a.b(this.k.a(i2));
                if (this.m[i2].a() != 5) {
                    this.g = true;
                }
            } else {
                com.anythink.basead.exoplayer.k.a.b(gVar.a(i2) == null);
            }
            i2++;
        }
    }

    public final void c() {
        a((com.anythink.basead.exoplayer.i.i) null);
        try {
            if (this.h.c != Long.MIN_VALUE) {
                this.o.a(((com.anythink.basead.exoplayer.h.d) this.a).a);
            } else {
                this.o.a(this.a);
            }
        } catch (RuntimeException e) {
            Log.e(l, "Period release failed.", e);
        }
    }

    private void a(com.anythink.basead.exoplayer.i.i iVar) {
        com.anythink.basead.exoplayer.i.i iVar2 = this.p;
        if (iVar2 != null) {
            c(iVar2);
        }
        this.p = iVar;
        if (iVar != null) {
            b(iVar);
        }
    }

    private static void b(com.anythink.basead.exoplayer.i.i iVar) {
        for (int i = 0; i < iVar.a; i++) {
            boolean zA = iVar.a(i);
            com.anythink.basead.exoplayer.i.f fVarA = iVar.c.a(i);
            if (zA && fVarA != null) {
                fVarA.a();
            }
        }
    }

    private static void c(com.anythink.basead.exoplayer.i.i iVar) {
        for (int i = 0; i < iVar.a; i++) {
            iVar.a(i);
            iVar.c.a(i);
        }
    }

    private void a(com.anythink.basead.exoplayer.h.y[] yVarArr) {
        int i = 0;
        while (true) {
            z[] zVarArr = this.m;
            if (i >= zVarArr.length) {
                return;
            }
            if (zVarArr[i].a() == 5) {
                yVarArr[i] = null;
            }
            i++;
        }
    }

    private void b(com.anythink.basead.exoplayer.h.y[] yVarArr) {
        int i = 0;
        while (true) {
            z[] zVarArr = this.m;
            if (i >= zVarArr.length) {
                return;
            }
            if (zVarArr[i].a() == 5 && this.k.a(i)) {
                yVarArr[i] = new com.anythink.basead.exoplayer.h.m();
            }
            i++;
        }
    }

    private long c(long j) {
        return j + this.e;
    }

    private long d(long j) {
        return j - this.e;
    }

    public final void a(long j) {
        this.a.c(j - this.e);
    }
}
