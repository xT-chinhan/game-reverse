package com.smartdigimkt.n1;

import com.smartdigimkt.sdk.basead.ui.SplashEndCardView;

/* JADX INFO: loaded from: classes3.dex */
public final class d6 implements com.smartdigimkt.i2.k {
    public final /* synthetic */ SplashEndCardView a;

    public d6(SplashEndCardView splashEndCardView) {
        this.a = splashEndCardView;
    }

    @Override // com.smartdigimkt.i2.k
    public final void a(int i, int i2) {
        p0 p0Var = this.a.mListener;
        if (p0Var != null) {
            p0Var.a(i2);
        }
    }
}
