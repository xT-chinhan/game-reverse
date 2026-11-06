package com.smartdigimkt.n1;

import com.smartdigimkt.sdk.basead.ui.SplashEndCardView;

/* JADX INFO: loaded from: classes3.dex */
public final class e6 implements g2 {
    public final /* synthetic */ SplashEndCardView a;

    public e6(SplashEndCardView splashEndCardView) {
        this.a = splashEndCardView;
    }

    @Override // com.smartdigimkt.n1.g2
    public final boolean a() {
        p0 p0Var = this.a.mListener;
        if (p0Var == null) {
            return false;
        }
        p0Var.a(9);
        return true;
    }
}
