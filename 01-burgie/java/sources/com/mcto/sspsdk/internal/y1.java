package com.mcto.sspsdk.internal;

import com.mcto.sspsdk.IQyBanner;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class y1 implements qa {
    public final /* synthetic */ z1 a;

    public y1(z1 z1Var) {
        this.a = z1Var;
    }

    @Override // com.mcto.sspsdk.internal.qa
    public final void a(b4 b4Var) {
        IQyBanner.IAdInteractionListener iAdInteractionListener;
        z3 z3Var = b4Var.a;
        z3 z3Var2 = z3Var == null ? z3.GRAPHIC : z3Var;
        if (z3.NEGATIVE == z3Var2 || z3.CLOSE == z3Var2) {
            this.a.c.onAdClose();
            this.a.destroy();
            return;
        }
        p pVar = this.a.a;
        z3 z3Var3 = z3.SHAKE_TEMPLATE;
        if (z3Var == null) {
            z3Var = z3.GRAPHIC;
        }
        int iIntValue = pVar.c(z3Var3 == z3Var ? 4 : 0).intValue();
        l lVarA = l.a();
        z1 z1Var = this.a;
        p pVar2 = z1Var.a;
        HashMap mapA = gj.a(b4Var, z1Var.b);
        lVarA.getClass();
        l.a(21, pVar2, mapA);
        if (!this.a.a.n()) {
            if (z3Var2 != z3.BUTTON) {
                q2 q2Var = this.a.h;
            }
            z1 z1Var2 = this.a;
            if (y3.a(z1Var2.d, z1Var2.a, b4Var) == 4) {
                l lVarA2 = l.a();
                p pVar3 = this.a.a;
                lVarA2.getClass();
                l.a(25, pVar3, null);
            }
        }
        if (iIntValue == 0 || (iAdInteractionListener = this.a.c) == null) {
            return;
        }
        iAdInteractionListener.onAdClick();
    }

    @Override // com.mcto.sspsdk.internal.qa
    public final void a(int i) {
        if (i == 1) {
            z1 z1Var = this.a;
            IQyBanner.IAdInteractionListener iAdInteractionListener = z1Var.c;
            if (iAdInteractionListener != null) {
                iAdInteractionListener.onRenderSuccess();
            } else {
                z1Var.e.set(true);
            }
        }
    }
}
