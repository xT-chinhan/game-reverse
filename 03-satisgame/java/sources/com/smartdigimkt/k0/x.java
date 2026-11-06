package com.smartdigimkt.k0;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class x implements w {
    public final e[] a;
    public final f0 b;
    public final h0 c;

    public x(e... eVarArr) {
        e[] eVarArr2 = (e[]) Arrays.copyOf(eVarArr, eVarArr.length + 2);
        this.a = eVarArr2;
        f0 f0Var = new f0();
        this.b = f0Var;
        h0 h0Var = new h0();
        this.c = h0Var;
        eVarArr2[eVarArr.length] = f0Var;
        eVarArr2[eVarArr.length + 1] = h0Var;
    }

    public final com.smartdigimkt.i0.a0 a(com.smartdigimkt.i0.a0 a0Var) {
        f0 f0Var = this.b;
        f0Var.e = a0Var.c;
        f0Var.flush();
        h0 h0Var = this.c;
        float f = a0Var.a;
        h0Var.getClass();
        int i = com.smartdigimkt.z0.u.a;
        float fMax = Math.max(0.1f, Math.min(f, 8.0f));
        if (h0Var.d != fMax) {
            h0Var.d = fMax;
            h0Var.h = null;
        }
        h0Var.flush();
        h0 h0Var2 = this.c;
        float f2 = a0Var.b;
        h0Var2.getClass();
        float fMax2 = Math.max(0.1f, Math.min(f2, 8.0f));
        if (h0Var2.e != fMax2) {
            h0Var2.e = fMax2;
            h0Var2.h = null;
        }
        h0Var2.flush();
        return new com.smartdigimkt.i0.a0(fMax, fMax2, a0Var.c);
    }
}
