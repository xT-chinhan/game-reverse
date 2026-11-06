package com.smartdigimkt.i0;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class p implements Handler.Callback, com.smartdigimkt.v0.k, com.smartdigimkt.v0.n, d, d0 {
    public o A;
    public long B;
    public int C;
    public final a[] a;
    public final a[] b;
    public final com.smartdigimkt.x0.l c;
    public final com.smartdigimkt.x0.m d;
    public final c e;
    public final com.smartdigimkt.z0.q f;
    public final HandlerThread g;
    public final Handler h;
    public final h i;
    public final l0 j;
    public final k0 k;
    public final e l;
    public final n m;
    public final ArrayList n;
    public final com.smartdigimkt.z0.c o;
    public final x p;
    public g0 q;
    public z r;
    public com.smartdigimkt.v0.j s;
    public a[] t;
    public boolean u;
    public boolean v;
    public boolean w;
    public int x;
    public boolean y;
    public int z;

    public p(a[] aVarArr, com.smartdigimkt.x0.g gVar, com.smartdigimkt.x0.m mVar, c cVar, boolean z, i iVar, h hVar) {
        com.smartdigimkt.z0.p pVar = com.smartdigimkt.z0.c.a;
        this.a = aVarArr;
        this.c = gVar;
        this.d = mVar;
        this.e = cVar;
        this.v = z;
        this.x = 0;
        this.y = false;
        this.h = iVar;
        this.i = hVar;
        this.o = pVar;
        this.p = new x();
        this.q = g0.d;
        com.smartdigimkt.v0.k0 k0Var = com.smartdigimkt.v0.k0.d;
        this.r = new z(-9223372036854775807L, mVar);
        this.m = new n();
        this.b = new a[aVarArr.length];
        for (int i = 0; i < aVarArr.length; i++) {
            a aVar = aVarArr[i];
            aVar.getClass();
            this.b[i] = aVar;
        }
        this.l = new e(this);
        this.n = new ArrayList();
        this.t = new a[0];
        this.j = new l0();
        this.k = new k0();
        HandlerThread handlerThread = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.g = handlerThread;
        handlerThread.start();
        this.f = pVar.a(handlerThread.getLooper(), this);
    }

    @Override // com.smartdigimkt.v0.k
    public final void a(com.smartdigimkt.v0.l lVar) {
        this.f.a.obtainMessage(10, lVar).sendToTarget();
    }

    @Override // com.smartdigimkt.v0.k
    public final void b(com.smartdigimkt.v0.l lVar) {
        this.f.a.obtainMessage(9, lVar).sendToTarget();
    }

    public final void c(boolean z) {
        this.w = false;
        this.v = z;
        if (!z) {
            j();
            k();
            return;
        }
        int i = this.r.h;
        if (i == 3) {
            i();
            this.f.a.sendEmptyMessage(2);
        } else if (i == 2) {
            this.f.a.sendEmptyMessage(2);
        }
    }

    public final void d() {
        n nVar = this.m;
        z zVar = this.r;
        if (zVar != nVar.a || nVar.b > 0 || nVar.c) {
            this.h.obtainMessage(0, nVar.b, nVar.c ? nVar.d : -1, zVar).sendToTarget();
            n nVar2 = this.m;
            nVar2.a = this.r;
            nVar2.b = 0;
            nVar2.c = false;
        }
    }

    public final void e() {
        x xVar = this.p;
        v vVar = xVar.i;
        v vVar2 = xVar.h;
        if (vVar == null || vVar.b) {
            return;
        }
        if (vVar2 == null || vVar2.e == vVar) {
            for (a aVar : this.t) {
                if (!aVar.g) {
                    return;
                }
            }
            vVar.h.e();
        }
    }

    public final synchronized void f() {
        if (!this.u && this.g.isAlive()) {
            this.f.a.sendEmptyMessage(7);
            ((com.smartdigimkt.z0.p) this.o).getClass();
            long jElapsedRealtime = SystemClock.elapsedRealtime() + 500;
            boolean z = false;
            for (long jElapsedRealtime2 = 500; !this.u && jElapsedRealtime2 > 0; jElapsedRealtime2 = jElapsedRealtime - SystemClock.elapsedRealtime()) {
                try {
                    wait(jElapsedRealtime2);
                } catch (InterruptedException unused) {
                    z = true;
                }
                ((com.smartdigimkt.z0.p) this.o).getClass();
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public final void g() {
        a(true, true, true);
        this.e.a(true);
        b(1);
        this.g.quitSafely();
        synchronized (this) {
            this.u = true;
            notifyAll();
        }
    }

    public final void h() throws g {
        if (this.p.c()) {
            float f = this.l.a().a;
            x xVar = this.p;
            v vVar = xVar.h;
            boolean z = true;
            for (v vVar2 = xVar.g; vVar2 != null && vVar2.b; vVar2 = vVar2.e) {
                if (vVar2.b()) {
                    if (z) {
                        x xVar2 = this.p;
                        v vVar3 = xVar2.g;
                        boolean zA = xVar2.a(vVar3);
                        boolean[] zArr = new boolean[this.a.length];
                        long jA = vVar3.a(this.r.a, zA, zArr);
                        a(vVar3.g);
                        z zVar = this.r;
                        if (zVar.h != 4 && jA != zVar.a) {
                            z zVar2 = this.r;
                            this.r = zVar2.a(zVar2.e, jA, zVar2.g);
                            this.m.a(4);
                            a(jA);
                        }
                        boolean[] zArr2 = new boolean[this.a.length];
                        int i = 0;
                        int i2 = 0;
                        while (true) {
                            a[] aVarArr = this.a;
                            if (i >= aVarArr.length) {
                                break;
                            }
                            a aVar = aVarArr[i];
                            boolean z2 = aVar.c != 0;
                            zArr2[i] = z2;
                            com.smartdigimkt.v0.f0 f0Var = vVar3.j[i];
                            if (f0Var != null) {
                                i2++;
                            }
                            if (z2) {
                                if (f0Var != aVar.d) {
                                    a(aVar);
                                } else if (zArr[i]) {
                                    long j = this.B;
                                    aVar.h = false;
                                    aVar.g = false;
                                    aVar.a(j, false);
                                }
                            }
                            i++;
                        }
                        z zVar3 = this.r;
                        z zVar4 = new z(zVar3.c, zVar3.d, zVar3.e, zVar3.f, zVar3.g, zVar3.h, zVar3.i, vVar3.f, vVar3.g);
                        zVar4.a = zVar3.a;
                        zVar4.b = zVar3.b;
                        this.r = zVar4;
                        a(zArr2, i2);
                    } else {
                        this.p.a(vVar2);
                        if (vVar2.b) {
                            vVar2.a(Math.max(vVar2.d.b, this.B - vVar2.a), false, new boolean[vVar2.l.length]);
                            a(vVar2.g);
                        }
                    }
                    if (this.r.h != 4) {
                        c();
                        k();
                        this.f.a.sendEmptyMessage(2);
                        return;
                    }
                    return;
                }
                if (vVar2 == vVar) {
                    z = false;
                }
            }
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        try {
            switch (message.what) {
                case 0:
                    a((com.smartdigimkt.v0.j) message.obj, message.arg1 != 0, message.arg2 != 0);
                    break;
                case 1:
                    c(message.arg1 != 0);
                    break;
                case 2:
                    a();
                    break;
                case 3:
                    a((o) message.obj);
                    break;
                case 4:
                    this.l.a((a0) message.obj);
                    break;
                case 5:
                    this.q = (g0) message.obj;
                    break;
                case 6:
                    a(message.arg1 != 0, true);
                    break;
                case 7:
                    g();
                    return true;
                case 8:
                    a((m) message.obj);
                    break;
                case 9:
                    d((com.smartdigimkt.v0.l) message.obj);
                    break;
                case 10:
                    c((com.smartdigimkt.v0.l) message.obj);
                    break;
                case 11:
                    h();
                    break;
                case 12:
                    a(message.arg1);
                    break;
                case 13:
                    d(message.arg1 != 0);
                    break;
                case 14:
                    e0 e0Var = (e0) message.obj;
                    e0Var.getClass();
                    if (e0Var.e.getLooper() != this.f.a.getLooper()) {
                        this.f.a.obtainMessage(15, e0Var).sendToTarget();
                    } else {
                        a(e0Var);
                        int i = this.r.h;
                        if (i == 3 || i == 2) {
                            this.f.a.sendEmptyMessage(2);
                        }
                    }
                    break;
                case 15:
                    e0 e0Var2 = (e0) message.obj;
                    e0Var2.e.post(new l(this, e0Var2));
                    break;
                default:
                    return false;
            }
            d();
        } catch (g e) {
            a(false, false);
            this.h.obtainMessage(2, e).sendToTarget();
            d();
        } catch (IOException e2) {
            a(false, false);
            this.h.obtainMessage(2, new g(0, e2)).sendToTarget();
            d();
        } catch (RuntimeException e3) {
            a(false, false);
            this.h.obtainMessage(2, new g(2, e3)).sendToTarget();
            d();
        }
        return true;
    }

    public final void i() {
        this.w = false;
        com.smartdigimkt.z0.o oVar = this.l.a;
        if (!oVar.b) {
            ((com.smartdigimkt.z0.p) oVar.a).getClass();
            oVar.d = SystemClock.elapsedRealtime();
            oVar.b = true;
        }
        for (a aVar : this.t) {
            if (aVar.c != 1) {
                throw new IllegalStateException();
            }
            aVar.c = 2;
            aVar.h();
        }
    }

    public final void j() {
        com.smartdigimkt.z0.o oVar = this.l.a;
        if (oVar.b) {
            oVar.a(oVar.b());
            oVar.b = false;
        }
        for (a aVar : this.t) {
            int i = aVar.c;
            if (i == 2) {
                if (i != 2) {
                    throw new IllegalStateException();
                }
                aVar.c = 1;
                aVar.i();
            }
        }
    }

    public final void k() {
        long jB;
        long jD;
        if (this.p.c()) {
            v vVar = this.p.g;
            long jC = vVar.h.c();
            if (jC != -9223372036854775807L) {
                a(jC);
                if (jC != this.r.a) {
                    z zVar = this.r;
                    this.r = zVar.a(zVar.e, jC, zVar.g);
                    this.m.a(4);
                }
            } else {
                e eVar = this.l;
                a aVar = eVar.c;
                if (aVar == null || aVar.d() || (!eVar.c.e() && eVar.c.g)) {
                    jB = eVar.a.b();
                } else {
                    eVar.a.a(eVar.d.b());
                    a0 a0VarA = eVar.d.a();
                    if (!a0VarA.equals(eVar.a.e)) {
                        eVar.a.a(a0VarA);
                        ((p) eVar.b).a(a0VarA);
                    }
                    jB = eVar.d.b();
                }
                this.B = jB;
                long j = jB - vVar.a;
                long j2 = this.r.a;
                if (!this.n.isEmpty() && !this.r.e.a()) {
                    z zVar2 = this.r;
                    long j3 = zVar2.f;
                    int i = zVar2.e.a;
                    int i2 = this.C;
                    if (i2 > 0 && this.n.get(i2 - 1) != null) {
                        throw new ClassCastException();
                    }
                    if (this.C < this.n.size() && this.n.get(this.C) != null) {
                        throw new ClassCastException();
                    }
                }
                this.r.a = j;
            }
            z zVar3 = this.r;
            if (this.t.length == 0) {
                jD = vVar.d.e;
            } else if (vVar.b) {
                jD = vVar.h.d();
                if (jD == Long.MIN_VALUE) {
                    jD = vVar.d.e;
                }
            } else {
                jD = vVar.d.b;
            }
            zVar3.b = jD;
        }
    }

    public final void a(a0 a0Var) {
        this.h.obtainMessage(1, a0Var).sendToTarget();
        float f = a0Var.a;
        for (v vVarB = this.p.b(); vVarB != null; vVarB = vVarB.e) {
            com.smartdigimkt.x0.m mVar = vVarB.g;
            if (mVar != null) {
                for (com.smartdigimkt.x0.h hVar : (com.smartdigimkt.x0.h[]) mVar.c.b.clone()) {
                }
            }
        }
    }

    public final void b(int i) {
        z zVar = this.r;
        if (zVar.h != i) {
            z zVar2 = new z(zVar.c, zVar.d, zVar.e, zVar.f, zVar.g, i, zVar.i, zVar.j, zVar.k);
            zVar2.a = zVar.a;
            zVar2.b = zVar.b;
            this.r = zVar2;
        }
    }

    public final void b(boolean z) {
        z zVar = this.r;
        if (zVar.i != z) {
            z zVar2 = new z(zVar.c, zVar.d, zVar.e, zVar.f, zVar.g, zVar.h, z, zVar.j, zVar.k);
            zVar2.a = zVar.a;
            zVar2.b = zVar.b;
            this.r = zVar2;
        }
    }

    public final void c(com.smartdigimkt.v0.l lVar) {
        com.smartdigimkt.v0.l lVar2;
        v vVar = this.p.i;
        if (vVar == null || (lVar2 = vVar.h) != lVar) {
            return;
        }
        long j = this.B;
        if (vVar != null && vVar.b) {
            lVar2.d(j - vVar.a);
        }
        c();
    }

    public final void d(boolean z) throws g {
        this.y = z;
        x xVar = this.p;
        xVar.f = z;
        if (xVar.d()) {
            return;
        }
        a(true);
    }

    public final void a(com.smartdigimkt.v0.j jVar, boolean z, boolean z2) {
        this.z++;
        a(true, z, z2);
        this.e.a(false);
        this.s = jVar;
        b(2);
        h hVar = this.i;
        h hVar2 = jVar.c;
        if (hVar2 != null && hVar2 != hVar) {
            throw new IllegalArgumentException();
        }
        jVar.a.add(this);
        if (jVar.c == null) {
            jVar.c = hVar;
            long j = jVar.m;
            jVar.m = j;
            jVar.n = false;
            com.smartdigimkt.v0.g0 g0Var = new com.smartdigimkt.v0.g0(j, false, jVar.l);
            jVar.d = g0Var;
            jVar.e = null;
            Iterator it = jVar.a.iterator();
            while (it.hasNext()) {
                ((p) ((com.smartdigimkt.v0.n) it.next())).f.a.obtainMessage(8, new m(jVar, g0Var, null)).sendToTarget();
            }
        } else {
            m0 m0Var = jVar.d;
            if (m0Var != null) {
                Object obj = jVar.e;
                this.f.a.obtainMessage(8, new m(jVar, m0Var, obj)).sendToTarget();
            }
        }
        this.f.a.sendEmptyMessage(2);
    }

    public final boolean b() {
        v vVar;
        v vVar2 = this.p.g;
        long j = vVar2.d.e;
        return j == -9223372036854775807L || this.r.a < j || ((vVar = vVar2.e) != null && (vVar.b || vVar.d.a.a()));
    }

    public final void d(com.smartdigimkt.v0.l lVar) throws g {
        v vVar = this.p.i;
        if (vVar == null || vVar.h != lVar) {
            return;
        }
        float f = this.l.a().a;
        vVar.b = true;
        vVar.f = vVar.h.a();
        vVar.b();
        long jA = vVar.a(vVar.d.b, false, new boolean[vVar.l.length]);
        long j = vVar.a;
        w wVar = vVar.d;
        vVar.a = (wVar.b - jA) + j;
        vVar.d = new w(wVar.a, jA, wVar.c, wVar.d, wVar.e, wVar.f, wVar.g);
        a(vVar.g);
        if (!this.p.c()) {
            a(this.p.a().d.b);
            a((v) null);
        }
        c();
    }

    public final void c() {
        int i;
        v vVar = this.p.i;
        long jB = !vVar.b ? 0L : vVar.h.b();
        if (jB == Long.MIN_VALUE) {
            b(false);
            return;
        }
        long j = jB - (this.B - vVar.a);
        c cVar = this.e;
        float f = this.l.a().a;
        com.smartdigimkt.y0.l lVar = cVar.a;
        synchronized (lVar) {
            i = lVar.c * 65536;
        }
        boolean z = i >= cVar.h;
        long jMin = cVar.b;
        if (f > 1.0f) {
            int i2 = com.smartdigimkt.z0.u.a;
            if (f != 1.0f) {
                jMin = Math.round(jMin * ((double) f));
            }
            jMin = Math.min(jMin, cVar.c);
        }
        if (j < jMin) {
            cVar.i = cVar.g || !z;
        } else if (j > cVar.c || z) {
            cVar.i = false;
        }
        boolean z2 = cVar.i;
        b(z2);
        if (z2) {
            vVar.h.c(this.B - vVar.a);
        }
    }

    public final void a(int i) throws g {
        this.x = i;
        x xVar = this.p;
        xVar.e = i;
        if (xVar.d()) {
            return;
        }
        a(true);
    }

    public final void a(boolean z) throws g {
        com.smartdigimkt.v0.m mVar = this.p.g.d.a;
        long jA = a(mVar, this.r.a, true);
        if (jA != this.r.a) {
            z zVar = this.r;
            this.r = zVar.a(mVar, jA, zVar.g);
            if (z) {
                this.m.a(4);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:239:0x03ce  */
    /* JADX WARN: Code duplicated, block: B:240:0x03d2  */
    /* JADX WARN: Code duplicated, block: B:242:0x03d9  */
    public final void a() throws g {
        long j;
        long j2;
        int i;
        int i2;
        v vVar;
        Object obj;
        w wVarA;
        long j3;
        v vVar2;
        ((com.smartdigimkt.z0.p) this.o).getClass();
        long jUptimeMillis = SystemClock.uptimeMillis();
        int i3 = 0;
        if (this.s != null && this.z <= 0) {
            x xVar = this.p;
            long j4 = this.B;
            v vVar3 = xVar.i;
            if (vVar3 != null && vVar3.b) {
                vVar3.h.d(j4 - vVar3.a);
            }
            x xVar2 = this.p;
            v vVar4 = xVar2.i;
            if (vVar4 == null || (!vVar4.d.g && vVar4.b && ((!vVar4.c || vVar4.h.d() == Long.MIN_VALUE) && xVar2.i.d.e != -9223372036854775807L && xVar2.j < 100))) {
                x xVar3 = this.p;
                long j5 = this.B;
                z zVar = this.r;
                v vVar5 = xVar3.i;
                if (vVar5 == null) {
                    com.smartdigimkt.v0.m mVar = zVar.e;
                    long j6 = zVar.f;
                    xVar3.d.a(mVar.a, xVar3.a, false);
                    if (mVar.a()) {
                        xVar3.a.e.c[mVar.b].getClass();
                        obj = null;
                        wVarA = null;
                    } else {
                        obj = null;
                        wVarA = xVar3.a(mVar.a, j6, mVar.d);
                    }
                } else {
                    obj = null;
                    wVarA = xVar3.a(vVar5, j5);
                }
                if (wVarA == null) {
                    this.s.getClass();
                } else {
                    Object obj2 = this.r.c.a(wVarA.a.a, this.k, true).a;
                    x xVar4 = this.p;
                    a[] aVarArr = this.b;
                    com.smartdigimkt.x0.l lVar = this.c;
                    com.smartdigimkt.y0.l lVar2 = this.e.a;
                    com.smartdigimkt.v0.j jVar = this.s;
                    v vVar6 = xVar4.i;
                    if (vVar6 == null) {
                        j3 = wVarA.b;
                    } else {
                        j3 = vVar6.a + vVar6.d.e;
                    }
                    v vVar7 = new v(aVarArr, j3, lVar, lVar2, jVar, obj2, wVarA);
                    if (xVar4.i != null) {
                        if (xVar4.c()) {
                            xVar4.i.e = vVar7;
                        } else {
                            throw new IllegalStateException();
                        }
                    }
                    xVar4.k = obj;
                    xVar4.i = vVar7;
                    xVar4.j++;
                    vVar7.h.a(this, wVarA.b);
                    b(true);
                }
            }
            v vVar8 = this.p.i;
            if (vVar8 != null && (!vVar8.b || (vVar8.c && vVar8.h.d() != Long.MIN_VALUE))) {
                if (!this.r.i) {
                    c();
                }
            } else {
                b(false);
            }
            if (this.p.c()) {
                x xVar5 = this.p;
                v vVar9 = xVar5.g;
                v vVar10 = xVar5.h;
                boolean z = false;
                while (this.v && vVar9 != vVar10 && this.B >= vVar9.e.a) {
                    if (z) {
                        d();
                    }
                    int i4 = vVar9.d.f ? 0 : 3;
                    v vVarA = this.p.a();
                    a(vVar9);
                    z zVar2 = this.r;
                    w wVar = vVarA.d;
                    this.r = zVar2.a(wVar.a, wVar.b, wVar.d);
                    this.m.a(i4);
                    k();
                    vVar9 = vVarA;
                    z = true;
                }
                if (!vVar10.d.g) {
                    v vVar11 = vVar10.e;
                    if (vVar11 != null && vVar11.b) {
                        int i5 = 0;
                        while (true) {
                            a[] aVarArr2 = this.a;
                            if (i5 < aVarArr2.length) {
                                a aVar = aVarArr2[i5];
                                com.smartdigimkt.v0.f0 f0Var = vVar10.j[i5];
                                if (aVar.d != f0Var || (f0Var != null && !aVar.g)) {
                                    break;
                                } else {
                                    i5++;
                                }
                            } else {
                                com.smartdigimkt.x0.m mVar2 = vVar10.g;
                                x xVar6 = this.p;
                                v vVar12 = xVar6.h;
                                if (vVar12 != null && (vVar2 = vVar12.e) != null) {
                                    xVar6.h = vVar2;
                                    com.smartdigimkt.x0.m mVar3 = vVar2.g;
                                    boolean z2 = vVar2.h.c() != -9223372036854775807L;
                                    int i6 = 0;
                                    while (true) {
                                        a[] aVarArr3 = this.a;
                                        if (i6 >= aVarArr3.length) {
                                            break;
                                        }
                                        a aVar2 = aVarArr3[i6];
                                        if (mVar2.a(i6)) {
                                            if (z2) {
                                                aVar2.h = true;
                                            } else if (!aVar2.h) {
                                                com.smartdigimkt.x0.h hVar = mVar3.c.b[i6];
                                                boolean zA = mVar3.a(i6);
                                                boolean z3 = this.b[i6].a == 5;
                                                f0 f0Var2 = mVar2.b[i6];
                                                f0 f0Var3 = mVar3.b[i6];
                                                if (zA && f0Var3.equals(f0Var2) && !z3) {
                                                    int length = hVar != null ? hVar.b.length : 0;
                                                    s[] sVarArr = new s[length];
                                                    for (int i7 = 0; i7 < length; i7++) {
                                                        sVarArr[i7] = hVar.c[i7];
                                                    }
                                                    com.smartdigimkt.v0.f0 f0Var4 = vVar2.j[i6];
                                                    long j7 = vVar2.a;
                                                    if (!aVar2.h) {
                                                        aVar2.d = f0Var4;
                                                        aVar2.g = false;
                                                        aVar2.e = sVarArr;
                                                        aVar2.f = j7;
                                                        aVar2.a(sVarArr, j7);
                                                    } else {
                                                        throw new IllegalStateException();
                                                    }
                                                } else {
                                                    aVar2.h = true;
                                                }
                                            }
                                        }
                                        i6++;
                                    }
                                } else {
                                    throw new IllegalStateException();
                                }
                            }
                        }
                    }
                } else {
                    int i8 = 0;
                    while (true) {
                        a[] aVarArr4 = this.a;
                        if (i8 >= aVarArr4.length) {
                            break;
                        }
                        a aVar3 = aVarArr4[i8];
                        com.smartdigimkt.v0.f0 f0Var5 = vVar10.j[i8];
                        if (f0Var5 != null && aVar3.d == f0Var5 && aVar3.g) {
                            aVar3.h = true;
                        }
                        i8++;
                    }
                }
            }
            i3 = 0;
        }
        if (!this.p.c()) {
            e();
            this.f.a.removeMessages(2);
            this.f.a.sendEmptyMessageAtTime(2, jUptimeMillis + 10);
            return;
        }
        v vVar13 = this.p.g;
        com.smartdigimkt.z0.s.a("doSomeWork");
        k();
        long jElapsedRealtime = SystemClock.elapsedRealtime() * 1000;
        vVar13.h.b(this.r.a);
        a[] aVarArr5 = this.t;
        int length2 = aVarArr5.length;
        boolean z4 = true;
        boolean z5 = true;
        for (int i9 = i3; i9 < length2; i9++) {
            a aVar4 = aVarArr5[i9];
            aVar4.a(this.B, jElapsedRealtime);
            z5 = z5 && aVar4.d();
            boolean z6 = aVar4.e() || aVar4.d() || ((vVar = this.p.h.e) != null && vVar.b && aVar4.g);
            if (!z6) {
                aVar4.d.b();
            }
            z4 = z4 && z6;
        }
        if (!z4) {
            e();
        }
        long j8 = vVar13.d.e;
        if (z5 && ((j8 == -9223372036854775807L || j8 <= this.r.a) && vVar13.d.g)) {
            b(4);
            j();
        } else {
            z zVar3 = this.r;
            if (zVar3.h == 2) {
                if (this.t.length == 0) {
                    if (b()) {
                        b(3);
                        if (this.v) {
                            i();
                        }
                    } else if (this.r.h == 3) {
                        this.w = this.v;
                        b(2);
                        j();
                    }
                } else {
                    if (z4) {
                        if (zVar3.i) {
                            v vVar14 = this.p.i;
                            w wVar2 = vVar14.d;
                            boolean z7 = !wVar2.g;
                            if (!vVar14.b) {
                                j2 = wVar2.b;
                                j = Long.MIN_VALUE;
                            } else {
                                long jD = vVar14.h.d();
                                j = Long.MIN_VALUE;
                                j2 = (jD == Long.MIN_VALUE && z7) ? vVar14.d.e : jD;
                            }
                            if (j2 != j) {
                                c cVar = this.e;
                                long jRound = j2 - (this.B - vVar14.a);
                                float f = this.l.a().a;
                                boolean z8 = this.w;
                                cVar.getClass();
                                int i10 = com.smartdigimkt.z0.u.a;
                                if (f != 1.0f) {
                                    jRound = Math.round(jRound / ((double) f));
                                }
                                long j9 = z8 ? cVar.e : cVar.d;
                                if (j9 > 0 && jRound < j9) {
                                    if (!cVar.g) {
                                        com.smartdigimkt.y0.l lVar3 = cVar.a;
                                        synchronized (lVar3) {
                                            i = lVar3.c * 65536;
                                        }
                                        if (i >= cVar.h) {
                                        }
                                    }
                                }
                            }
                        }
                        b(3);
                        if (this.v) {
                            i();
                        }
                    }
                    if (this.r.h == 3) {
                        this.w = this.v;
                        b(2);
                        j();
                    }
                }
            } else if (this.r.h == 3 && (this.t.length != 0 ? !z4 : !b())) {
                this.w = this.v;
                b(2);
                j();
            }
        }
        if (this.r.h == 2) {
            for (a aVar5 : this.t) {
                aVar5.d.b();
            }
        }
        if ((this.v && this.r.h == 3) || (i2 = this.r.h) == 2) {
            this.f.a.removeMessages(2);
            this.f.a.sendEmptyMessageAtTime(2, jUptimeMillis + 10);
        } else if (this.t.length != 0 && i2 != 4) {
            this.f.a.removeMessages(2);
            this.f.a.sendEmptyMessageAtTime(2, jUptimeMillis + 1000);
        } else {
            this.f.a.removeMessages(2);
        }
        com.smartdigimkt.z0.s.a();
    }

    /* JADX WARN: Code duplicated, block: B:59:0x00f9 A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:68:? A[RETURN, SYNTHETIC] */
    public final void a(o oVar) {
        long jLongValue;
        boolean z;
        com.smartdigimkt.v0.m mVar;
        long j;
        long j2;
        z zVarA;
        long jA;
        int i;
        boolean z2 = true;
        this.m.b++;
        Pair pairA = a(oVar, true);
        if (pairA == null) {
            m0 m0Var = this.r.c;
            if (m0Var.c()) {
                i = 0;
            } else {
                i = m0Var.a(m0Var.c() ? -1 : 0, this.j, 0L).c;
            }
            mVar = new com.smartdigimkt.v0.m(i);
            z = true;
            jLongValue = -9223372036854775807L;
            j = -9223372036854775807L;
        } else {
            int iIntValue = ((Integer) pairA.first).intValue();
            long jLongValue2 = ((Long) pairA.second).longValue();
            com.smartdigimkt.v0.m mVarA = this.p.a(iIntValue, jLongValue2);
            if (mVarA.a()) {
                z = true;
                jLongValue = 0;
            } else {
                jLongValue = ((Long) pairA.second).longValue();
                z = oVar.c == -9223372036854775807L;
            }
            mVar = mVarA;
            j = jLongValue2;
        }
        try {
            if (this.s == null || this.z > 0) {
                this.A = oVar;
            } else {
                if (jLongValue == -9223372036854775807L) {
                    b(4);
                    a(false, true, false);
                } else {
                    if (mVar.equals(this.r.e)) {
                        v vVar = this.p.g;
                        jA = (vVar == null || jLongValue == 0) ? jLongValue : vVar.h.a(jLongValue, this.q);
                        if (b.b(jA) == b.b(this.r.a)) {
                            zVarA = this.r.a(mVar, this.r.a, j);
                            if (z) {
                                return;
                            } else {
                                return;
                            }
                        }
                    } else {
                        jA = jLongValue;
                    }
                    x xVar = this.p;
                    long jA2 = a(mVar, jA, xVar.g != xVar.h);
                    if (jLongValue == jA2) {
                        z2 = false;
                    }
                    z |= z2;
                    j2 = jA2;
                }
                zVarA = this.r.a(mVar, j2, j);
            }
            j2 = jLongValue;
            zVarA = this.r.a(mVar, j2, j);
        } finally {
            this.r = this.r.a(mVar, jLongValue, j);
            if (z) {
                this.m.a(2);
            }
        }
    }

    public final long a(com.smartdigimkt.v0.m mVar, long j, boolean z) throws g {
        j();
        this.w = false;
        b(2);
        v vVar = this.p.g;
        v vVarA = vVar;
        while (vVarA != null) {
            if (mVar.equals(vVarA.d.a) && vVarA.b) {
                this.r.c.a(vVarA.d.a.a, this.k, false);
                int iA = this.k.a(j);
                if (iA == -1 || this.k.e.b[iA] == vVarA.d.c) {
                    this.p.a(vVarA);
                    break;
                }
            }
            vVarA = this.p.a();
        }
        if (vVar != vVarA || z) {
            for (a aVar : this.t) {
                a(aVar);
            }
            this.t = new a[0];
            vVar = null;
        }
        if (vVarA != null) {
            a(vVar);
            if (vVarA.c) {
                long jA = vVarA.h.a(j);
                vVarA.h.b(jA);
                j = jA;
            }
            a(j);
            c();
        } else {
            this.p.a(true);
            a(j);
        }
        this.f.a.sendEmptyMessage(2);
        return j;
    }

    public final void a(long j) {
        if (this.p.c()) {
            j += this.p.g.a;
        }
        this.B = j;
        this.l.a.a(j);
        for (a aVar : this.t) {
            long j2 = this.B;
            aVar.h = false;
            aVar.g = false;
            aVar.a(j2, false);
        }
    }

    public final void a(boolean z, boolean z2) {
        a(true, z, z);
        this.m.b += this.z + (z2 ? 1 : 0);
        this.z = 0;
        this.e.a(true);
        b(1);
    }

    public final void a(boolean z, boolean z2, boolean z3) {
        com.smartdigimkt.v0.m mVar;
        com.smartdigimkt.v0.j jVar;
        this.f.a.removeMessages(2);
        int i = 0;
        this.w = false;
        com.smartdigimkt.z0.o oVar = this.l.a;
        if (oVar.b) {
            oVar.a(oVar.b());
            oVar.b = false;
        }
        this.B = 0L;
        for (a aVar : this.t) {
            try {
                a(aVar);
            } catch (g | RuntimeException unused) {
            }
        }
        this.t = new a[0];
        this.p.a(!z2);
        b(false);
        if (z2) {
            this.A = null;
        }
        if (z3) {
            this.p.d = m0.a;
            Iterator it = this.n.iterator();
            if (!it.hasNext()) {
                this.n.clear();
                this.C = 0;
            } else {
                com.smartdigimkt.a.a.a(it.next());
                throw null;
            }
        }
        m0 m0Var = z3 ? m0.a : this.r.c;
        Object obj = z3 ? null : this.r.d;
        if (z2) {
            m0 m0Var2 = this.r.c;
            if (!m0Var2.c()) {
                i = m0Var2.a(m0Var2.c() ? -1 : 0, this.j, 0L).c;
            }
            mVar = new com.smartdigimkt.v0.m(i);
        } else {
            mVar = this.r.e;
        }
        long j = z2 ? -9223372036854775807L : this.r.a;
        long j2 = z2 ? -9223372036854775807L : this.r.g;
        z zVar = this.r;
        this.r = new z(m0Var, obj, mVar, j, j2, zVar.h, false, z3 ? com.smartdigimkt.v0.k0.d : zVar.j, z3 ? this.d : zVar.k);
        if (!z || (jVar = this.s) == null) {
            return;
        }
        jVar.a.remove(this);
        if (jVar.a.isEmpty()) {
            jVar.c = null;
            jVar.d = null;
            jVar.e = null;
        }
        this.s = null;
    }

    public static void a(e0 e0Var) {
        synchronized (e0Var) {
        }
        try {
            e0Var.a.a(e0Var.c, e0Var.d);
        } finally {
            e0Var.a(true);
        }
    }

    public final void a(a aVar) {
        e eVar = this.l;
        if (aVar == eVar.c) {
            eVar.d = null;
            eVar.c = null;
        }
        int i = aVar.c;
        if (i == 2) {
            if (i == 2) {
                aVar.c = 1;
                aVar.i();
            } else {
                throw new IllegalStateException();
            }
        }
        if (aVar.c == 1) {
            aVar.c = 0;
            aVar.d = null;
            aVar.e = null;
            aVar.h = false;
            aVar.f();
            return;
        }
        throw new IllegalStateException();
    }

    public final void a(com.smartdigimkt.x0.m mVar) {
        int i;
        c cVar = this.e;
        a[] aVarArr = this.a;
        com.smartdigimkt.x0.k kVar = mVar.c;
        int i2 = cVar.f;
        if (i2 == -1) {
            int i3 = 0;
            for (int i4 = 0; i4 < aVarArr.length; i4++) {
                if (kVar.b[i4] != null) {
                    int i5 = aVarArr[i4].a;
                    int i6 = com.smartdigimkt.z0.u.a;
                    if (i5 == 0) {
                        i = 16777216;
                    } else if (i5 == 1) {
                        i = 3538944;
                    } else if (i5 == 2) {
                        i = 13107200;
                    } else {
                        if (i5 != 3 && i5 != 4) {
                            throw new IllegalStateException();
                        }
                        i = 131072;
                    }
                    i3 += i;
                }
            }
            i2 = i3;
        }
        cVar.h = i2;
        cVar.a.a(i2);
    }

    public final void a(m mVar) throws g {
        Object obj;
        boolean zA;
        if (mVar.a != this.s) {
            return;
        }
        z zVar = this.r;
        m0 m0Var = zVar.c;
        m0 m0Var2 = mVar.b;
        Object obj2 = mVar.c;
        this.p.d = m0Var2;
        z zVar2 = new z(m0Var2, obj2, zVar.e, zVar.f, zVar.g, zVar.h, zVar.i, zVar.j, zVar.k);
        zVar2.a = zVar.a;
        zVar2.b = zVar.b;
        this.r = zVar2;
        int size = this.n.size() - 1;
        if (size < 0) {
            Collections.sort(this.n);
            int i = this.z;
            if (i > 0) {
                this.m.b += i;
                this.z = 0;
                o oVar = this.A;
                if (oVar != null) {
                    Pair pairA = a(oVar, true);
                    this.A = null;
                    if (pairA == null) {
                        b(4);
                        a(false, true, false);
                        return;
                    } else {
                        int iIntValue = ((Integer) pairA.first).intValue();
                        long jLongValue = ((Long) pairA.second).longValue();
                        com.smartdigimkt.v0.m mVarA = this.p.a(iIntValue, jLongValue);
                        this.r = this.r.a(mVarA, mVarA.a() ? 0L : jLongValue, jLongValue);
                        return;
                    }
                }
                if (this.r.f == -9223372036854775807L) {
                    if (m0Var2.c()) {
                        b(4);
                        a(false, true, false);
                        return;
                    }
                    Pair pairA2 = m0Var2.a(this.j, this.k, m0Var2.c() ? -1 : 0, -9223372036854775807L, 0L);
                    int iIntValue2 = ((Integer) pairA2.first).intValue();
                    long jLongValue2 = ((Long) pairA2.second).longValue();
                    com.smartdigimkt.v0.m mVarA2 = this.p.a(iIntValue2, jLongValue2);
                    this.r = this.r.a(mVarA2, mVarA2.a() ? 0L : jLongValue2, jLongValue2);
                    return;
                }
                return;
            }
            z zVar3 = this.r;
            int i2 = zVar3.e.a;
            long j = zVar3.g;
            if (m0Var.c()) {
                if (m0Var2.c()) {
                    return;
                }
                com.smartdigimkt.v0.m mVarA3 = this.p.a(i2, j);
                this.r = this.r.a(mVarA3, mVarA3.a() ? 0L : j, j);
                return;
            }
            v vVarB = this.p.b();
            if (vVarB == null) {
                obj = m0Var.a(i2, this.k, true).a;
            } else {
                obj = vVarB.i;
            }
            int iA = m0Var2.a(obj);
            if (iA == -1) {
                int iA2 = a(i2, m0Var, m0Var2);
                if (iA2 == -1) {
                    b(4);
                    a(false, true, false);
                    return;
                }
                Pair pairA3 = m0Var2.a(this.j, this.k, m0Var2.a(iA2, this.k, false).b, -9223372036854775807L, 0L);
                int iIntValue3 = ((Integer) pairA3.first).intValue();
                long jLongValue3 = ((Long) pairA3.second).longValue();
                com.smartdigimkt.v0.m mVarA4 = this.p.a(iIntValue3, jLongValue3);
                m0Var2.a(iIntValue3, this.k, true);
                if (vVarB != null) {
                    Object obj3 = this.k.a;
                    w wVar = vVarB.d;
                    Object obj4 = obj3;
                    vVarB.d = new w(wVar.a.a(-1), wVar.b, wVar.c, wVar.d, wVar.e, wVar.f, wVar.g);
                    while (true) {
                        vVarB = vVarB.e;
                        if (vVarB == null) {
                            break;
                        }
                        Object obj5 = obj4;
                        if (vVarB.i.equals(obj5)) {
                            x xVar = this.p;
                            w wVar2 = vVarB.d;
                            xVar.getClass();
                            vVarB.d = xVar.a(wVar2, wVar2.a.a(iIntValue3));
                        } else {
                            w wVar3 = vVarB.d;
                            vVarB.d = new w(wVar3.a.a(-1), wVar3.b, wVar3.c, wVar3.d, wVar3.e, wVar3.f, wVar3.g);
                        }
                        obj4 = obj5;
                        iIntValue3 = iIntValue3;
                    }
                }
                long j2 = mVarA4.a() ? 0L : jLongValue3;
                x xVar2 = this.p;
                this.r = this.r.a(mVarA4, a(mVarA4, j2, xVar2.g != xVar2.h), jLongValue3);
                return;
            }
            if (iA != i2) {
                z zVar4 = this.r;
                z zVar5 = new z(zVar4.c, zVar4.d, zVar4.e.a(iA), zVar4.f, zVar4.g, zVar4.h, zVar4.i, zVar4.j, zVar4.k);
                zVar5.a = zVar4.a;
                zVar5.b = zVar4.b;
                this.r = zVar5;
            }
            com.smartdigimkt.v0.m mVar2 = this.r.e;
            if (mVar2.a()) {
                com.smartdigimkt.v0.m mVarA5 = this.p.a(iA, j);
                if (!mVarA5.equals(mVar2)) {
                    long j3 = mVarA5.a() ? 0L : j;
                    x xVar3 = this.p;
                    this.r = this.r.a(mVarA5, a(mVarA5, j3, xVar3.g != xVar3.h), j);
                    return;
                }
            }
            x xVar4 = this.p;
            long j4 = this.B;
            xVar4.getClass();
            int i3 = mVar2.a;
            v vVarB2 = xVar4.b();
            int iA3 = i3;
            v vVar = null;
            while (vVarB2 != null) {
                if (vVar == null) {
                    w wVar4 = vVarB2.d;
                    vVarB2.d = xVar4.a(wVar4, wVar4.a.a(iA3));
                } else {
                    if (iA3 != -1 && vVarB2.i.equals(xVar4.d.a(iA3, xVar4.a, true).a)) {
                        w wVarA = xVar4.a(vVar, j4);
                        if (wVarA == null) {
                            zA = xVar4.a(vVar);
                        } else {
                            w wVar5 = vVarB2.d;
                            w wVarA2 = xVar4.a(wVar5, wVar5.a.a(iA3));
                            vVarB2.d = wVarA2;
                            if (wVarA2.b != wVarA.b || wVarA2.c != wVarA.c || !wVarA2.a.equals(wVarA.a)) {
                                zA = xVar4.a(vVar);
                            }
                        }
                    } else {
                        zA = xVar4.a(vVar);
                    }
                    if (!zA) {
                        return;
                    }
                    a(false);
                    return;
                }
                if (vVarB2.d.f) {
                    iA3 = xVar4.d.a(iA3, xVar4.a, xVar4.b, xVar4.e, xVar4.f);
                }
                v vVar2 = vVarB2;
                vVarB2 = vVarB2.e;
                vVar = vVar2;
            }
            return;
        }
        com.smartdigimkt.a.a.a(this.n.get(size));
        throw null;
    }

    public final int a(int i, m0 m0Var, m0 m0Var2) {
        int iA = m0Var.a();
        int iA2 = i;
        int iA3 = -1;
        for (int i2 = 0; i2 < iA && iA3 == -1; i2++) {
            iA2 = m0Var.a(iA2, this.k, this.j, this.x, this.y);
            if (iA2 == -1) {
                break;
            }
            iA3 = m0Var2.a(m0Var.a(iA2, this.k, true).a);
        }
        return iA3;
    }

    public final Pair a(o oVar, boolean z) {
        int iA;
        m0 m0Var = this.r.c;
        m0 m0Var2 = oVar.a;
        if (m0Var.c()) {
            return null;
        }
        if (m0Var2.c()) {
            m0Var2 = m0Var;
        }
        try {
            Pair pairA = m0Var2.a(this.j, this.k, oVar.b, oVar.c, 0L);
            if (m0Var == m0Var2) {
                return pairA;
            }
            int iA2 = m0Var.a(m0Var2.a(((Integer) pairA.first).intValue(), this.k, true).a);
            if (iA2 != -1) {
                return Pair.create(Integer.valueOf(iA2), (Long) pairA.second);
            }
            if (!z || (iA = a(((Integer) pairA.first).intValue(), m0Var2, m0Var)) == -1) {
                return null;
            }
            return m0Var.a(this.j, this.k, m0Var.a(iA, this.k, false).b, -9223372036854775807L, 0L);
        } catch (IndexOutOfBoundsException unused) {
            throw new u();
        }
    }

    public final void a(v vVar) throws g {
        v vVar2 = this.p.g;
        if (vVar2 == null || vVar == vVar2) {
            return;
        }
        boolean[] zArr = new boolean[this.a.length];
        int i = 0;
        int i2 = 0;
        while (true) {
            a[] aVarArr = this.a;
            if (i < aVarArr.length) {
                a aVar = aVarArr[i];
                zArr[i] = aVar.c != 0;
                if (vVar2.g.a(i)) {
                    i2++;
                }
                if (zArr[i] && (!vVar2.g.a(i) || (aVar.h && aVar.d == vVar.j[i]))) {
                    a(aVar);
                }
                i++;
            } else {
                z zVar = this.r;
                z zVar2 = new z(zVar.c, zVar.d, zVar.e, zVar.f, zVar.g, zVar.h, zVar.i, vVar2.f, vVar2.g);
                zVar2.a = zVar.a;
                zVar2.b = zVar.b;
                this.r = zVar2;
                a(zArr, i2);
                return;
            }
        }
    }

    public final void a(boolean[] zArr, int i) throws g {
        int i2;
        com.smartdigimkt.z0.h hVar;
        this.t = new a[i];
        v vVar = this.p.g;
        int i3 = 0;
        int i4 = 0;
        while (i3 < this.a.length) {
            if (vVar.g.a(i3)) {
                boolean z = zArr[i3];
                int i5 = i4 + 1;
                v vVar2 = this.p.g;
                a aVar = this.a[i3];
                this.t[i4] = aVar;
                if (aVar.c == 0) {
                    com.smartdigimkt.x0.m mVar = vVar2.g;
                    f0 f0Var = mVar.b[i3];
                    com.smartdigimkt.x0.h hVar2 = mVar.c.b[i3];
                    int length = hVar2 != null ? hVar2.b.length : 0;
                    s[] sVarArr = new s[length];
                    for (int i6 = 0; i6 < length; i6++) {
                        sVarArr[i6] = hVar2.c[i6];
                    }
                    boolean z2 = this.v && this.r.h == 3;
                    boolean z3 = !z && z2;
                    com.smartdigimkt.v0.f0 f0Var2 = vVar2.j[i3];
                    long j = this.B;
                    i2 = i3;
                    long j2 = vVar2.a;
                    if (aVar.c == 0) {
                        aVar.b = f0Var;
                        aVar.c = 1;
                        aVar.g();
                        if (!aVar.h) {
                            aVar.d = f0Var2;
                            aVar.g = false;
                            aVar.e = sVarArr;
                            aVar.f = j2;
                            aVar.a(sVarArr, j2);
                            aVar.a(j, z3);
                            e eVar = this.l;
                            eVar.getClass();
                            com.smartdigimkt.z0.h hVarC = aVar.c();
                            if (hVarC != null && hVarC != (hVar = eVar.d)) {
                                if (hVar == null) {
                                    eVar.d = hVarC;
                                    eVar.c = aVar;
                                    ((com.smartdigimkt.k0.a0) ((com.smartdigimkt.k0.d0) hVarC).T).a(eVar.a.e);
                                    eVar.a.a(eVar.d.b());
                                    a0 a0VarA = eVar.d.a();
                                    if (!a0VarA.equals(eVar.a.e)) {
                                        eVar.a.a(a0VarA);
                                        ((p) eVar.b).a(a0VarA);
                                    }
                                } else {
                                    throw new g(2, new IllegalStateException("Multiple renderer media clocks enabled."));
                                }
                            }
                            if (z2) {
                                if (aVar.c == 1) {
                                    aVar.c = 2;
                                    aVar.h();
                                } else {
                                    throw new IllegalStateException();
                                }
                            }
                        } else {
                            throw new IllegalStateException();
                        }
                    } else {
                        throw new IllegalStateException();
                    }
                } else {
                    i2 = i3;
                }
                i4 = i5;
            } else {
                i2 = i3;
            }
            i3 = i2 + 1;
        }
    }
}
