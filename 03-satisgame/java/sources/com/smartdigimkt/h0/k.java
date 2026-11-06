package com.smartdigimkt.h0;

import com.smartdigimkt.n1.g2;
import com.smartdigimkt.n1.x1;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements com.smartdigimkt.d1.a {
    public final /* synthetic */ l a;

    public k(l lVar) {
        this.a = lVar;
    }

    @Override // com.smartdigimkt.d1.a
    public final boolean a() {
        g2 g2Var;
        x1 x1Var = (x1) this.a;
        if (!x1Var.c.hasWindowFocus() || !x1Var.c.isShown() || (g2Var = x1Var.c.k) == null) {
            return false;
        }
        boolean zA = g2Var.a();
        if (!zA) {
            return zA;
        }
        x1Var.c.unRegisterShakeListener();
        return zA;
    }
}
