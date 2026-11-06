package com.smartdigimkt.i0;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes3.dex */
public final class j {
    public final z a;
    public final Set b;
    public final com.smartdigimkt.x0.l c;
    public final boolean d;
    public final int e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final boolean j;

    public j(z zVar, z zVar2, CopyOnWriteArraySet copyOnWriteArraySet, com.smartdigimkt.x0.l lVar, boolean z, int i, int i2, boolean z2, boolean z3, boolean z4) {
        this.a = zVar;
        this.b = copyOnWriteArraySet;
        this.c = lVar;
        this.d = z;
        this.e = i2;
        this.f = z2;
        this.g = z4 || zVar2.h != zVar.h;
        this.h = (zVar2.c == zVar.c && zVar2.d == zVar.d) ? false : true;
        this.i = zVar2.i != zVar.i;
        this.j = zVar2.k != zVar.k;
    }

    public final void a() {
        if (this.h || this.e == 0) {
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                ((c0) it.next()).a(this.a.c);
            }
        }
        if (this.d) {
            Iterator it2 = this.b.iterator();
            while (it2.hasNext()) {
                ((c0) it2.next()).e();
            }
        }
        if (this.j) {
            com.smartdigimkt.x0.l lVar = this.c;
            Object obj = this.a.k.d;
            ((com.smartdigimkt.x0.j) lVar).getClass();
            for (c0 c0Var : this.b) {
                z zVar = this.a;
                com.smartdigimkt.v0.k0 k0Var = zVar.j;
                com.smartdigimkt.x0.k kVar = zVar.k.c;
                c0Var.d();
            }
        }
        if (this.i) {
            for (c0 c0Var2 : this.b) {
                boolean z = this.a.i;
                c0Var2.c();
            }
        }
        if (this.g) {
            Iterator it3 = this.b.iterator();
            while (it3.hasNext()) {
                ((c0) it3.next()).a(this.a.h);
            }
        }
        if (this.f) {
            Iterator it4 = this.b.iterator();
            while (it4.hasNext()) {
                ((c0) it4.next()).a();
            }
        }
    }
}
