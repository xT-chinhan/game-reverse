package com.smartdigimkt.j0;

import android.os.SystemClock;
import android.view.Surface;
import com.smartdigimkt.a1.t;
import com.smartdigimkt.i0.c0;
import com.smartdigimkt.i0.h;
import com.smartdigimkt.i0.k;
import com.smartdigimkt.i0.l0;
import com.smartdigimkt.i0.m0;
import com.smartdigimkt.i0.s;
import com.smartdigimkt.k0.m;
import com.smartdigimkt.q0.g;
import com.smartdigimkt.z0.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements c0, g, m, t {
    public final CopyOnWriteArraySet a;
    public final com.smartdigimkt.z0.c b;
    public final l0 c;
    public final a d;
    public final h e;

    public c(k kVar) {
        p pVar = com.smartdigimkt.z0.c.a;
        this.e = kVar;
        this.b = pVar;
        this.a = new CopyOnWriteArraySet();
        this.d = new a();
        this.c = new l0();
    }

    @Override // com.smartdigimkt.q0.g
    public final void a(com.smartdigimkt.q0.c cVar) {
        f();
        Iterator it = this.a.iterator();
        if (it.hasNext()) {
            throw com.smartdigimkt.x.d.a(it);
        }
    }

    @Override // com.smartdigimkt.k0.m
    public final void b(int i) {
        g();
        Iterator it = this.a.iterator();
        if (it.hasNext()) {
            throw com.smartdigimkt.x.d.a(it);
        }
    }

    @Override // com.smartdigimkt.i0.c0
    public final void c() {
        f();
        Iterator it = this.a.iterator();
        if (it.hasNext()) {
            throw com.smartdigimkt.x.d.a(it);
        }
    }

    @Override // com.smartdigimkt.k0.m
    public final void d(com.smartdigimkt.l0.d dVar) {
        f();
        Iterator it = this.a.iterator();
        if (it.hasNext()) {
            throw com.smartdigimkt.x.d.a(it);
        }
    }

    @Override // com.smartdigimkt.i0.c0
    public final void e() {
        a aVar = this.d;
        if (!aVar.a.isEmpty()) {
            aVar.c = (b) aVar.a.get(0);
        }
        f();
        Iterator it = this.a.iterator();
        if (it.hasNext()) {
            throw com.smartdigimkt.x.d.a(it);
        }
    }

    public final void f() {
        a aVar = this.d;
        a((aVar.a.isEmpty() || aVar.e.c() || aVar.f) ? null : (b) aVar.a.get(0));
    }

    public final void g() {
        a(this.d.d);
    }

    @Override // com.smartdigimkt.k0.m
    public final void c(com.smartdigimkt.l0.d dVar) {
        a(this.d.c);
        Iterator it = this.a.iterator();
        if (it.hasNext()) {
            throw com.smartdigimkt.x.d.a(it);
        }
    }

    @Override // com.smartdigimkt.k0.m
    public final void a(String str, long j, long j2) {
        g();
        Iterator it = this.a.iterator();
        if (it.hasNext()) {
            throw com.smartdigimkt.x.d.a(it);
        }
    }

    @Override // com.smartdigimkt.i0.c0
    public final void d() {
        f();
        Iterator it = this.a.iterator();
        if (it.hasNext()) {
            throw com.smartdigimkt.x.d.a(it);
        }
    }

    @Override // com.smartdigimkt.k0.m
    public final void b(s sVar) {
        g();
        Iterator it = this.a.iterator();
        if (it.hasNext()) {
            throw com.smartdigimkt.x.d.a(it);
        }
    }

    @Override // com.smartdigimkt.k0.m
    public final void a(int i, long j, long j2) {
        g();
        Iterator it = this.a.iterator();
        if (it.hasNext()) {
            throw com.smartdigimkt.x.d.a(it);
        }
    }

    @Override // com.smartdigimkt.a1.t
    public final void b(String str, long j, long j2) {
        g();
        Iterator it = this.a.iterator();
        if (it.hasNext()) {
            throw com.smartdigimkt.x.d.a(it);
        }
    }

    @Override // com.smartdigimkt.a1.t
    public final void a(com.smartdigimkt.l0.d dVar) {
        f();
        Iterator it = this.a.iterator();
        if (it.hasNext()) {
            throw com.smartdigimkt.x.d.a(it);
        }
    }

    public final void b(int i, com.smartdigimkt.v0.m mVar) {
        a aVar = this.d;
        aVar.getClass();
        b bVar = new b(i, mVar);
        aVar.a.remove(bVar);
        if (bVar.equals(aVar.d)) {
            aVar.d = aVar.a.isEmpty() ? null : (b) aVar.a.get(0);
        }
        a(i, mVar);
        Iterator it = this.a.iterator();
        if (it.hasNext()) {
            com.smartdigimkt.a.a.a(it.next());
            throw null;
        }
    }

    @Override // com.smartdigimkt.i0.c0
    public final void b() {
        f();
        Iterator it = this.a.iterator();
        if (it.hasNext()) {
            throw com.smartdigimkt.x.d.a(it);
        }
    }

    @Override // com.smartdigimkt.a1.t
    public final void b(com.smartdigimkt.l0.d dVar) {
        a(this.d.c);
        Iterator it = this.a.iterator();
        if (it.hasNext()) {
            throw com.smartdigimkt.x.d.a(it);
        }
    }

    @Override // com.smartdigimkt.a1.t
    public final void a(s sVar) {
        g();
        Iterator it = this.a.iterator();
        if (it.hasNext()) {
            throw com.smartdigimkt.x.d.a(it);
        }
    }

    @Override // com.smartdigimkt.a1.t
    public final void a(int i, int i2, int i3, float f) {
        g();
        Iterator it = this.a.iterator();
        if (it.hasNext()) {
            throw com.smartdigimkt.x.d.a(it);
        }
    }

    @Override // com.smartdigimkt.a1.t
    public final void a(Surface surface) {
        g();
        Iterator it = this.a.iterator();
        if (it.hasNext()) {
            throw com.smartdigimkt.x.d.a(it);
        }
    }

    @Override // com.smartdigimkt.i0.c0
    public final void a(m0 m0Var) {
        a aVar = this.d;
        for (int i = 0; i < aVar.a.size(); i++) {
            ArrayList arrayList = aVar.a;
            arrayList.set(i, aVar.a((b) arrayList.get(i), m0Var));
        }
        b bVar = aVar.d;
        if (bVar != null) {
            aVar.d = aVar.a(bVar, m0Var);
        }
        aVar.e = m0Var;
        if (!aVar.a.isEmpty()) {
            aVar.c = (b) aVar.a.get(0);
        }
        f();
        Iterator it = this.a.iterator();
        if (it.hasNext()) {
            throw com.smartdigimkt.x.d.a(it);
        }
    }

    @Override // com.smartdigimkt.i0.c0
    public final void a(int i) {
        f();
        Iterator it = this.a.iterator();
        if (it.hasNext()) {
            throw com.smartdigimkt.x.d.a(it);
        }
    }

    @Override // com.smartdigimkt.i0.c0
    public final void a(com.smartdigimkt.i0.g gVar) {
        f();
        Iterator it = this.a.iterator();
        if (it.hasNext()) {
            throw com.smartdigimkt.x.d.a(it);
        }
    }

    @Override // com.smartdigimkt.i0.c0
    public final void a() {
        a aVar = this.d;
        if (aVar.f) {
            aVar.f = false;
            if (!aVar.a.isEmpty()) {
                aVar.c = (b) aVar.a.get(0);
            }
            f();
            Iterator it = this.a.iterator();
            if (it.hasNext()) {
                throw com.smartdigimkt.x.d.a(it);
            }
        }
    }

    public final d a(int i, com.smartdigimkt.v0.m mVar) {
        this.e.getClass();
        ((p) this.b).getClass();
        SystemClock.elapsedRealtime();
        m0 m0VarE = this.e.e();
        if (i == this.e.c()) {
            if (mVar != null && mVar.a()) {
                if (this.e.g() == mVar.b && this.e.a() == mVar.c) {
                    this.e.f();
                }
            } else {
                this.e.b();
            }
        } else if (i < m0VarE.b() && (mVar == null || !mVar.a())) {
            long j = m0VarE.a(i, this.c, 0L).e;
            int i2 = com.smartdigimkt.i0.b.a;
        }
        this.e.d();
        this.e.b();
        this.e.f();
        return new d();
    }

    public final d a(b bVar) {
        if (bVar == null) {
            h hVar = this.e;
            hVar.getClass();
            int iC = hVar.c();
            a aVar = this.d;
            m0 m0Var = aVar.e;
            com.smartdigimkt.v0.m mVar = null;
            if (m0Var != null) {
                int iA = m0Var.a();
                com.smartdigimkt.v0.m mVar2 = null;
                for (int i = 0; i < aVar.a.size(); i++) {
                    b bVar2 = (b) aVar.a.get(i);
                    int i2 = bVar2.b.a;
                    if (i2 < iA && aVar.e.a(i2, aVar.b, false).b == iC) {
                        if (mVar2 == null) {
                            mVar2 = bVar2.b;
                        }
                    }
                }
                mVar = mVar2;
            }
            return a(iC, mVar);
        }
        return a(bVar.a, bVar.b);
    }

    @Override // com.smartdigimkt.a1.t
    public final void a(int i, long j) {
        a(this.d.c);
        Iterator it = this.a.iterator();
        if (it.hasNext()) {
            throw com.smartdigimkt.x.d.a(it);
        }
    }
}
