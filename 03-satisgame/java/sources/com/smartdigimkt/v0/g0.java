package com.smartdigimkt.v0;

import com.smartdigimkt.i0.m0;

/* JADX INFO: loaded from: classes3.dex */
public final class g0 extends m0 {
    public static final Object e = new Object();
    public final long b;
    public final long c;
    public final Object d;

    public g0(long j, boolean z, Object obj) {
        this.b = j;
        this.c = j;
        this.d = obj;
    }

    @Override // com.smartdigimkt.i0.m0
    public final int a() {
        return 1;
    }

    @Override // com.smartdigimkt.i0.m0
    public final com.smartdigimkt.i0.l0 a(int i, com.smartdigimkt.i0.l0 l0Var, long j) {
        if (i < 0 || i >= 1) {
            throw new IndexOutOfBoundsException();
        }
        long j2 = this.c;
        l0Var.a = null;
        l0Var.b = false;
        l0Var.e = 0L;
        l0Var.f = j2;
        l0Var.c = 0;
        l0Var.d = 0;
        l0Var.g = 0L;
        return l0Var;
    }

    @Override // com.smartdigimkt.i0.m0
    public final int b() {
        return 1;
    }

    @Override // com.smartdigimkt.i0.m0
    public final com.smartdigimkt.i0.k0 a(int i, com.smartdigimkt.i0.k0 k0Var, boolean z) {
        if (i >= 0 && i < 1) {
            Object obj = z ? e : null;
            long j = this.b;
            k0Var.getClass();
            com.smartdigimkt.w0.b bVar = com.smartdigimkt.w0.b.d;
            k0Var.a = obj;
            k0Var.b = 0;
            k0Var.c = j;
            k0Var.d = 0L;
            k0Var.e = bVar;
            return k0Var;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // com.smartdigimkt.i0.m0
    public final int a(Object obj) {
        return e.equals(obj) ? 0 : -1;
    }
}
