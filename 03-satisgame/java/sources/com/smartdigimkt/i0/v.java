package com.smartdigimkt.i0;

/* JADX INFO: loaded from: classes3.dex */
public final class v {
    public long a;
    public boolean b;
    public boolean c;
    public w d;
    public v e;
    public com.smartdigimkt.v0.k0 f;
    public com.smartdigimkt.x0.m g;
    public final com.smartdigimkt.v0.l h;
    public final Object i;
    public final com.smartdigimkt.v0.f0[] j;
    public final boolean[] k;
    public final a[] l;
    public final com.smartdigimkt.x0.l m;
    public final com.smartdigimkt.v0.j n;
    public com.smartdigimkt.x0.m o;

    public v(a[] aVarArr, long j, com.smartdigimkt.x0.l lVar, com.smartdigimkt.y0.l lVar2, com.smartdigimkt.v0.j jVar, Object obj, w wVar) {
        com.smartdigimkt.v0.l bVar;
        this.l = aVarArr;
        this.a = j - wVar.b;
        this.m = lVar;
        this.n = jVar;
        obj.getClass();
        this.i = obj;
        this.d = wVar;
        this.j = new com.smartdigimkt.v0.f0[aVarArr.length];
        this.k = new boolean[aVarArr.length];
        com.smartdigimkt.v0.m mVar = wVar.a;
        jVar.getClass();
        if (mVar.a != 0) {
            throw new IllegalArgumentException();
        }
        com.smartdigimkt.v0.i iVar = new com.smartdigimkt.v0.i(jVar.f, jVar.g.a(), jVar.h.a(), jVar.i, new com.smartdigimkt.v0.x(jVar.b.c, mVar), jVar, lVar2, jVar.j, jVar.k);
        long j2 = wVar.c;
        if (j2 != Long.MIN_VALUE) {
            bVar = iVar;
            bVar = new com.smartdigimkt.v0.b(iVar, j2);
        }
        bVar = iVar;
        this.h = bVar;
    }

    public final long a(long j, boolean z, boolean[] zArr) {
        int i = 0;
        int i2 = 0;
        while (true) {
            com.smartdigimkt.x0.m mVar = this.g;
            boolean z2 = true;
            if (i2 >= mVar.a) {
                break;
            }
            boolean[] zArr2 = this.k;
            if (z || !mVar.a(this.o, i2)) {
                z2 = false;
            }
            zArr2[i2] = z2;
            i2++;
        }
        com.smartdigimkt.v0.f0[] f0VarArr = this.j;
        int i3 = 0;
        while (true) {
            a[] aVarArr = this.l;
            if (i3 >= aVarArr.length) {
                break;
            }
            if (aVarArr[i3].a == 5) {
                f0VarArr[i3] = null;
            }
            i3++;
        }
        a(this.g);
        com.smartdigimkt.x0.k kVar = this.g.c;
        long jA = this.h.a((com.smartdigimkt.x0.h[]) kVar.b.clone(), this.k, this.j, zArr, j);
        com.smartdigimkt.v0.f0[] f0VarArr2 = this.j;
        int i4 = 0;
        while (true) {
            a[] aVarArr2 = this.l;
            if (i4 >= aVarArr2.length) {
                break;
            }
            if (aVarArr2[i4].a == 5 && this.g.a(i4)) {
                f0VarArr2[i4] = new com.smartdigimkt.v0.c();
            }
            i4++;
        }
        this.c = false;
        while (true) {
            com.smartdigimkt.v0.f0[] f0VarArr3 = this.j;
            if (i >= f0VarArr3.length) {
                return jA;
            }
            if (f0VarArr3[i] != null) {
                if (!this.g.a(i)) {
                    throw new IllegalStateException();
                }
                if (this.l[i].a != 5) {
                    this.c = true;
                }
            } else if (kVar.b[i] != null) {
                throw new IllegalStateException();
            }
            i++;
        }
    }

    public final boolean b() {
        com.smartdigimkt.x0.m mVarA = this.m.a(this.l, this.f);
        com.smartdigimkt.x0.m mVar = this.o;
        if (mVar != null && mVar.c.a == mVarA.c.a) {
            for (int i = 0; i < mVarA.c.a; i++) {
                if (mVarA.a(mVar, i)) {
                }
            }
            return false;
        }
        this.g = mVarA;
        for (com.smartdigimkt.x0.h hVar : (com.smartdigimkt.x0.h[]) mVarA.c.b.clone()) {
        }
        return true;
    }

    public final void a() {
        a(null);
        try {
            if (this.d.c != Long.MIN_VALUE) {
                this.n.a(((com.smartdigimkt.v0.b) this.h).a);
            } else {
                this.n.a(this.h);
            }
        } catch (RuntimeException unused) {
        }
    }

    public final void a(com.smartdigimkt.x0.m mVar) {
        com.smartdigimkt.x0.m mVar2 = this.o;
        if (mVar2 != null) {
            for (int i = 0; i < mVar2.a; i++) {
                mVar2.a(i);
                com.smartdigimkt.x0.h hVar = mVar2.c.b[i];
            }
        }
        this.o = mVar;
        if (mVar != null) {
            for (int i2 = 0; i2 < mVar.a; i2++) {
                mVar.a(i2);
                com.smartdigimkt.x0.h hVar2 = mVar.c.b[i2];
            }
        }
    }
}
