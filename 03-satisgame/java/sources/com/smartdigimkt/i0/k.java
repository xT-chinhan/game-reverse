package com.smartdigimkt.i0;

import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements h {
    public final Object a = new Object();
    public final com.smartdigimkt.x0.l b;
    public final com.smartdigimkt.x0.m c;
    public final i d;
    public final p e;
    public final Handler f;
    public final CopyOnWriteArraySet g;
    public final l0 h;
    public final k0 i;
    public final ArrayDeque j;
    public boolean k;
    public int l;
    public boolean m;
    public boolean n;
    public a0 o;
    public z p;
    public int q;
    public int r;
    public long s;

    public k(a[] aVarArr, com.smartdigimkt.x0.g gVar, c cVar) {
        Integer.toHexString(System.identityHashCode(this));
        int i = com.smartdigimkt.z0.u.a;
        if (aVarArr.length <= 0) {
            throw new IllegalStateException();
        }
        this.b = gVar;
        this.k = false;
        this.g = new CopyOnWriteArraySet();
        com.smartdigimkt.x0.m mVar = new com.smartdigimkt.x0.m(new f0[aVarArr.length], new com.smartdigimkt.x0.h[aVarArr.length], null);
        this.c = mVar;
        this.h = new l0();
        this.i = new k0();
        this.o = a0.e;
        i iVar = new i(this, Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper());
        this.d = iVar;
        com.smartdigimkt.v0.k0 k0Var = com.smartdigimkt.v0.k0.d;
        this.p = new z(0L, mVar);
        this.j = new ArrayDeque();
        p pVar = new p(aVarArr, gVar, mVar, cVar, this.k, iVar, this);
        this.e = pVar;
        this.f = new Handler(pVar.g.getLooper());
    }

    public final void a(long j) {
        int iC = c();
        m0 m0Var = this.p.c;
        if (iC < 0 || (!m0Var.c() && iC >= m0Var.b())) {
            throw new u();
        }
        this.n = true;
        this.l++;
        if (i()) {
            this.d.obtainMessage(0, 1, -1, this.p).sendToTarget();
            return;
        }
        this.q = iC;
        if (m0Var.c()) {
            this.s = j != -9223372036854775807L ? j : 0L;
            this.r = 0;
        } else {
            long jA = j == -9223372036854775807L ? m0Var.a(iC, this.h, 0L).e : b.a(j);
            Pair pairA = m0Var.a(this.h, this.i, iC, jA, 0L);
            this.s = b.b(jA);
            this.r = ((Integer) pairA.first).intValue();
        }
        this.e.f.a.obtainMessage(3, new o(m0Var, iC, b.a(j))).sendToTarget();
        Iterator it = this.g.iterator();
        while (it.hasNext()) {
            ((c0) it.next()).e();
        }
    }

    @Override // com.smartdigimkt.i0.h
    public final long b() {
        if (!i()) {
            return f();
        }
        z zVar = this.p;
        zVar.c.a(zVar.e.a, this.i, false);
        return b.b(this.p.g) + b.b(this.i.d);
    }

    @Override // com.smartdigimkt.i0.h
    public final int c() {
        if (j()) {
            return this.q;
        }
        z zVar = this.p;
        return zVar.c.a(zVar.e.a, this.i, false).b;
    }

    @Override // com.smartdigimkt.i0.h
    public final long d() {
        if (j()) {
            return this.s;
        }
        long jB = b.b(this.p.b);
        if (this.p.e.a()) {
            return jB;
        }
        z zVar = this.p;
        zVar.c.a(zVar.e.a, this.i, false);
        return jB + b.b(this.i.d);
    }

    @Override // com.smartdigimkt.i0.h
    public final m0 e() {
        return this.p.c;
    }

    @Override // com.smartdigimkt.i0.h
    public final long f() {
        if (j()) {
            return this.s;
        }
        long jB = b.b(this.p.a);
        if (this.p.e.a()) {
            return jB;
        }
        z zVar = this.p;
        zVar.c.a(zVar.e.a, this.i, false);
        return jB + b.b(this.i.d);
    }

    @Override // com.smartdigimkt.i0.h
    public final int g() {
        if (i()) {
            return this.p.e.b;
        }
        return -1;
    }

    public final long h() {
        m0 m0Var = this.p.c;
        if (m0Var.c()) {
            return -9223372036854775807L;
        }
        if (!i()) {
            return b.b(m0Var.a(c(), this.h, 0L).f);
        }
        com.smartdigimkt.v0.m mVar = this.p.e;
        m0Var.a(mVar.a, this.i, false);
        k0 k0Var = this.i;
        k0Var.e.c[mVar.b].getClass();
        return b.b(-9223372036854775807L);
    }

    public final boolean i() {
        return !j() && this.p.e.a();
    }

    public final boolean j() {
        return this.p.c.c() || this.l > 0;
    }

    @Override // com.smartdigimkt.i0.h
    public final int a() {
        if (i()) {
            return this.p.e.c;
        }
        return -1;
    }

    public final z a(boolean z, boolean z2, int i) {
        int i2;
        if (z) {
            this.q = 0;
            this.r = 0;
            this.s = 0L;
        } else {
            this.q = c();
            if (j()) {
                i2 = this.r;
            } else {
                i2 = this.p.e.a;
            }
            this.r = i2;
            this.s = f();
        }
        m0 m0Var = z2 ? m0.a : this.p.c;
        Object obj = z2 ? null : this.p.d;
        z zVar = this.p;
        return new z(m0Var, obj, zVar.e, zVar.f, zVar.g, i, false, z2 ? com.smartdigimkt.v0.k0.d : zVar.j, z2 ? this.c : zVar.k);
    }

    public final void a(z zVar, boolean z, int i, int i2, boolean z2, boolean z3) {
        try {
            synchronized (this.a) {
                boolean z4 = !this.j.isEmpty();
                this.j.addLast(new j(zVar, this.p, this.g, this.b, z, i, i2, z2, this.k, z3));
                this.p = zVar;
                if (z4) {
                    return;
                }
                while (!this.j.isEmpty()) {
                    ((j) this.j.peekFirst()).a();
                    this.j.removeFirst();
                }
            }
        } catch (Throwable unused) {
        }
    }
}
