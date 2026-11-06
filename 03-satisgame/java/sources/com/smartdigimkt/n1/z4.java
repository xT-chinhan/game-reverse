package com.smartdigimkt.n1;

import com.smartdigimkt.sdk.basead.ui.ShakeNativeBorderThumbView;

/* JADX INFO: loaded from: classes3.dex */
public final class z4 implements com.smartdigimkt.d1.a {
    public final /* synthetic */ g2 a;
    public final /* synthetic */ ShakeNativeBorderThumbView b;

    public z4(ShakeNativeBorderThumbView shakeNativeBorderThumbView, g2 g2Var) {
        this.b = shakeNativeBorderThumbView;
        this.a = g2Var;
    }

    @Override // com.smartdigimkt.d1.a
    public final boolean a() {
        String str = this.b.p;
        g2 g2Var = this.a;
        if (g2Var == null) {
            return false;
        }
        boolean zA = g2Var.a();
        if (zA) {
            this.b.unRegisterShakeListener();
        }
        return zA;
    }
}
