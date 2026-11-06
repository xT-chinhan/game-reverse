package com.smartdigimkt.i0;

import kotlin.jvm.internal.LongCompanionObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public final int a;
    public f0 b;
    public int c;
    public com.smartdigimkt.v0.f0 d;
    public s[] e;
    public long f;
    public boolean g = true;
    public boolean h;

    public a(int i) {
        this.a = i;
    }

    public abstract int a(s sVar);

    public void a(int i, Object obj) {
    }

    public abstract void a(long j, long j2);

    public abstract void a(long j, boolean z);

    public void a(s[] sVarArr, long j) {
    }

    public com.smartdigimkt.z0.h c() {
        return null;
    }

    public abstract boolean d();

    public abstract boolean e();

    public abstract void f();

    public void g() {
    }

    public void h() {
    }

    public void i() {
    }

    public int j() {
        return 0;
    }

    public final int a(t tVar, com.smartdigimkt.l0.e eVar, boolean z) {
        int iA = this.d.a(tVar, eVar, z);
        if (iA == -4) {
            if (eVar.b(4)) {
                this.g = true;
                return this.h ? -4 : -3;
            }
            eVar.c += this.f;
        } else if (iA == -5) {
            s sVar = tVar.a;
            long j = sVar.j;
            if (j != LongCompanionObject.MAX_VALUE) {
                tVar.a = new s(sVar.a, sVar.e, sVar.f, sVar.c, sVar.b, sVar.g, sVar.k, sVar.l, sVar.m, sVar.n, sVar.o, sVar.q, sVar.p, sVar.r, sVar.s, sVar.t, sVar.u, sVar.v, sVar.w, sVar.x, sVar.y, sVar.z, j + this.f, sVar.h, sVar.i, sVar.d);
            }
        }
        return iA;
    }
}
