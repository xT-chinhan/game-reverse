package com.smartdigimkt.b2;

import com.smartdigimkt.n1.g2;

/* JADX INFO: loaded from: classes3.dex */
public final class f0 implements g2 {
    public final /* synthetic */ g0 a;

    public f0(g0 g0Var) {
        this.a = g0Var;
    }

    @Override // com.smartdigimkt.n1.g2
    public final boolean a() {
        boolean z;
        g0 g0Var = this.a;
        int i = g0Var.e;
        if (i == 1 || i == 2) {
            z = g0Var.m;
        } else {
            z = i != 3 ? true : !g0Var.n;
        }
        if (!z) {
            return false;
        }
        e eVar = g0Var.h;
        if (eVar != null) {
            eVar.a(4, 5);
        }
        return true;
    }
}
